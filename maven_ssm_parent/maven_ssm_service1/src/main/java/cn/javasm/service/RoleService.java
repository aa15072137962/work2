package cn.javasm.service;

import cn.javasm.entity.Permission;
import cn.javasm.entity.Role;

import java.util.List;

public interface RoleService {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();

    /**
     * 添加角色
     * @param role
     */

    void add(Role role);

    /**
     * 根据关联表id进行查询
     * @param roleId
     * @return
     * @throws Exception
     */
    Role findById(Integer roleId) throws  Exception;

    /**
     * 根据传入的角色id角色表，并查询可以查询的角色
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Permission> findOtherPermissions(Integer roleId) throws Exception;

    /**
     * 给角色添加权限
     * @param roleId
     * @param permissionIds
     * @throws Exception
     */
    void addPermissionToRole(Integer roleId, Integer[] permissionIds) throws Exception;

    /**
     * 根据关联表角色id进行删除
     * @param roleId
     * @throws Exception
     */
    void deleteRoleById(Integer roleId) throws Exception;
}
