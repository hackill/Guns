package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.BongGroup;
import com.stylefeng.guns.modular.system.service.IBongGroupService;

/**
 * 群主控制器
 *
 * @author fengshuonan
 * @Date 2018-04-25 16:04:00
 */
@Controller
@RequestMapping("/bonggroup")
public class BongGroupController extends BaseController {

    private String PREFIX = "/system/bonggroup/";

    @Autowired
    private IBongGroupService bonggroupService;

    /**
     * 跳转到群主首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "bonggroup.html";
    }

    /**
     * 跳转到添加群主
     */
    @RequestMapping("/bonggroup_add")
    public String bonggroupAdd() {
        return PREFIX + "bonggroup_add.html";
    }

    /**
     * 跳转到修改群主
     */
    @RequestMapping("/bonggroup_update/{bonggroupId}")
    public String bonggroupUpdate(@PathVariable Integer bonggroupId, Model model) {
        BongGroup bonggroup = bonggroupService.selectById(bonggroupId);
        model.addAttribute("item",bonggroup);
        LogObjectHolder.me().set(bonggroup);
        return PREFIX + "bonggroup_edit.html";
    }

    /**
     * 获取群主列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return bonggroupService.selectList(null);
    }

    /**
     * 新增群主
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(BongGroup bonggroup) {
        bonggroupService.insert(bonggroup);
        return SUCCESS_TIP;
    }

    /**
     * 删除群主
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer bonggroupId) {
        bonggroupService.deleteById(bonggroupId);
        return SUCCESS_TIP;
    }

    /**
     * 修改群主
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(BongGroup bonggroup) {
        bonggroupService.updateById(bonggroup);
        return SUCCESS_TIP;
    }

    /**
     * 群主详情
     */
    @RequestMapping(value = "/detail/{bonggroupId}")
    @ResponseBody
    public Object detail(@PathVariable("bonggroupId") Integer bonggroupId) {
        return bonggroupService.selectById(bonggroupId);
    }
}
