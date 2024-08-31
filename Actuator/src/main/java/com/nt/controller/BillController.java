package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Bill;
import com.nt.service.BillServiceImpl;

@RestController
@RequestMapping
public class BillController {
	@Autowired
	private BillServiceImpl service;

	@PostMapping("/insert")
	public String insertData(@RequestBody Bill bill) {
		String data = service.insertBill(bill);
		return data;
	}

	@PutMapping("/data/{bId}/{bprice}")
	public String displayData(@PathVariable("bId") Integer bId, 
			@PathVariable("bprice") double bprice) {
		String values = service.getBill(bId,bprice);
		return values;
	}

	@GetMapping("/allData")
	public List<Bill> displayAll() {
		List<Bill> values = service.getData();
		return values;
	}

	@DeleteMapping("/dataDelete/{bId}")
	public String removeData(@PathVariable("bId") Integer bId) {
		String values = service.deleteBill(bId);
		return values;
	}

}
