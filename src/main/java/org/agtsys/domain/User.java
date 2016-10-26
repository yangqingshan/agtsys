package org.agtsys.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import org.agtsys.ValidataGroups.LoginValidataGroup;
import org.agtsys.util.MD5;
import org.hibernate.validator.constraints.NotEmpty;
	public class User {
    private Long id;
    @Size(min=6,max=10,message="{user.usercode.length}")
    @NotEmpty(message="{user.usercode.isEmpty}",groups={LoginValidataGroup.class})
    private String usercode;

    private String username;
    @Size(min=6,max=10,message="{user.userpassword.length}")
    @NotEmpty(message="{user.userpassword.isEmpty}",groups={LoginValidataGroup.class})
    private String userpassword;

    private Date creationtime;

    private Date lastlogintime;

    private String createdby;

    private Date lastupdatetime;

    private Integer isstart;

    private Long roleid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword.trim().length()==0? null : MD5.md5encode(userpassword.trim());
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby == null ? null : createdby.trim();
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public Integer getIsstart() {
        return isstart;
    }

    public void setIsstart(Integer isstart) {
        this.isstart = isstart;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", usercode=" + usercode + ", username="
				+ username + ", userpassword=" + userpassword
				+ ", creationtime=" + creationtime + ", lastlogintime="
				+ lastlogintime + ", createdby=" + createdby
				+ ", lastupdatetime=" + lastupdatetime + ", isstart=" + isstart
				+ ", roleid=" + roleid + "]";
	}
    
}