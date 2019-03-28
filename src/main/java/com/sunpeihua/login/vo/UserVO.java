package com.sunpeihua.login.vo;

import com.sunpeihua.login.entity.UserEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: sunpeihua
 * @create: 2019/3/28 23:17
 **/
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1878260876776799007L;

    private String id;
    private String username;
    private String password;
    private String email;
    private Date created;
    private Date updated;
    private Date lastLogin;

    public UserVO() {
    }

    public UserVO(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
        this.email = userEntity.getEmail();
        this.created = userEntity.getCreated();
        this.updated = userEntity.getUpdated();
        this.lastLogin = userEntity.getLastLogin();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
