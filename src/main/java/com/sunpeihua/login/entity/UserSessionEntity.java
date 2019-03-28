package com.sunpeihua.login.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: sunpeihua
 * @create: 2019/3/28 22:22
 **/
@Entity
@Table(name = "user_session")
public class UserSessionEntity implements Serializable {

    private static final long serialVersionUID = 1021705047443355815L;

    @Id
    @GeneratedValue(generator = "hibernate.uuid")
    @GenericGenerator(name = "hibernate.uuid", strategy = "uuid")
    private String id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, optional = false, targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false)
    @Type(type = "yes_no")
    private boolean delflag = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    @CreatedDate
    private Date created;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public boolean isDelflag() {
        return delflag;
    }

    public void setDelflag(boolean delflag) {
        this.delflag = delflag;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
