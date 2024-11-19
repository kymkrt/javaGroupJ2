package member;

public class MemberVO {
	
	private int idx;
	private String mid;
	private String pwd;
	private String nickName;
	private String name;
	private String telMain;
	private String telSub;
	private String address;
	private String email;
	private String content;
	private String photo;
	private String advertiseCheck;
	private String userInfo;
	private String userType;
	private String pwdCheckQ;
	private String fax;
	private String companyName;
	private String BSNum;
	private String userDel;
	private int level;
	private int point;
	private int visitCnt;
	private int todayCnt;
	private String startDate;
	private String lastDate;
	private String memoryMid;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelMain() {
		return telMain;
	}
	public void setTelMain(String telMain) {
		this.telMain = telMain;
	}
	public String getTelSub() {
		return telSub;
	}
	public void setTelSub(String telSub) {
		this.telSub = telSub;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAdvertiseCheck() {
		return advertiseCheck;
	}
	public void setAdvertiseCheck(String advertiseCheck) {
		this.advertiseCheck = advertiseCheck;
	}
	public String getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBSNum() {
		return BSNum;
	}
	public void setBSNum(String bSNum) {
		BSNum = bSNum;
	}
	public String getUserDel() {
		return userDel;
	}
	public void setUserDel(String userDel) {
		this.userDel = userDel;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getVisitCnt() {
		return visitCnt;
	}
	public void setVisitCnt(int visitCnt) {
		this.visitCnt = visitCnt;
	}
	public int getTodayCnt() {
		return todayCnt;
	}
	public void setTodayCnt(int todayCnt) {
		this.todayCnt = todayCnt;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String getMemoryMid() {
		return memoryMid;
	}
	public void setMemoryMid(String memoryMid) {
		this.memoryMid = memoryMid;
	}
	public String getPwdCheckQ() {
		return pwdCheckQ;
	}
	public void setPwdCheckQ(String pwdCheckQ) {
		this.pwdCheckQ = pwdCheckQ;
	}
	
	@Override
	public String toString() {
		return "MemberVO [idx=" + idx + ", mid=" + mid + ", pwd=" + pwd + ", nickName=" + nickName + ", name=" + name
				+ ", telMain=" + telMain + ", telSub=" + telSub + ", address=" + address + ", email=" + email + ", content="
				+ content + ", photo=" + photo + ", advertiseCheck=" + advertiseCheck + ", userInfo=" + userInfo + ", userType="
				+ userType + ", pwdCheckQ=" + pwdCheckQ + ", fax=" + fax + ", companyName=" + companyName + ", BSNum=" + BSNum
				+ ", userDel=" + userDel + ", level=" + level + ", point=" + point + ", visitCnt=" + visitCnt + ", todayCnt="
				+ todayCnt + ", startDate=" + startDate + ", lastDate=" + lastDate + ", memoryMid=" + memoryMid + "]";
	}
	
}
