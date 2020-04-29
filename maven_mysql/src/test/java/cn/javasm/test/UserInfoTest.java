package cn.javasm.test;

import cn.javasm.dao.UserInfoDao;
import cn.javasm.dao.impl.UserInfoDaoImpl;
import cn.javasm.entity.UserInfo;
import org.junit.Test;

import java.util.List;

public class UserInfoTest {
    @Test
    public void findAll() throws  Exception {
        UserInfoDao dao = new UserInfoDaoImpl();
        List<UserInfo> list = dao.findAll();
        for (UserInfo user : list) {
            System.out.println(user.getName());
        }
    }
}
