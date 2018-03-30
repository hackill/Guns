package com.stylefeng.guns.generator.action.config;

import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 默认的代码生成的配置
 *
 * @author fengshuonan
 * @date 2017-10-28-下午8:27
 */
public class GunsGeneratorConfig extends AbstractGeneratorConfig {

    protected void globalConfig() {

        //写自己项目的绝对路径,注意具体到java目录
        globalConfig.setOutputDir("/Users/hackill/IntellijProjects/Guns/guns-admin/src/main/java");
        globalConfig.setFileOverride(true);
        globalConfig.setEnableCache(false);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setOpen(false);
        globalConfig.setAuthor("hackill");
    }

    protected void dataSourceConfig() {
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/guns?characterEncoding=utf8");
    }

    protected void strategyConfig() {
        //// 此处可以修改为您的表前缀 自动过滤前缀
        strategyConfig.setTablePrefix(new String[]{"sys_"});
        strategyConfig.setInclude(new String[]{"my_order"});
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
    }

    protected void packageConfig() {
        //设置根目录
        packageConfig.setParent("com.stylefeng.guns.modular.system");
        //单个目录
        packageConfig.setEntity("model");
        //单个目录
        packageConfig.setMapper("dao");
        //单个目录
        packageConfig.setXml("dao.mapping");

        //本项目未用到 随便写个文件夹 用于以后删除
        packageConfig.setController("TTT");
        packageConfig.setServiceImpl("TTT");
        packageConfig.setService("TTT");
    }

    protected void contextConfig() {

        contextConfig.setProPackage("com.stylefeng.guns");
        contextConfig.setCoreBasePackage("com.stylefeng.guns.core");
        contextConfig.setBizChName("订单业务");
        contextConfig.setBizEnName("order");
        contextConfig.setModuleName("system");
        contextConfig.setProjectPath("/Users/hackill/IntellijProjects/Guns/guns-admin");//写自己项目的绝对路径
        contextConfig.setEntityName("MyOrder");

        sqlConfig.setParentMenuName(null);//这里写已有菜单的名称,当做父节点

        /**
         * mybatis-plus 生成器开关
         */
        contextConfig.setEntitySwitch(true);
        contextConfig.setDaoSwitch(true);
        contextConfig.setServiceSwitch(true);

        /**
         * guns 生成器开关
         */
        contextConfig.setControllerSwitch(true);
        contextConfig.setIndexPageSwitch(true);
        contextConfig.setAddPageSwitch(true);
        contextConfig.setEditPageSwitch(true);
        contextConfig.setJsSwitch(true);
        contextConfig.setInfoJsSwitch(true);
        contextConfig.setSqlSwitch(true);
    }

    @Override
    protected void config() {
        globalConfig();
        dataSourceConfig();
        strategyConfig();
        packageConfig();
        contextConfig();
    }
}
