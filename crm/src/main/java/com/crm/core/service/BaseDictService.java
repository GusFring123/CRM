package com.crm.core.service;

import com.crm.core.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    /**
     * 根据类别代码查询数据
     *
     * @param dictTypeCode
     * @return
     */
    List<BaseDict> findBaseDictByDictTypeCode(String dictTypeCode);
}
