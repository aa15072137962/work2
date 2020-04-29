package cn.javasm.dao.impl;

import cn.javasm.dao.UserInfoDao;
import cn.javasm.entity.UserInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDaoImpl implements UserInfoDao {

    public List<UserInfo> findAll() throws Exception{

        List<UserInfo> list = new ArrayList<UserInfo>();
        //先获取contection对象
        Connection connection = null;
        //获取真正操作数据的对象
        PreparedStatement pst = null;
        //执行数据库查询操作
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //先获取contection对象
            connection = DriverManager.getConnection("jdbc:mysql:///javasm","root", "root");
            //获取真正操作数据的对象
            pst = connection.prepareCall("select * from user");
            //执行数据库查询操作
            rs = pst.executeQuery();
            //把数据库结果集转成java的List集合

            while (rs.next()){
               UserInfo items = new UserInfo();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                items.setPassword(rs.getInt("password"));
                list.add(items);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
            pst.close();
            rs.close();
        }

        return list;
    }
}
