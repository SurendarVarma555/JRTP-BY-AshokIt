package in.ashokit.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CO_NOTICES")
public class CoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer coId;

	private String noticeStatus;

	private LocalDate noticePrintDate;

	private String noticeS3Url;

	@OneToOne
	@JoinColumn(name = "case_num")
	private AppEntity app;

	public Integer getCoId (){
		return coId;
	}

	public void setCoId (Integer coId){
		this.coId = coId;
	}

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	public LocalDate getNoticePrintDate (){
		return noticePrintDate;
	}

	public void setNoticePrintDate (LocalDate noticePrintDate){
		this.noticePrintDate = noticePrintDate;
	}

	public String getNoticeS3Url() {
		return noticeS3Url;
	}

	public void setNoticeS3Url(String noticeS3Url) {
		this.noticeS3Url = noticeS3Url;
	}

	public AppEntity getApp() {
		return app;
	}

	public void setApp(AppEntity app) {
		this.app = app;
	}

}
