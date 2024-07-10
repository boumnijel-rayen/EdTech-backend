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
@RequiredArgsConstructor
public class SecurityConfig {
    private static final String[] WHITE_LIST_URL = {"/api/auth/login",
            "/api/auth/register",
            "/api/auth/activate/**",
            "/rdv/getall",
            "/user/getallenseignants",
            "/user/getallstudents",
            "/user/getall",
            "/rdv/{id}/status",
            "/event/save",
            "/rdv/update",
            "/rdv/delete/{id}",
            "/rdv/{id}/status",
            "/rdv/save"
    };
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(cors -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(List.of("*"));
            config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
            config.setAllowedHeaders(List.of("*"));
            cors.configurationSource(request -> config);
        });

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL)
                                .permitAll()
                                .requestMatchers("/Niveau/all").hasAnyRole("ADMIN")
                                .requestMatchers("/api/classes").hasAnyRole("ADMIN")
                                .requestMatchers(GET, "/Niveau/get/**").hasAnyAuthority("ETUDIANT")
                                .requestMatchers(POST, "/Niveau/**").hasAnyAuthority("ETUDIANT")
                                .requestMatchers(PUT, "/Niveau/**").hasAnyAuthority("ENSEIGNANT")
                                .requestMatchers(DELETE, "/Niveau/**").hasAnyAuthority("ENSEIGNANT")
                                .requestMatchers(DELETE, "/user/delete/**").hasAnyAuthority("ETUDIANT")
                                .requestMatchers(GET, "/user/getall").hasAnyAuthority("ADMIN","ETUDIANT")
                                .requestMatchers(PUT, "/user/update").hasAnyAuthority("ADMIN", "ENSEIGNANT")
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
