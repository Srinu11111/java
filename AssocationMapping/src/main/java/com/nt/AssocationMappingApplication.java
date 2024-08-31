package com.nt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nt.entity.Laptop;
import com.nt.entity.Student;
import com.nt.repository.AssociationRepository;

@SpringBootApplication
public class AssocationMappingApplication  implements CommandLineRunner{
	@Autowired
	private AssociationRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(AssocationMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student st=new Student();
		st.setId(10);
		st.setName("uday");
		st.setAddress("Hyd");
		
		
		Laptop l=new Laptop();
		l.setLid(20);
		l.setModel("hp");
		l.setStudent(st);
		st.setLaptop(l);
		Student data= repo.save(st);
		System.out.println("student data is:"+data.getName());
		
		
	}

}
