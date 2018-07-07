package com.cg.mypaytmapp.repo;

import java.util.HashMap;
import java.util.Map;

import com.cg.mypaytmapp.beans.Customer;
import com.cg.mypaytmapp.exception.InvalidInputException;


public class WalletRepoImpl implements WalletRepo{

	private Map<String, Customer> data=new HashMap<>();
	
	public Map<String,Customer>getData(){
		return data;
	}
	 public void setData(Map<String,Customer> data) {
		 this.data=data;
	 }
	 
	 Customer cust=new Customer();
	public WalletRepoImpl(Map<String, Customer> data) {
		super();
		this.data = data;
	}
	public WalletRepoImpl()//default constructor
	{
		
	}

	public boolean save(Customer customer) {
		String mobileNo=customer.getMobileNo();
		data.put(mobileNo, customer);
		return true;
	}

	public Customer findOne(String mobileNo) {
		cust=data.get(mobileNo);
		if(cust==null)
			throw new InvalidInputException("Account not found!");
		else
		return cust;
		
	}
	
}
