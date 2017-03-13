package com.clothes.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.clothes.dao.CustomerDao;
import com.clothes.dao.ClothesDao;
import com.clothes.dao.OrderDao;
import com.clothes.model.Customer;
import com.clothes.model.Clothes;
import com.clothes.model.Order;

@Controller @Scope("prototype")
public class OrderAction {
	@Resource OrderDao orderDao;
    @Resource CustomerDao customerDao;
    @Resource ClothesDao clothesDao;
    
    private Order order;
    private List<Order> orderList;
    private Customer customer;
    private Clothes clothes;
    public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Clothes getClothes() {
		return clothes;
	}
	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}
	
    
	/*添加订单*/
	public String addOrder() throws Exception{

		customer = customerDao.queryCustomerInfo(customer.getName()).get(0);
		Order ord =new Order();
		ord.setCustomer(customer);
		ord.setClothes(clothes);
		ord.setClothesnum(1);
		ord.setTotal(clothesDao.GetClothesById(clothes.getClothesid()).getUnitprice()*1);
		orderDao.AddOrder(ord);
		return "order_message";
		
	}
	
	/**/
    public String showOrder() {
    	
        //
    	System.out.println(customer.getName());
        Customer cus= customerDao.queryCustomerInfo(customer.getName()).get(0);
        //
        orderList = orderDao.QueryOrderInfo(cus,null);

        return "show_view";
    }

    /**/
    public String showDetail() {
    	System.out.print(order.getOrderid());
    	order = orderDao.GetOrderById(order.getOrderid());
        return "detail_view";
    }
    
    /*显示Order的修改项*/
    /*public String showEdit() throws Exception {
    	order = orderDao.GetOrderById(order.getOrderid());
        return "edit_view";
    }*/

    /*编辑Order*/
    /*public String editOrder() throws Exception {
    	orderDao.UpdateOrder(order);
        return "edit_message";
    }*/
    
    /*删除Order*/
    /*public String deleteOrder() throws Exception {
    	orderDao.DeleteOrder(food.getFoodid());
        return "delete_message";
    }*/
    
    /**/
    public String queryOrders() throws Exception {
    	orderList = orderDao.QueryOrderInfo(customer,clothes);
        return "show_view";
    }
    

}
