package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.dao.SysLoginLogMapper;
import com.stylefeng.guns.modular.system.model.SysLoginLog;
import com.stylefeng.guns.modular.system.model.SysOperationLog;
import com.stylefeng.guns.modular.system.service.ILoginLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 登录记录 服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-02-22
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements ILoginLogService {

    @Override
    public List<Map<String, Object>> getLoginLogs(Page<SysOperationLog> page, String beginTime, String endTime, String logName, String orderByField, boolean asc) {
        return this.baseMapper.getLoginLogs(page, beginTime, endTime, logName, orderByField, asc);
    }
}
