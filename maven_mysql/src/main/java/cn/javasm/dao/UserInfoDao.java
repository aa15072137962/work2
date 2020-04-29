package cn.javasm.dao;

import cn.javasm.entity.UserInfo;

import java.util.List;

public interface UserInfoDao {

    List<UserInfo> findAll() throws Exception;
}
