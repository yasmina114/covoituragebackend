package com.example.covoituragebackend;

import com.example.covoituragebackend.utils.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CovoituragebackendApplication implements CommandLineRunner {
    @Resource
    StorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(CovoituragebackendApplication.class, args);
    }

    public void run(String... args) throws Exception {

    // storageService.deleteAll();
    // storageService.init();
    }
    @Bean
//instentiation bech enjm n'executiha men ba3d
    BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }
}
