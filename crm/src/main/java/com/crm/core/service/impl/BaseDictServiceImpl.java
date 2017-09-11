package com.crm.core.service.impl;

import com.crm.core.mapper.BaseDictMapper;
import com.crm.core.pojo.BaseDict;
import com.crm.core.service.BaseDictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService {

    @Resource
    BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> findBaseDictByDictTypeCode(String dictTypeCode) {
        List<BaseDict> list =  this.baseDictMapper.findBaseDictByDictTypeCode(dictTypeCode);
        return list;
    }

}
