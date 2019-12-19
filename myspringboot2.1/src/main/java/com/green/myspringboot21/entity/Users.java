package com.green.myspringboot21.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement //클래스 이름이 루트 태그가 됨
public class Users implements Serializable {
	
	private static final long serialVersionUID = 22L;
	
	@JacksonXmlProperty(localName = "User")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<User> users = new ArrayList<>();
	
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}
}
