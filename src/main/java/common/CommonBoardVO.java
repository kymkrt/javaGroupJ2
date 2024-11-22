package common;

public class CommonBoardVO {

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
	
	private String board;

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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public String getOpenSw() {
		return openSw;
	}

	public void setOpenSw(String openSw) {
		this.openSw = openSw;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getwDate() {
		return wDate;
	}

	public void setwDate(String wDate) {
		this.wDate = wDate;
	}

	public String getClaim() {
		return claim;
	}

	public void setClaim(String claim) {
		this.claim = claim;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "CommonBoardVO [idx=" + idx + ", mid=" + mid + ", nickName=" + nickName + ", title=" + title + ", part="
				+ part + ", content=" + content + ", hostIp=" + hostIp + ", openSw=" + openSw + ", viewCnt=" + viewCnt
				+ ", wDate=" + wDate + ", claim=" + claim + ", file=" + file + ", good=" + good + ", board=" + board + "]";
	}
	
}
