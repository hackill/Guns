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

    List<Map<String, Object>> getBongUserList();

}
