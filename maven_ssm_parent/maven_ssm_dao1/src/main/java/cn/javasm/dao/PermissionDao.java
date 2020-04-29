package cn.javasm.dao;

import cn.javasm.entity.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    /**
     * 根据id查询关联的角色所有的权限
     *
     * @param id
     * @return
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    public List<Permission> findPermissionByRoleId(Integer id);

    /**
     * 查询所有的权限
     *
     * @return
     */
    @Select("select * from permission")
    List<Permission> findAll();

    /**
     * 添加权限
     *
     * @param permission
     * @throws Exception
     */
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void Add(Permission permission);

    /**
     * 根据id进行查询
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id=#{id}")
    Permission findById(Integer id);

    /**
     * 根据id在关联表进行删除
     *
     * @param id
     */
    @Delete("delete from role_permission where permissionId=#{id}")
    void deleteFromRole_Permission(Integer id);

    /**
     * 根据id进行删除
     *
     * @param id
     */
    @Delete("delete from permission where id=#{id}")
    void deleteById(Integer id);

}



