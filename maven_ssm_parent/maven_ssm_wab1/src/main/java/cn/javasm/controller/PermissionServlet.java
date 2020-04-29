package cn.javasm.controller;

import cn.javasm.entity.Permission;
import cn.javasm.service.PermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionServlet {
    @Resource
    private PermissionService permissionService;

    /**
     * 权限列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView find() {
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mv.addObject("permissionList", permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/deletePermission")
    public String deletePermission(Integer id) throws Exception {
        permissionService.deleteById(id);
        return "redirect:/permission/findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(Integer id) throws Exception {
        Permission permission=  permissionService.findById(id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("permission-show");
        mv.addObject("permission",permission);
        return mv;
    }

    @RequestMapping("/all")
    public String save(Permission permission) throws Exception {
        permissionService.Add(permission);
        return "redirect:/permission/findAll";
    }
}
