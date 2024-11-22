package message;

public class MessageVO {

	private int idx;
	private String sender;
	private String receiver;
	private String content;
	private String wDate;
	private int read;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getwDate() {
		return wDate;
	}
	public void setwDate(String wDate) {
		this.wDate = wDate;
	}
	public int getRead() {
		return read;
	}
	public void setRead(int read) {
		this.read = read;
	}
	
	@Override
	public String toString() {
		return "MessageVO [idx=" + idx + ", sender=" + sender + ", receiver=" + receiver + ", content=" + content
				+ ", wDate=" + wDate + ", read=" + read + "]";
	}
	
}
