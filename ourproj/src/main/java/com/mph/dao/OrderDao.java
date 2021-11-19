package com.mph.dao;

import java.util.List;

import com.mph.entity.Orders;
import com.mph.entity.Customer;
public interface OrderDao {
	public List<Orders> getOrdersList();
	public Orders getOrders(Orders orders);
	public Orders getOrderById(int o_id);
	public void CreateOrders(Orders orders) ;
	public List<Orders> updateOrders(Orders orders);
	public List<Orders> deleteOrders(int o_id);
}
