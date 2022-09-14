package com.krishna.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.krishna.dto.Customer;
@Repository
public class CustomerRepository 
{
    List<Customer> list=new ArrayList<Customer>();
    public Customer accountOpenCustomer(Customer customer)
    {
    	list.add(customer);
    	return customer;
    }
    public Integer getTotalCustomer()
    {
    	Integer size=list.size();
        return size;
    }
    public Customer searchCustomerByName(String name) 
	{
		if(!list.isEmpty()) {
			for(Customer customer: list) {
			    if(customer.getCusName().equalsIgnoreCase(name)) {
			    	return customer;
			    }
			}
		}
		return null;
	}
    public Customer updateCustomerNameByAccountNo(String accountNo,String name)
	{
		if(!list.isEmpty()) {
			for(Customer customer: list) {
				if(customer.getAccountNo().equals(accountNo)) {
					customer.setCusName(name);
					return customer;
				}
			}
		}
		return null;
	}
    public String deleteCustomerByAccountNo(String accountNo) 
	{
		if(!list.isEmpty()) {
			for(Customer customer: list) {
				if(customer.getAccountNo().equals(accountNo)) {
					list.remove(customer);
					return "Account Deactivated";
				}
			}
		}
		return "Acount not found";
	}
    public List<Customer> getAllCustomerDetails()
    {
    	
    	return list;
    }
}
