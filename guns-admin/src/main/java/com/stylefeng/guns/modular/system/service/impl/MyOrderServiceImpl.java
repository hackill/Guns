package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.MyOrder;
import com.stylefeng.guns.modular.system.dao.MyOrderMapper;
import com.stylefeng.guns.modular.system.service.IMyOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author hackill123
 * @since 2018-03-30
 */
@Service
public class MyOrderServiceImpl extends ServiceImpl<MyOrderMapper, MyOrder> implements IMyOrderService {

}
