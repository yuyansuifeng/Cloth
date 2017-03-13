package com.clothes.action;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.clothes.dao.CustomerDao;
import com.clothes.model.Customer;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class CustomerAction extends ActionSupport implements SessionAware{
	@Resource CustomerDao customerDao;
	private Customer customer;
	private String errMessage;
	private Map<String,Object> session;
	private String prePage;
	
	public String getPrepage() {
		return prePage;
	}
	public void setPrepage(String prepage) {
		this.prePage = prepage;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

	
	public String reg() throws Exception{
		customerDao.AddCustomer(customer);
		session.put("customer", customer);
		return "show_view";

	}
	
	public String login() {
		
		ArrayList<Customer> listcustomer = customerDao.queryCustomerInfo(customer.getName());
		if(listcustomer.size()==0) { 
			
			this.errMessage = "账号不存在！";
			System.out.print(this.errMessage);
			return "input";
			
		} 
		else{
			Customer db_customer = listcustomer.get(0);
			if(!db_customer.getPassword().equals(customer.getPassword())){ 
		
			this.errMessage = "密码不正确！";
			System.out.print(this.errMessage);
			return "input";
		    }
		else{
		    	session.put("customer", db_customer);
				prePage = (String) session.get("prePage");
				System.out.println("将要跳到"+ prePage);
				session.remove("prePage");  
				return "success";
		    }
		}
	}

}
