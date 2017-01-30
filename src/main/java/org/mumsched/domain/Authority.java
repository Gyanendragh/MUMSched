package org.mumsched.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="User_Roles")
public class Authority {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String authority;
	@ManyToOne
	@JoinColumn(name="userid")
	private Credential credential;
	
	public Authority(){
		
	}
	public Authority(String authority){
		this.authority=authority;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Credential getCredential() {
		return credential;
	}
	public void setCredential(Credential credential) {
		this.credential = credential;
	}

}
