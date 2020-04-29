package cn.javasm.entity;

import java.util.List;

/**
 * 用户实体类
 */
public class UserInfo {
    private  Integer id;//用户id
    private String email;//用户邮箱
    private String username;//用户名
    private  String password;//用户密码
    private  String phoneNUm;//用户 电话
    private  Integer status;
    private List<Role> roles;//多对多，对应角色表

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }



    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    private  String statusStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhoneNUm() {
        return phoneNUm;
    }

    public void setPhoneNUm(String phoneNUm) {
        this.phoneNUm = phoneNUm;
    }

    public Integer getStatus() {
        if(status==0){
            statusStr="未开启";
        }
        if(status==1){
            statusStr="开启";
        }
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNUm='" + phoneNUm + '\'' +
                ", status=" + status +
                ", roles=" + roles +
                ", statusStr='" + statusStr + '\'' +
                '}';
    }
}
