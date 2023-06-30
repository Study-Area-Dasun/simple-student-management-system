package lk.ijse.dep10.simplestudentmanagementsystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleStudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleStudentManagementSystemApplication.class, args);
	}
			@Bean
			public ModelMapper modelMapper(){
				return new ModelMapper();
			}
}
