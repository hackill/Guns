package com.stylefeng.guns.core.util;

/**
 * 字典枚举类
 */
public class DictionaryEnum {

    /**
     * 性别转换
      * @param str
     * @return
     */
    public String getSex(String str){
        String sex = null;
        if(str.equals("1")){
            sex = "男";
        }else {
            sex = "女";
        }
        return  sex;
    }

    /**
     * 状态转换
     * @param str
     * @return
     */
    public String getStatus(String str){
        String status = null;
        if(str.equals("0")){
            status = "正常";
        }else if(str.equals("1")){
            status = "注销";
        }
        return status;
    }

    /**
     * 账号状态转换
     * @param str
     * @return
     */
    public String getAccStatus(String str){
        String accStatus = null;
        if(str.equals("0")){
            accStatus = "启用";
        }else if(str.equals("1")){
            accStatus = "冻结";
        }else if(str.equals("2")){
            accStatus = "已删除";
        }
        return  accStatus;
    }
}
