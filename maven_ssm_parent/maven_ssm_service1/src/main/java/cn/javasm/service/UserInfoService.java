package cn.javasm.service;

import cn.javasm.entity.Role;
import cn.javasm.entity.UserInfo;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserInfoService  extends UserDetailsService {

        /**
         * 查询所有
         *
         * @return
         */
        List<UserInfo> findAll();

        /**
         * 添加用户
         *
         * @param userInfo
         */
        void add(UserInfo userInfo);

        /**
         * 根据id进行查询
         *
         * @param id
         * @return
         */
        UserInfo findById(Integer id);

        /**
         * 根据id判断用户下的角色
         * @param userId
         * @return
         */
        List<Role> findOtherRoles(Integer userId) ;

        /**
         * 给一个用户添加多个角色
         * @param userId
         * @param roleIds
         */

        void addRoleToUser(Integer userId, Integer[] roleIds);

}
