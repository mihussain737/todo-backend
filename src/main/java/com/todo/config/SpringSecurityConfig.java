package com.todo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean // basic header authentication
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((requests) ->
                {
//                    requests.requestMatchers(HttpMethod.POST,"api/**").hasRole("ADMIN");
//                    requests.requestMatchers(HttpMethod.DELETE,"api/**").hasRole("ADMIN");
//                    requests.requestMatchers(HttpMethod.PUT,"api/**").hasRole("ADMIN");
//                    requests.requestMatchers(HttpMethod.PATCH,"api/**").hasRole("USER");
//                    requests.requestMatchers(HttpMethod.GET,"api/**").hasAnyRole("USER","ADMIN");
                    requests.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /*@Bean // for in memory authentication
    public UserDetailsService userDetailsService(){
        UserDetails imam= User.builder()
                .username("imam")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();
        UserDetails admin= User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(imam,admin);
    } */

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
