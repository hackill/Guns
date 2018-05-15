package com.stylefeng.guns.modular.system.warpper;


import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.util.DictionaryEnum;

import java.util.List;
import java.util.Map;

/**
 * Bonguser包装类
 * @author Wang
 * @Time 2018年05月14日10:15:03
 */
public class BongUserWarpper extends BaseControllerWarpper {

   public BongUserWarpper(List<Map<String, Object>> list){
       super(list);
   }

   DictionaryEnum dictionaryEnum = new DictionaryEnum();

   public void warpTheMap(Map<String,Object> map){

        map.put("gender",dictionaryEnum.getSex(map.get("gender").toString()));
        map.put("status",dictionaryEnum.getStatus(map.get("status").toString()));

    }
}
