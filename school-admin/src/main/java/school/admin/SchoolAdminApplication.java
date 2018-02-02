package school.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("school.admin.modules")
public class SchoolAdminApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolAdminApplication.class, args);
	}

}
