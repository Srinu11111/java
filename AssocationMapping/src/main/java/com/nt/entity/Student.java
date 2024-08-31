package com.nt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	@Column(name = "STUDENT_ID")
	private int id;
	private String name;
	private String address;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private Laptop laptop;

	public Student() {
		super();
	}

	public Student(int id,String name, String address, Laptop laptop) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.laptop = laptop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", laptop=" + laptop + "]";
	}
}