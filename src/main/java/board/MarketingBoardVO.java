package board;

public class MarketingBoardVO {

	private int idx;
	private String mid;
	private String nickName;
	private String title;
	private String part;
	private String content;
	private String hostIp;
	private String openSw;
	private int viewCnt;
	private String wDate;
	private String claim;
	private String file;
	private int good;
	
	int getIdx() {
		return idx;
	}
	void setIdx(int idx) {
		this.idx = idx;
	}
	String getMid() {
		return mid;
	}
	void setMid(String mid) {
		this.mid = mid;
	}
	String getNickName() {
		return nickName;
	}
	void setNickName(String nickName) {
		this.nickName = nickName;
	}
	String getTitle() {
		return title;
	}
	void setTitle(String title) {
		this.title = title;
	}
	String getPart() {
		return part;
	}
	void setPart(String part) {
		this.part = part;
	}
	String getContent() {
		return content;
	}
	void setContent(String content) {
		this.content = content;
	}
	String getHostIp() {
		return hostIp;
	}
	void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	String getOpenSw() {
		return openSw;
	}
	void setOpenSw(String openSw) {
		this.openSw = openSw;
	}
	int getViewCnt() {
		return viewCnt;
	}
	void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	String getwDate() {
		return wDate;
	}
	void setwDate(String wDate) {
		this.wDate = wDate;
	}
	String getClaim() {
		return claim;
	}
	void setClaim(String claim) {
		this.claim = claim;
	}
	String getFile() {
		return file;
	}
	void setFile(String file) {
		this.file = file;
	}
	int getGood() {
		return good;
	}
	void setGood(int good) {
		this.good = good;
	}
	
	@Override
	public String toString() {
		return "MarketingBoardVO [idx=" + idx + ", mid=" + mid + ", nickName=" + nickName + ", title=" + title + ", part="
				+ part + ", content=" + content + ", hostIp=" + hostIp + ", openSw=" + openSw + ", viewCnt=" + viewCnt
				+ ", wDate=" + wDate + ", claim=" + claim + ", file=" + file + ", good=" + good + "]";
	}
	
}
