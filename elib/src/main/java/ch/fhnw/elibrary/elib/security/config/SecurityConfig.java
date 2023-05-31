// Security part not implemented, as requirements for assignment changed

// package ch.fhnw.elibrary.elib.security.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// // TODO: uncomment when needed, commted out below imports, as they were throwing problems
// import com.nimbusds.jose.jwk.source.ImmutableSecret;
// //import com.wilddog.security.token.JwtEncoder;

// import ch.fhnw.elibrary.elib.business.service.UserDetailsServiceImpl;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.UserDetailsService;
// //import org.springframework.security.oauth2.*;
// // TODO: ?, did the import above, as the commted out below imports, as they were throwing problems
// import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
// import org.springframework.security.oauth2.jwt.JwtDecoder;
// import org.springframework.security.oauth2.jwt.JwtEncoder;
// import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
// import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import javax.crypto.spec.SecretKeySpec;
// import static org.springframework.security.config.Customizer.withDefaults;

// // SecurityConfig class derived from CRM-webservice example
// // author @michimel

// @Configuration
// @EnableWebSecurity
// @EnableMethodSecurity

// public class SecurityConfig {

// 	@Value("${jwt.key}")
//     private String jwtKey;

// 	@Bean
//     public UserDetailsService userDetailsService() {
//         /*return new InMemoryUserDetailsManager(
//             User.withUsername("user")
//                     .password("{noop}password")
//                     .authorities("READ","ROLE_USER")
//                     .build());*/
//         return new UserDetailsServiceImpl(); 
//     }

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//     return http
//         .csrf(AbstractHttpConfigurer::disable)
//         .authorizeHttpRequests(auth -> auth
//             // Paths accessible to all (including not logged in users)
//             // .requestMatchers("/", "/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**").permitAll()
//             // .requestMatchers("/api/auth/register").permitAll()
//           // TODO: uncomment when done line 67 to 79 and delete following lines 65 and 66
//           .requestMatchers("/**").permitAll()    // to check APIs and paths    
//         )
//             /*
//            .requestMatchers("/api/auth/token").authenticated() // Restricted to authenticated users

//             // Paths accessible to users with the "Admin" role
//             .requestMatchers("/api/author/newAuthor", "/api/author/updateAuthor/{authorID}",
//                           "/api/book/newBook", "/api/book/updateBook/{bookID}",
//                           "/api/genre/newGenre", "/api/genre/updateGenre/{genre_id}")
//                 .hasRole("ADMIN") // Restricted to users with the "Admin" role

//             // Paths accessible to authenticated users (including regular users and admins)
//             .anyRequest().authenticated()
//         )
//         */
//         .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//         .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//         .httpBasic(withDefaults())
//         .build();
// }


//     // TODO: check if these Beans are needed
	
//     @Bean
//     JwtEncoder jwtEncoder() {
//         return new NimbusJwtEncoder(new ImmutableSecret<>(jwtKey.getBytes()));
//     }

// 	@Bean
//     public JwtDecoder jwtDecoder() {
//         byte[] bytes = jwtKey.getBytes();
//         SecretKeySpec originalKey = new SecretKeySpec(bytes, 0, bytes.length,"RSA");
//         return NimbusJwtDecoder.withSecretKey(originalKey).macAlgorithm(MacAlgorithm.HS512).build();
//     }
    

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public AuthenticationProvider authenticationProvider(){
//         DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
//         authenticationProvider.setUserDetailsService(userDetailsService());
//         authenticationProvider.setPasswordEncoder(passwordEncoder());
//         return authenticationProvider;
//     } 

//     @Bean
//     public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//         return config.getAuthenticationManager();
//     }
// }