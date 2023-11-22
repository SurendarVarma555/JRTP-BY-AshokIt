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
import org.springframework.data.domain.Example;
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

        AppEntity app = new AppEntity();
        app.setCaseNum(caseNum);

        CoEntity coEntity = new CoEntity();
        coEntity.setApp(app);
        coEntity.setNoticeStatus(status);

        Example<CoEntity> of = Example.of(coEntity);
        List<CoEntity> entities = coRepo.findAll(of);

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

        //get Eligibility data

        AppEntity app = new AppEntity();
        app.setCaseNum(caseNum);

        EligDtlsEntity edEntity = new EligDtlsEntity();
        edEntity.setApp(app);

        List<EligDtlsEntity> edRecords = eligDtlsRepo.findAll(Example.of(edEntity));
        EligDtlsEntity eligDtlsEntity = edRecords.get(0);

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
