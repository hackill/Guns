package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.core.node.ZTreeNode;
import com.stylefeng.guns.modular.system.dao.SysDeptMapper;
import com.stylefeng.guns.modular.system.model.SysDept;
import com.stylefeng.guns.modular.system.service.IDeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements IDeptService {

    @Resource
    private SysDeptMapper deptMapper;

    @Override
    public void deleteDept(Integer deptId) {
        SysDept dept = deptMapper.selectById(deptId);

        Wrapper<SysDept> wrapper = new EntityWrapper<>();
        wrapper = wrapper.like("pids", "%[" + dept.getId() + "]%");
        List<SysDept> subDepts = deptMapper.selectList(wrapper);
        for (SysDept temp : subDepts) {
            temp.deleteById();
        }

        dept.deleteById();
    }

    @Override
    public List<ZTreeNode> tree() {
        return this.baseMapper.tree();
    }

    @Override
    public List<Map<String, Object>> list(String condition) {
        return this.baseMapper.list(condition);
    }
}
