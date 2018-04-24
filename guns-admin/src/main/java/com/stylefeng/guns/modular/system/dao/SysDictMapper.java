package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.SysDict;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author hackill123
 * @since 2018-04-24
 */
public interface SysDictMapper extends BaseMapper<SysDict> {

    /**
     * 根据编码获取词典列表
     */
    List<SysDict> selectByCode(@Param("code") String code);

    /**
     * 查询字典列表
     */
    List<Map<String, Object>> list(@Param("condition") String conditiion);

}
