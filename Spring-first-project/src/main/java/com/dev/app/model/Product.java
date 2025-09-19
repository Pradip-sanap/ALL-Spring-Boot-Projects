package com.dev.app.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//@Component
public class Product implements InitializingBean, DisposableBean{
	int pid;
	String pname;
	double price;
	String sku;
	
	
	public Product() {
	    // default constructor required for setter injection
	}
	
	public Product(int pid, String pname, double price, String sku) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.sku = sku;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", sku=" + sku + "]";
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destory method called at last");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init method called.");
		
	}
	
	

}
