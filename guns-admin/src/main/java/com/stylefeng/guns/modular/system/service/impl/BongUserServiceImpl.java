package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.dao.UserMapper;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.IBongUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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


    @Override
    public Page<Map<String, Object>> selectMapsPage(Page page, Wrapper<User> wrapper) {

        int i = 0;

        return super.selectMapsPage(page, wrapper);
    }

    @Override
    public Page<User> selectPage(Page<User> page) {
        int i = 0;
        return super.selectPage(page);
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<User> wrapper) {
        int i = 0;
        return super.selectMaps(wrapper);
    }


    @Override
    public List<User> selectList(Wrapper<User> wrapper) {
        int i = 0;
        return super.selectList(wrapper);
    }

    @Override
    public Page<User> selectPage(Page<User> page, Wrapper<User> wrapper) {
        int d = 0;
        System.out.println(page);
        return super.selectPage(page, wrapper);
    }

    @Override
    public Map<String, Object> selectMap(Wrapper<User> wrapper) {
        int i = 0;
        System.out.println(wrapper);
        return super.selectMap(wrapper);
    }

}
