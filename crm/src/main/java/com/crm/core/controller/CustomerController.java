package com.crm.core.controller;

import com.crm.common.utils.Page;
import com.crm.core.pojo.BaseDict;
import com.crm.core.pojo.Customer;
import com.crm.core.pojo.QueryVo;
import com.crm.core.service.BaseDictService;
import com.crm.core.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping(value = "customer")
public class CustomerController {

    @Resource
    private BaseDictService baseDictService;

    @Resource
    private CustomerService customerService;

    //以注解在成员变量上的形式来解决硬编码

    @Value("${CUSTOMER_FROM_TYPE}")
    private String CUSTOMER_FROM_TYPE;//客户来源
    @Value("${CUSTOMER_INDUSTRY_TYPE}")
    private String CUSTOMER_INDUSTRY_TYPE;//所属行业
    @Value("${CUSTOMER_LEVEL_TYPE}")
    private String CUSTOMER_LEVEL_TYPE;//客户级别

    @RequestMapping(value = "list")
    public String queryCustomerList(QueryVo queryVo, Model model, HttpServletRequest request) {
        System.out.println(request.getMethod());
        try {
            //解决get请求的乱码问题
            if (request.getMethod().matches("GET") && StringUtils.isNotBlank(queryVo.getCustName())) {

                queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //查询条件初始化
        //客户来源
        List<BaseDict> fromType = baseDictService.findBaseDictByDictTypeCode(this.CUSTOMER_FROM_TYPE);
        //所属行业
        List<BaseDict> industryType = baseDictService.findBaseDictByDictTypeCode(this.CUSTOMER_INDUSTRY_TYPE);
        //客户级别
        List<BaseDict> levelType = baseDictService.findBaseDictByDictTypeCode(this.CUSTOMER_LEVEL_TYPE);

        //把前端页面要展示的数据放到模型中
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);


        //分页查询数据
        Page<Customer> page = this.customerService.queryCustomerByQueryVo(queryVo);
        //把分页查询的结果放到模型中
        model.addAttribute("page", page);

        //数据回显
        model.addAttribute("custName", queryVo.getCustName());
        model.addAttribute("custSource", queryVo.getCustSource());
        model.addAttribute("custIndustry", queryVo.getCustIndustry());
        model.addAttribute("custLevel", queryVo.getCustLevel());

        return "customer";
    }

    //Ajax根据id查询客户信息做回显
    @RequestMapping(value = "edit")
    @ResponseBody
    public Customer queryCustomerById(Long id) {
        Customer customer = this.customerService.queryCustomerById(id);
        return customer;
    }

    //Ajax更新客户信息
    @RequestMapping(value = "update")
    @ResponseBody
    public String updateCustomerById(Customer customer) {
        this.customerService.updateCustomerById(customer);
        return "OK";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String deleteCustomerById(Long id) {
        this.customerService.deleteCustomerById(id);
        return "OK";
    }
}
