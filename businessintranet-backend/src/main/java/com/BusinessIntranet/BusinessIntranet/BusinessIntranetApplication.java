package com.BusinessIntranet.BusinessIntranet;

import com.BusinessIntranet.BusinessIntranet.Configuration.Configuration;
import com.BusinessIntranet.BusinessIntranet.Configuration.Security.Utils.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BusinessIntranetApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessIntranetApplication.class, args);

        //Base API information display
        System.out.println("--------------------------------------------------");
        System.out.println("    API VERSION: " + Configuration.applicationVersion);
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
