package ch.itenengineering.websocket.chat;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	public Member() {
		super();
	}

	public Member(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

} // end
