package com.stylefeng.guns.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.base.BaseJunit;
import com.stylefeng.guns.modular.system.dao.SysMenuMapper;
import com.stylefeng.guns.modular.system.model.SysMenu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Stack;

/**
 * 菜单测试
 *
 * @author fengshuonan
 * @date 2017-06-13 21:23
 */
public class MenuTest extends BaseJunit {

    @Autowired
    SysMenuMapper menuMapper;

    /**
     * 初始化pcodes
     *
     * @author stylefeng
     * @Date 2017/6/13 21:24
     */
    @Test
    public void generatePcodes() {
        List<SysMenu> menus = menuMapper.selectList(null);
        for (SysMenu menu : menus) {
            if ("0".equals(menu.getPcode()) || null == menu.getPcode()) {
                menu.setPcodes("[0],");
            } else {
                StringBuffer sb = new StringBuffer();
                SysMenu parentMenu = getParentMenu(menu.getCode());
                sb.append("[0],");
                Stack<String> pcodes = new Stack<>();
                while (null != parentMenu.getPcode()) {
                    pcodes.push(parentMenu.getCode());
                    parentMenu = getParentMenu(parentMenu.getPcode());
                }
                int pcodeSize = pcodes.size();
                for (int i = 0; i < pcodeSize; i++) {
                    String code = pcodes.pop();
                    if (code.equals(menu.getCode())) {
                        continue;
                    }
                    sb.append("[" + code + "],");
                }

                menu.setPcodes(sb.toString());
            }
            menu.updateById();
        }
    }

    private SysMenu getParentMenu(String code) {
        Wrapper<SysMenu> wrapper = new EntityWrapper<SysMenu>();
        wrapper = wrapper.eq("code", code);
        List<SysMenu> menus = menuMapper.selectList(wrapper);
        if (menus == null || menus.size() == 0) {
            return new SysMenu();
        } else {
            return menus.get(0);
        }
    }
}
