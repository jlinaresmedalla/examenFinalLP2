package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Semana0301Application {

	public static void main(String[] args) {
		SpringApplication.run(Semana0301Application.class, args);
		
        // ApplicationContext context = new AnnotationConfigApplicationContext(IndexController.class);
        // IndexController controlador = context.getBean(IndexController.class);
        // controlador.showIndex();
	}
	
	/*@GetMapping("/")
    public String defaultView() {
        return "login";
    }*/

}
