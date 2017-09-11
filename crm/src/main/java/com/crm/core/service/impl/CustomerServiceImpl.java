package com.crm.core.service.impl;

import com.crm.common.utils.Page;
import com.crm.core.mapper.CustomerMapper;
import com.crm.core.pojo.Customer;
import com.crm.core.pojo.QueryVo;
import com.crm.core.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
        //设置查询条件，从那一条开始查
        queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());
        //查询结果集
        List<Customer> list = this.customerMapper.queryCustomerByQueryVo(queryVo);
        //查询到的总记录数
        int total = this.customerMapper.queryCountByQueryVo(queryVo);

        //封装返回的Page对象
        Page<Customer> page = new Page<>(total,queryVo.getPage(),queryVo.getRows(),list);

        return page;
    }

    @Override
    public Customer queryCustomerById(Long id) {
        return this.customerMapper.queryCustomerById(id);
    }

    @Override
    public void updateCustomerById(Customer customer) {
        this.customerMapper.updateCustomerById(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        this.customerMapper.deleteCustomerById(id);
    }
}
