package co.song.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@OpenAPIDefinition(
        info = @Info(
                title = "Department Services REST APIS",
                description = "Department Services REST APIs Documentation",
        version = "v1.0",
        contact = @Contact(
                name = "Bunsong",
                email = "bunsong601@gmail.com",
                url = "https://www.bunsong.com"
        ),
        license = @License(
                name = "Apache 2.0",
                url = "https://www.bunsong.com"
          )
        ),externalDocs = @ExternalDocumentation(
                description = "Department-Service Doc",
        url = "https://www.bunsong.com"
)


)
@SpringBootApplication
@EnableDiscoveryClient
public class DepartmentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

}
