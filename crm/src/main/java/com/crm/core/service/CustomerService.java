package com.crm.core.service;

import com.crm.common.utils.Page;
import com.crm.core.pojo.Customer;
import com.crm.core.pojo.QueryVo;

/**
 * The interface Customer service.
 */
public interface CustomerService {
    /**
     * Query customer by query vo page.
     * 查询分页对象
     *
     * @param queryVo the query vo
     * @return the page
     */
    Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    /**
     * Query customer by id customer.
     * 根据id获得客户信息
     *
     * @param id the id
     * @return the customer
     */
    Customer queryCustomerById(Long id);

    /**
     * Update customer by id.
     * 根据id更新用户
     *
     * @param customer the customer
     */
    void updateCustomerById(Customer customer);

    /**
     * Delete customer by id.
     * 根据id删除客户信息
     *
     * @param id the id
     */
    void deleteCustomerById(Long id);
}
