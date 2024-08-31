package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Bill {
	@Id
	@GeneratedValue
	private int bId;
	private String name;
	private double bprice;
	public Bill() {
		
	}
	public Bill(int bId, String name, double bprice) {
		super();
		this.bId = bId;
		this.name = name;
		this.bprice = bprice;
	}
	public int getBId() {
		return bId;
	}
	public String getName() {
		return name;
	}
	public double getBprice() {
		return bprice;
	}
	public void setId(int bId) {
		this.bId = bId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBprice(double bprice) {
		this.bprice = bprice;
	}
	@Override
	public String toString() {
		return "Bill [id=" + bId + ", name=" + name + ", bprice=" + bprice + "]";
	}

}
