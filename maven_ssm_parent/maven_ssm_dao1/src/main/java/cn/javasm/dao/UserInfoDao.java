package cn.javasm.dao;

import cn.javasm.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Role;

import java.util.List;

public interface UserInfoDao {
    /**
     * 查寻所有的用户
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAll();

    /**
     * 根据用户名进行查询
     * 用户登录
     * @param username
     * @return
     */
    @Select("SELECT * FROM `users` WHERE username=#{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column ="email" ,property = "email"),
            @Result(column = "username",property = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles" ,column = "id",javaType = java.util.List.class,many = @Many(select = "cn.javasm.dao.RoleDao.findRoleByUserId"))
    })
   UserInfo findByUsername(String username);

    /**
     * 用户添加
     * @param userInfo
     */
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})" )
   void add(UserInfo userInfo);

    /**
     * 根据id进行查询
     * @param id
     * @return
     */
    @Select("SELECT * FROM users WHERE id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column ="email" ,property = "email"),
            @Result(column = "username",property = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles" ,column = "id",javaType = java.util.List.class,many = @Many(select = "cn.javasm.dao.RoleDao.findRoleByUserId"))
    })

   UserInfo findById(Integer id);

    /**
     * 查询不存在的角色
     * @param userId
     * @return
     */
    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRoles(Integer userId);

    /**
     * 在关联表中进行添加
     * 关联添加
     * @param userId
     * @param roleId
     */
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
