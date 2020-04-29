package cn.javasm.controller;

import cn.javasm.entity.Role;
import cn.javasm.entity.UserInfo;
import cn.javasm.service.UserInfoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/userInfo")
public class UserInfoServlet {
    @Resource
    private UserInfoService userInfoService;

    /**
     * 查询用户指定的id
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(Integer id) {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userInfoService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user_show");
        return mv;
    }

    @RequestMapping("/findAll")
    //添加权限控制，第三种
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userInfoService.findAll();
        mv.addObject("userList", userList);
        mv.setViewName("user-list");
        return mv;
    }

    /***
     * 添加后 倒转到用户页面
     * @param userInfo
     * @return
     */
    @RequestMapping("/add")
    //只有tom用户能进行添加
    @PreAuthorize("authentication.principal.username == 'tom'")
    public String add(UserInfo userInfo) {
        userInfoService.add(userInfo);
        return "redirect:/userInfo/findAll";
    }

    /**
     * 查询用户以及用户可以添加的角色
     *
     * @param userId
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(value = "id", required = true) Integer userId) {
        ModelAndView mv = new ModelAndView();
        //1.根据用户id查询用户
        UserInfo userInfo = userInfoService.findById(userId);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles = userInfoService.findOtherRoles(userId);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;

    }
    //给用户添加角色(多条)
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) Integer  userId, @RequestParam(name = "ids", required = true) Integer[] roleIds) {
        userInfoService.addRoleToUser(userId,roleIds);
        return "redirect:/userInfo/findAll";
    }


}
