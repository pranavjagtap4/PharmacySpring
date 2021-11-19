package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Orders;

import com.mph.entity.Customer;

import com.mph.service.OrderService;
@RestController
@RequestMapping(value="/orders")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowCredentials="false",allowedHeaders="*")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@GetMapping("/allorders")
	public ResponseEntity<List<Orders>> allorders(){
	
		List<Orders> orderList=orderService.getOrdersList();
		System.out.println(orderList);
		if(orderList.isEmpty()) {
			return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(orderList,HttpStatus.OK);
	}
	
	@GetMapping("/orderById/{isd}")
	public ResponseEntity<Orders> orderById(@PathVariable("isd") int id){
		Orders orders=orderService.getOrderById(id);
		//System.out.println(emp);
	//	if(emp.isEmpty()) {
			//return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		//}
		return new ResponseEntity<Orders>(orders,HttpStatus.OK);
	}	

	@PostMapping("/addorder")
	public Orders CreateOrders(@RequestBody Orders orders) {
		orderService.CreateOrders(orders);
		return orders;
	}
	
	@PutMapping("/updateOrder")
	public ResponseEntity<?> updateOrders(@RequestBody Orders orders){
		orderService.updateOrders(orders);
		//List<Employee> emplist=employeeService.getAllEmployee();
		//return ResponseEntity.ok().body("New Employee with ID"+employee.getId()+"updated successfully!");
		return new ResponseEntity<String>("updated sucessfully",HttpStatus.OK);
	}

	@DeleteMapping("/deleteOrder/{isd}")
	public ResponseEntity<?> deleteOrders(@PathVariable("isd") int id){
		orderService.deleteOrders(id);
		//List<Employee> emplist=employeeService.getAllEmployee();
		//return ResponseEntity.ok().body("New Employee with ID"+id+"deleted successfully!");
		return new ResponseEntity<String>("deleted sucessfully",HttpStatus.OK);
	}

	
}

