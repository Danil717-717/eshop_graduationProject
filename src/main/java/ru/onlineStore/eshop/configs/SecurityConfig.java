package ru.onlineStore.eshop.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.onlineStore.eshop.services.PersonDetailsService;

/**
 * Класс конфигурации безопасности
 *
 * @author Строев Д.В., Пакулин Ю.А.
 * @version 1.5
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Бин filterChain
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin").hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers("/registration", "/error", "/resources/**", "/static/**", "/css/**", "/js/**",
                        "/pics/**", "/images/**", "/product", "/product/info/{id}", "/product/search",
                        "/product/searchHeader", "/logout", "/contacts", "/company", "/wholesalers").permitAll()
                .anyRequest()
                .authenticated()
        );
        http.formLogin(login -> login
                .loginPage("/login")
                .loginProcessingUrl("/loginProcess")
                .defaultSuccessUrl("/userPage", true)
                .failureUrl("/login?error")
                .permitAll());
        http.logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/product")
                .permitAll());
        return http.build();
    }

    /**
     * Бин getPasswordEncode
     */
    @Bean
    public PasswordEncoder getPasswordEncode() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Бин personDetailsService
     */
    @Bean
    public PersonDetailsService personDetailsService() {
        return new PersonDetailsService();
    }

    /**
     * Бин authenticationProvider
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(personDetailsService());
        provider.setPasswordEncoder(getPasswordEncode());
        return provider;
    }
}