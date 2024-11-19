package board;

public class AnnoBoardVO {

	private int idx;
	private String mid;
	private String nickName;
	private String title;
	private String content;
	private int viewCnt;
	private String wDate;
	private String file;
	
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
	String getContent() {
		return content;
	}
	void setContent(String content) {
		this.content = content;
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
	String getFile() {
		return file;
	}
	void setFile(String file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		return "AnnoBoardVO [idx=" + idx + ", mid=" + mid + ", nickName=" + nickName + ", title=" + title + ", content="
				+ content + ", viewCnt=" + viewCnt + ", wDate=" + wDate + ", file=" + file + "]";
	}
	
}
