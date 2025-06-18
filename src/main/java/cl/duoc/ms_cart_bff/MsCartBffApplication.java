package cl.duoc.ms_cart_bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsCartBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCartBffApplication.class, args);
	}

}
