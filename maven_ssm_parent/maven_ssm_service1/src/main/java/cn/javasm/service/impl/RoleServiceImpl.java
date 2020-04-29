package cn.javasm.service.impl;

import cn.javasm.dao.RoleDao;
import cn.javasm.entity.Role;
import cn.javasm.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }
}
