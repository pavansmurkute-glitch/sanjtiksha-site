package com.sanjtiksha.site.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Public pages
                        .requestMatchers("/", "/about", "/services", "/products", "/team", "/contact", "/images/**", "/css/**").permitAll()
                        // Admin pages
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().permitAll()  // don’t force login for unknown paths
                )
                .formLogin(form -> form
                        .loginPage("/admin/login")   // custom login page
                        .loginProcessingUrl("/admin/login") // POST URL for login form
                        .defaultSuccessUrl("/admin/dashboard", true) // after login
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}
