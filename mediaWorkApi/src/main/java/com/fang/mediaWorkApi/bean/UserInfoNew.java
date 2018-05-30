package com.fang.mediaWorkApi.bean;

import java.util.Date;

public class UserInfoNew {
    private Integer usernewid;

    private String username;

    private String realname;

    private String email;

    private Integer oauserid;

    private Integer jobstate;

    private Date adddate;

    private Integer isdetete;

    public Integer getUsernewid() {
        return usernewid;
    }

    public void setUsernewid(Integer usernewid) {
        this.usernewid = usernewid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getOauserid() {
        return oauserid;
    }

    public void setOauserid(Integer oauserid) {
        this.oauserid = oauserid;
    }

    public Integer getJobstate() {
        return jobstate;
    }

    public void setJobstate(Integer jobstate) {
        this.jobstate = jobstate;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public Integer getIsdetete() {
        return isdetete;
    }

    public void setIsdetete(Integer isdetete) {
        this.isdetete = isdetete;
    }
}