package com.nt.service;

import java.util.List;

import com.nt.entity.Bill;

public interface BillService {
	public String insertBill(Bill bill);
	public String getBill(int bId,double bprice);
	public List<Bill> getData();
	public String deleteBill(int bId);
		
	}


