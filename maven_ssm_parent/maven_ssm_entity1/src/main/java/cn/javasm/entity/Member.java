package cn.javasm.entity;

/**
 * 会员实体类
 */

public class Member {
    private Integer id;//会员id
    private String name;//会员姓名
    private String nickname;//会员名称
    private String phoneNum;//电话
    private String email;//邮箱

    public Member() {
    }

    public Member(Integer id, String name, String nickname, String phoneNum, String email) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
