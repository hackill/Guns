package com.stylefeng.guns.modular.system.factory;

import com.stylefeng.guns.modular.system.transfer.UserDto;
import com.stylefeng.guns.modular.system.model.SysUser;
import org.springframework.beans.BeanUtils;

/**
 * 用户创建工厂
 *
 * @author fengshuonan
 * @date 2017-05-05 22:43
 */
public class UserFactory {

    public static SysUser createUser(UserDto userDto){
        if(userDto == null){
            return null;
        }else{
            SysUser user = new SysUser();
            BeanUtils.copyProperties(userDto,user);
            return user;
        }
    }
}
