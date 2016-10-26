package org.agtsys.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Function {
    private Long id;

    private String functioncode;

    private String functionname;

    private Date creationtime;

    private String createdby;

    private Date lastupdatetime;

    private String funcurl;

    private Integer isstart;

    private Integer parentid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFunctioncode() {
        return functioncode;
    }

    public void setFunctioncode(String functioncode) {
        this.functioncode = functioncode == null ? null : functioncode.trim();
    }

    public String getFunctionname() {
        return functionname;
    }

    public void setFunctionname(String functionname) {
        this.functionname = functionname == null ? null : functionname.trim();
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
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

    public String getFuncurl() {
        return funcurl;
    }

    public void setFuncurl(String funcurl) {
        this.funcurl = funcurl == null ? null : funcurl.trim();
    }

    public Integer getIsstart() {
        return isstart;
    }

    public void setIsstart(Integer isstart) {
        this.isstart = isstart;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
	public EasyUINode toEasyUINode() {
		EasyUINode node=new EasyUINode();
		node.setId(this.id);
		node.setText(this.functionname);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("url", this.funcurl);
		node.setAttributes(map);
		return node;
	}

	@Override
	public String toString() {
		return "Function [id=" + id + ", functioncode=" + functioncode
				+ ", functionname=" + functionname + ", creationtime="
				+ creationtime + ", createdby=" + createdby
				+ ", lastupdatetime=" + lastupdatetime + ", funcurl=" + funcurl
				+ ", isstart=" + isstart + ", parentid=" + parentid + "]";
	}

}