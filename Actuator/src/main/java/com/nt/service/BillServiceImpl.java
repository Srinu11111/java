package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Bill;
import com.nt.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillRepository repo;

	@Override
	public String insertBill(Bill bill) {
		// TODO Auto-generated method stub
		Bill data=repo.save(bill);
		return "datan inserted successfully";
	}

	@Override
	public String getBill(int bId,double bprice) {
		String values="";
		Optional<Bill> data=repo.findById(bId);
		if(data.isPresent()) { 
			Bill bill=data.get();
			bill.setBprice(bprice);
		 values="bill saved successfully:"+bill.getBprice();
	}
		else {
			return "no bill found";
		}
		return values;
	}

	@Override
	public List<Bill> getData() {
		List<Bill> values=repo.findAll();
		int bill=0;
		for(int i=0;i<values.size();i++) {
			 if(values!=null) {
				Bill data= values.get(i);
			 }
		}
		return values;
		
	}
	
	public String deleteBill(int bId) {
		Optional<Bill> data=repo.findById(bId);
		if(data.isPresent()) {
			repo.deleteById(bId);
			return "bill deleted successfullu with given number:"+data.get().getBId();
		}else {
			return "no bill found";
		}
	}
	
	
	
	

}
