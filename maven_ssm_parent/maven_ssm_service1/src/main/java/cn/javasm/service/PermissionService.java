package cn.javasm.service;

import cn.javasm.entity.Permission;

import java.util.List;

public interface PermissionService {
    //查询所有
    List<Permission> findAll();

    //添加权限
    void Add(Permission permission);

    //查询指定的权限
    Permission findById(Integer id);

    //删除权限
    void deleteById(Integer id);


}
