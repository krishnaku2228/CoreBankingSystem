package com.krishna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishna.dto.Customer;
import com.krishna.repository.CustomerRepository;
@Service
public class CustomerService
{
	//List<Customer> list=new ArrayList<Customer>();
	int genrateNo=1;
	@Autowired
	CustomerRepository customerRepository;
	public Customer accountOpenCustomer(Customer customer)
	{
		String accountNo="1234"+genrateNo++;
	    customer.setAccountNo(accountNo);
	    return customerRepository.accountOpenCustomer(customer);
	    //list.add(customer);
	   // return accountNo;
	}
	public Integer getTotalCustomer()
    {
    	return customerRepository.getTotalCustomer();
    }
	public Customer searchCustomerByName(String name) 
	{
		return customerRepository.searchCustomerByName(name);
	}
	public Customer updateCustomerNameByAccountNo(String accountNo,String name)
	{
		return customerRepository.updateCustomerNameByAccountNo(accountNo, name);
	}
	public String deleteCustomerByAccountNo(String accountNo) 
	{
		
		return customerRepository.deleteCustomerByAccountNo(accountNo);
	}
    
	public List<Customer> getAllCustomerDetails()
	{
		return customerRepository.getAllCustomerDetails();
	}

}
