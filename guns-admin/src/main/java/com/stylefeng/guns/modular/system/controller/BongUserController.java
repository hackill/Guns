package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.IBongUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户控制器
 *
 * @author fengshuonan
 * @Date 2018-04-25 10:45:06
 */
@Controller
@RequestMapping("/bonguser")
public class BongUserController extends BaseController {

    private String PREFIX = "/system/bonguser/";

    @Autowired
    private IBongUserService bonguserService;

    /**
     * 跳转到用户首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "bonguser.html";
    }

    /**
     * 跳转到添加用户
     */
    @RequestMapping("/bonguser_add")
    public String bonguserAdd() {
        return PREFIX + "bonguser_add.html";
    }

    /**
     * 跳转到修改用户
     */
    @RequestMapping("/bonguser_update/{bonguserId}")
    public String bonguserUpdate(@PathVariable Integer bonguserId, Model model) {
        User bonguser = bonguserService.selectById(bonguserId);
        model.addAttribute("item", bonguser);
        LogObjectHolder.me().set(bonguser);
        return PREFIX + "bonguser_edit.html";
    }

    /**
     * 获取用户列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return bonguserService.selectList(null);
    }

    /**
     * 新增用户
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(User bonguser) {
        bonguserService.insert(bonguser);
        return SUCCESS_TIP;
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer bonguserId) {
        bonguserService.deleteById(bonguserId);
        return SUCCESS_TIP;
    }

    /**
     * 修改用户
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(User bonguser) {
        bonguserService.updateById(bonguser);
        return SUCCESS_TIP;
    }

    /**
     * 用户详情
     */
    @RequestMapping(value = "/detail/{bonguserId}")
    @ResponseBody
    public Object detail(@PathVariable("bonguserId") Integer bonguserId) {
        return bonguserService.selectById(bonguserId);
    }
}
