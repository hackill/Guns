package com.stylefeng.guns.modular.system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.modular.system.model.MyOrder;
import com.stylefeng.guns.modular.system.service.IMyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 订单业务控制器
 *
 * @author fengshuonan
 * @Date 2018-03-30 16:21:12
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

    private String PREFIX = "/system/order/";

    @Autowired
    private IMyOrderService orderService;

    /**
     * 跳转到订单业务首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "order.html";
    }

    /**
     * 跳转到添加订单业务
     */
    @RequestMapping("/order_add")
    public String orderAdd() {
        return PREFIX + "order_add.html";
    }

    /**
     * 跳转到修改订单业务
     */
    @RequestMapping("/order_update/{orderId}")
    public String orderUpdate(@PathVariable Integer orderId, Model model) {
        MyOrder order = orderService.selectById(orderId);
        model.addAttribute("item", order);
        LogObjectHolder.me().set(order);
        return PREFIX + "order_edit.html";
    }

    /**
     * 获取订单业务列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {

        System.out.println("condition = " + condition);

        if (ToolUtil.isNotEmpty(condition)) {
            EntityWrapper<MyOrder> myOrderEntityWrapper = new EntityWrapper<>();
            myOrderEntityWrapper.like("good", "%" + condition + "%");
            return orderService.selectList(myOrderEntityWrapper);
        }

        return orderService.selectList(null);
    }

    /**
     * 新增订单业务
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(MyOrder order) {
        if (order != null) {
            order.setCreatetime(new Date());
            orderService.insert(order);
        }
        return SUCCESS_TIP;
    }

    /**
     * 删除订单业务
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer orderId) {
        orderService.deleteById(orderId);
        return SUCCESS_TIP;
    }

    /**
     * 修改订单业务
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(MyOrder order) {
        orderService.updateById(order);
        return SUCCESS_TIP;
    }

    /**
     * 订单业务详情
     */
    @RequestMapping(value = "/detail/{orderId}")
    @ResponseBody
    public Object detail(@PathVariable("orderId") Integer orderId) {
        return orderService.selectById(orderId);
    }
}
