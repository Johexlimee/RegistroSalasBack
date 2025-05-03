package co.edu.ue.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtUtil jwtUtil;

    public SecurityConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuración de seguridad
        http.csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Usar el Bean de CORS
            .authorizeHttpRequests(requests -> requests
                // Permitir acceso sin autenticación a Swagger UI y OpenAPI
                .requestMatchers(
                    "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html",
                    "/v3/api-docs.yaml", "/v2/api-docs/**", "/webjars/**"
                ).permitAll()
                // Permitir acceso sin autenticación al endpoint de login
                .requestMatchers(HttpMethod.POST, "/api/usuarios/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/usuarios/register").permitAll()
                // Permitir acceso a rutas adicionales específicas
                // Proteger todas las demás rutas
                //.requestMatchers(HttpMethod.POST, "/control-salas/registro").hasAnyAuthority("ADMINISTRADOR", "PROFESOR")
                // ✅ Permite acceso solo a roles específicos
                .anyRequest().permitAll())
            // Registrar el filtro JWT antes de los filtros de autenticación
            .addFilterBefore(new AuthorizationFilterJWT(jwtUtil, List.of(
                "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html"
            )), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4200")); // Origen permitido
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos permitidos
        configuration.setAllowedHeaders(List.of("*")); // Cabeceras permitidas (incluye todas)
        configuration.setAllowCredentials(true); // Habilitar credenciales

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Aplicar configuración a todas las rutas
        return source;
    }
}
