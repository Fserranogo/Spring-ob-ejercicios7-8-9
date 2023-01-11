package com.example.ejercicios456;

import com.example.ejercicios456.entities.Laptop;
import com.example.ejercicios456.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Ejercicios456Application {

	public static void main(String[] args) {
		 ApplicationContext context =SpringApplication.run(Ejercicios456Application.class, args);
		 LaptopRepository repository= context.getBean(LaptopRepository.class);



		Laptop laptop1 =new Laptop(null,"pentium4",256,128.3,1.3,3);

		repository.save(laptop1);
		System.out.println(laptop1);
	}

}
