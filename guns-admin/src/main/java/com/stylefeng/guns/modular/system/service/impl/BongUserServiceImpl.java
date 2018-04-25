package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.IBongUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户组信息(班级信息) 服务实现类
 * </p>
 *
 * @author hackill123
 * @since 2018-04-25
 */
@Service
public class BongUserServiceImpl extends ServiceImpl<UserMapper, User> implements IBongUserService {

}
