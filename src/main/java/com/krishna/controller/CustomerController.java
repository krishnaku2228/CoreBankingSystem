package com.krishna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.dto.Customer;
import com.krishna.service.CustomerService;
@RestController
@RequestMapping(value="/banking")
public class CustomerController 
{
  @Autowired
  CustomerService customerService;
  
	/*
	 * @GetMapping(value="/totalcustomer",produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<Integer>
	 * getTotalCustomer() { int result=customerService.getTotalCustomer();
	 * if(result==0) { result=0; } ResponseEntity responseEntity=new
	 * ResponseEntity(result,HttpStatus.OK); return responseEntity; }
	 */
  @GetMapping(value="/totalcustomer")
  public ResponseEntity<Integer>  getTotalCustomer() 
  {
	   int result=customerService.getTotalCustomer();
	   if(result==0) {
		   return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
		   }
	   //ResponseEntity responseEntity=new ResponseEntity(result,HttpStatus.OK);
	   return new ResponseEntity<>(result, HttpStatus.OK);
  }
  @PostMapping(value="/openAccount")
  public ResponseEntity<Customer> accountOpenCustomer(@RequestBody Customer customer) 
  {
     Customer customerResponse=customerService.accountOpenCustomer(customer);
     if(customerResponse!=null) {
    	 return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
     }
     return new ResponseEntity<>(customerResponse, HttpStatus.BAD_REQUEST);
  }
  @GetMapping(value="/getallcustomer")
  public ResponseEntity<List<Customer>> getAllCustomerDetails()
  {
	  List<Customer> allCustomerDetails = customerService.getAllCustomerDetails();
	  if(allCustomerDetails!=null && !allCustomerDetails.isEmpty()) {
		  return new ResponseEntity<>(allCustomerDetails,HttpStatus.OK);
	  }
	  return new ResponseEntity<>(allCustomerDetails,HttpStatus.INTERNAL_SERVER_ERROR);  
  }
  @PutMapping(value="/updatecustomername/{accountNo}/{name}")
  public ResponseEntity<Customer> updateCustomerNameByAccountNo(@PathVariable("accountNo") String accountNo,@PathVariable("name") String name)
  {
	  try {
	  Customer customerResponse=null;
	  if(accountNo!=null && name!=null) 
	  {
		  customerResponse = customerService.updateCustomerNameByAccountNo(accountNo, name);
		   if(customerResponse!=null) 
		      {
			   return new ResponseEntity<>(customerResponse,HttpStatus.OK); 
			   }
			   return new ResponseEntity<>(customerResponse,HttpStatus.NOT_FOUND); 
	 }
       return new ResponseEntity<>(customerResponse,HttpStatus.BAD_REQUEST); 
	  }catch(Exception e) {
		  return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	  }
  }
}
