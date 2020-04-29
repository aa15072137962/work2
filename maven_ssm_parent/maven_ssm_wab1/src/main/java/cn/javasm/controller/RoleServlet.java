package cn.javasm.controller;

import cn.javasm.entity.Permission;
import cn.javasm.entity.Role;
import cn.javasm.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleServlet {
    @Resource
    private RoleService roleService;
      //角色详情查询
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("role", roleList);
        mv.setViewName("role-list");
        return mv;

    }

    /**
     * 添加
     * @param role
     * @return
     */
    public String add(Role role) {
        roleService.add(role);
        return "redirect:/role/findAll";
    }

    /**
     * 删除
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteRole")
    public String deleteRole(@RequestParam(name="id",required = true) Integer roleId) throws Exception {
        roleService.deleteRoleById(roleId);
        return "redirect:/role/findAll";
    }

    //给角色添加权限
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) Integer roleId, @RequestParam(name = "ids", required = true) Integer[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:/role/findAll";
    }

    //根据roleId查询role，并查询出可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) Integer roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //根据roleId查询role
        Role role = roleService.findById(roleId);
        //根据roleId查询可以添加的权限
        List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);
        mv.setViewName("role-permission-add");
        return mv;

    }

}
