package org.mumsched.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="Users")
@Table(name="Users")
public class Credential {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long userid;
	private String username;
	private String password;
	@Transient
	private String confirm;
	@Transient
	private String userType;
	private Boolean enabled;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="credential",cascade=CascadeType.ALL)
	Set<Authority> roles;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Set<Authority> getRoles() {
		return roles;
	}
	public void setRoles(Set<Authority> roles) {
		this.roles = roles;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}

}
