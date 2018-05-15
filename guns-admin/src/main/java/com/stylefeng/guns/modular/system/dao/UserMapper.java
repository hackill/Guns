package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户组信息(班级信息) Mapper 接口
 * </p>
 *
 * @author hackill123
 * @since 2018-04-25
 */

@Repository("userMapper")
public interface UserMapper extends BaseMapper<User> {


    List<Map<String,Object>> getBongUserList();

}
