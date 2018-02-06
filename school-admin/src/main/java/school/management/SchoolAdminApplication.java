package school.management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"school.management.admin.modules", "school.management.business"})
public class SchoolAdminApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolAdminApplication.class, args);
	}

}
