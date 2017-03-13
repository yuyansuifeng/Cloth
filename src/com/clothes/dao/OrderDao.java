package com.clothes.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clothes.model.Customer;
import com.clothes.model.Clothes;
import com.clothes.model.Order;

@Service @Transactional
public class OrderDao {
	@Resource SessionFactory factory;
	/*添加订单*/
    public void AddOrder(Order order) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(order);
    }
    
    /*删除订单*/
    public void DeleteOrder (Integer orderId) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object order = s.load(Order.class, orderId);
        s.delete(order);
    }
    
    /*更新订单*/
    public void UpdateOrder(Order order) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(order);
    }
    
    /*显示所有订单*/
    public ArrayList<Order> QueryAllOrder() {
        Session s = factory.getCurrentSession();
        String hql = "From Order";
        Query q = s.createQuery(hql);
        List orderList = q.list();
        return (ArrayList<Order>) orderList;
    }

    /*根据主键获取信息*/
    public Order GetOrderById(Integer orderid) {
        Session s = factory.getCurrentSession();
        Order order = (Order)s.get(Order.class, orderid);
        return order;
    }
    
    /*根据查询条件查询，一般来说，订单查询时，会根据用户ID查对应的订单，或根据服装的名称查对应的订单*/
    public ArrayList<Order> QueryOrderInfo(Customer customer, Clothes clothes) {
    	Session s = factory.getCurrentSession();
    	String hql = "From Order order where 1=1";
    	if(null != customer && customer.getCustomerid()!=0) 
    		hql = hql + " and order.customer.customerid like '%" + customer.getCustomerid() + "%'";
    	if(null != clothes && null!=clothes.getClothestype()) 
    		hql = hql + " and order.clothes.clothestype like '%" + clothes.getClothestype() + "%'";
    	Query q = s.createQuery(hql);
    	List orderList = q.list();
    	return (ArrayList<Order>) orderList;
    }


}
