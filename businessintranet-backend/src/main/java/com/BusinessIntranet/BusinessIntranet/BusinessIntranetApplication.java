package com.BusinessIntranet.BusinessIntranet;

import com.BusinessIntranet.BusinessIntranet.Security.Utils.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BusinessIntranetApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessIntranetApplication.class, args);
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
