package com.crm.core.mapper;

import com.crm.core.pojo.Customer;
import com.crm.core.pojo.QueryVo;

import java.util.List;

/**
 * The interface Customer mapper.
 */
public interface CustomerMapper {
    /**
     * Query customer by query vo list.
     * 根据QueryVo分页查询数据
     *
     * @param queryVo the query vo
     * @return the list
     */
    List<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    /**
     * Query count by query vo int.
     * 根据ueryVO查询数据条数
     *
     * @param queryVo the query vo
     * @return the int
     */
    int queryCountByQueryVo(QueryVo queryVo);

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
     * 根据id更新客户信息
     *
     * @param customer the customer
     */
    void updateCustomerById(Customer customer);

    /**
     * Delete customer by id int.
     * 根据id删除客户信息
     * @param id the id
     * @return the int
     */
    void deleteCustomerById(Long id);

}
