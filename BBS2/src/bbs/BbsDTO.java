package bbs;

public class BbsDTO {
	private int bbsID;
	private String bbsTitle;
	private String userID;
	private String bbsDate;
	private String bbsContent;
	private int bbsAvailable;
	
	
	public int getBbsID() {
		return bbsID;
	}
	public void setBbsID(int bbsID) {
		this.bbsID = bbsID;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBbsDate() {
		return bbsDate;
	}
	public void setBbsDate(String bbsDate) {
		this.bbsDate = bbsDate;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public int getBbsAvailable() {
		return bbsAvailable;
	}
	public void setBbsAvaliable(int bbsAvailable) {
		this.bbsAvailable = bbsAvailable;
	}
	
	public BbsDTO() {
		
	}
	
	public BbsDTO(String bbsTitle, String userID, String bbsContent) {
		super();
		this.bbsTitle = bbsTitle;
		this.userID = userID;
		this.bbsContent = bbsContent;

	}
	public BbsDTO(String bbsTitle, String userID, int bbsID, String bbsContent) {
		super();
		this.bbsTitle = bbsTitle;
		this.bbsID = bbsID;
		this.userID = userID;
		this.bbsContent = bbsContent;
	}
	public BbsDTO(int bbsID, String bbsTitle, String userID, String bbsDate, String bbsContent, int bbsAvailable) {
		super();
		this.bbsID = bbsID;
		this.bbsTitle = bbsTitle;
		this.userID = userID;
		this.bbsDate = bbsDate;
		this.bbsContent = bbsContent;
		this.bbsAvailable = bbsAvailable;
	}
	
}
