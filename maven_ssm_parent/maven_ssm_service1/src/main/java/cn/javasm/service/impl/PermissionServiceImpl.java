package cn.javasm.service.impl;

import cn.javasm.dao.PermissionDao;
import cn.javasm.entity.Permission;
import cn.javasm.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void Add(Permission permission) {
        permissionDao.Add(permission);

    }

    @Override
    public Permission findById(Integer id) {

        return permissionDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        permissionDao.deleteById(id);
    }
}
