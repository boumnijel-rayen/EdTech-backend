package tn.esprint.EdTech.Security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig{

    private static final String[] WHITE_LIST_URL = {"/api/auth/login",
            "/api/auth/register",
            "/api/auth/activate/**",
            "/api/matieres/**",
            "/api/exams/**"
    };
    JwtAuthenticationFilter jwtAuthFilter;
    AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL)
                                .permitAll()
                                .requestMatchers("/Niveau/all").hasAnyRole("ADMIN")
                                .requestMatchers(GET, "/Niveau/get/**").hasAnyAuthority("ETUDIANT")
                                .requestMatchers(POST, "/Niveau/**").hasAnyAuthority("ETUDIANT")
                                .requestMatchers(PUT, "/Niveau/**").hasAnyAuthority("ENSEIGNANT")
                                .requestMatchers(DELETE, "/Niveau/**").hasAnyAuthority("ENSEIGNANT")
                                .requestMatchers(DELETE, "/user/delete/**").hasAnyAuthority("ETUDIANT")
                                .requestMatchers(PUT, "/user/update").hasAnyAuthority("ETUDIANT")
                                .requestMatchers(GET, "/user/get/**").hasAnyAuthority("ADMIN","ETUDIANT")
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        ;

        return http.build();
    }



}
