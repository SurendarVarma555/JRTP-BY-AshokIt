package in.ashokit.service;

import in.ashokit.bindings.CoInfo;

import java.util.List;

public interface CoService {

    public List<CoInfo> getNotices(Integer caseNum, String status);

    public boolean printNotice(Integer noticeId);

}
