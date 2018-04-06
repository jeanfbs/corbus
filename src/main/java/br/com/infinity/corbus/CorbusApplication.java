package br.com.infinity.corbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

@SpringBootApplication
public class CorbusApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorbusApplication.class, args);
	}

}
