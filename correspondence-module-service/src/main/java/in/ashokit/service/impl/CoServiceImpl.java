package in.ashokit.service.impl;

import in.ashokit.bindings.CoInfo;
import in.ashokit.bindings.EligInfo;
import in.ashokit.entity.AppEntity;
import in.ashokit.entity.CoEntity;
import in.ashokit.entity.EligDtlsEntity;
import in.ashokit.repository.AppRepo;
import in.ashokit.repository.CoRepo;
import in.ashokit.repository.EligDtlsRepo;
import in.ashokit.service.CoService;
import in.ashokit.utils.EmailUtils;
import in.ashokit.utils.PdfUtils;
import in.ashokit.utils.S3Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoServiceImpl implements CoService {

    @Autowired
    private CoRepo coRepo;
    @Autowired
    private AppRepo appRepo;

    @Autowired
    private EligDtlsRepo eligDtlsRepo;

    @Autowired
    private PdfUtils pdfUtils;

    @Autowired
    private S3Utils s3Utils;

    @Autowired
    private EmailUtils emailUtils;

    @Override
    public List<CoInfo> getNotices (Integer caseNum, String status){

        List<CoInfo> records = new ArrayList<>();

        List<CoEntity> entities = coRepo.fetchByCaseNum(caseNum); //Get list of entities by using custom query method

        for (CoEntity co : entities) {
            CoInfo info = new CoInfo();
            BeanUtils.copyProperties(co, info);
        }
        return records;
    }

    @Override
    public boolean printNotice (Integer noticeId){


        CoEntity coEntity = coRepo.findById(noticeId).get();
        Integer caseNum = coEntity.getApp().getCaseNum();
        AppEntity appEntity = appRepo.findById(caseNum).get();


        EligDtlsEntity eligDtlsEntity = eligDtlsRepo.fetchByCaseNum(caseNum); //To get Eligibility Record by using custom query :fetchByCaseNum

        EligInfo eligInfo = new EligInfo();
        BeanUtils.copyProperties(eligDtlsEntity, eligInfo);

        File generatePdf = pdfUtils.generatePdf(eligInfo);
        String objectUrl = s3Utils.uploadObject(generatePdf);

        coEntity.setNoticeS3Url(objectUrl);
        coEntity.setNoticePrintDate(LocalDate.now());
        coEntity.setNoticeStatus("History");

        coRepo.save(coEntity);

        String to = appEntity.getEmail();
        String subject = "";
        String body = "";

        emailUtils.sendEmail(to, subject, body, generatePdf);

        return true;
    }
}
