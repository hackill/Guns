package com.stylefeng.guns.modular.system.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.annotion.Permission;
import com.stylefeng.guns.core.common.constant.factory.PageFactory;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.system.model.SysOperationLog;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.IBongUserService;
import com.stylefeng.guns.modular.system.warpper.BongUserWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


        Page<SysOperationLog> page = new PageFactory<SysOperationLog>().defaultPage();
//        List<Map<String, Object>> result = operationLogService.getOperationLogs(page, beginTime, endTime, logName, BizLogType.valueOf(logType), page.getOrderByField(), page.isAsc());
//        page.setRecords((List<SysOperationLog>) new LogWarpper(result).warp());
//        return super.packForBT(page);


        return PREFIX + "bonguser_edit.html";
    }

    /**
     * 跳转到未绑定的手环列表页面
     * @return
     */
    @RequestMapping("/getBongDeviceList")
    public String getBongDeviceList(){
        return PREFIX + "bongDevice_add.html";
    }

    /**
     * 获取用户列表
     */

    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String condition) {

        Page<User> page = new PageFactory<User>().defaultPage();

//        Wrapper<User> wrapper = new Wrapper<User>() {
//            @Override
//            public String getSqlSegment() {
//                return null;
//            }
//        };


        List<Map<String, Object>> result = bonguserService.getBongUserList();


        return super.warpObject(new BongUserWarpper(result));
//        return  result;
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


    @RequestMapping(value = "/getBongDevice")
    @ResponseBody
    public Object getBongDevice(@RequestParam(required = false) String condition){
        List<Map<String,Object>> list = bonguserService.getBongDevice();
        return list;
    }
}
