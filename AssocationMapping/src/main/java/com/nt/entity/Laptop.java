package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Laptop {
	@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lid;
	private String model;

	@OneToOne
	@JoinColumn(name="STUDENT_ID")
	private Student student;

	public Laptop() {
		super();
	}
	
	public Laptop( int lid,String model, Student student) {
		super();
		this.lid = lid;
		this.model = model;
		this.student = student;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", model=" + model + ", student=" + student + "]";
	}

}
