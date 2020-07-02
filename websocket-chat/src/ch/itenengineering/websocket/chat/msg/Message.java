package ch.itenengineering.websocket.chat.msg;

import ch.itenengineering.websocket.chat.Member;

public class Message {

	private Member member;
	private String content;

	public Message() {
		super();
	}

	public Message(Member member, String message) {
		this.member = member;
		this.content = message;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

} // end
