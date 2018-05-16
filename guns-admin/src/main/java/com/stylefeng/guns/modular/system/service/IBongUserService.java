package com.stylefeng.guns.modular.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.User;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户组信息(班级信息) 服务类
 * </p>
 *
 * @author hackill123
 * @since 2018-04-25
 */
public interface IBongUserService extends IService<User> {

    /**
     * 获取用户列表
     * @return
     */
    List<Map<String, Object>> getBongUserList();

    /**
     * 获取未绑定的手环列表
     * @return
     */
    List<Map<String,Object>> getBongDevice();

}
