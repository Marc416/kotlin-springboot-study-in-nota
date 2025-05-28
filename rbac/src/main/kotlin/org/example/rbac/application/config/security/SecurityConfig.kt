package org.example.rbac.application.config.security


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.web.SecurityFilterChain


@Configuration
class SecurityConfig{


    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        //CSRF, CORS
        http.csrf { csrf: CsrfConfigurer<HttpSecurity> -> csrf.disable() }
//        http.cors(Customizer.withDefaults())

        // 권한 규칙 작성
        http.authorizeHttpRequests { httpRequest ->
            httpRequest.requestMatchers("/account/password/*").authenticated()
            httpRequest.requestMatchers("/account/**").permitAll()
            httpRequest.requestMatchers(
                "/swagger/**",
                "/swagger-ui/**",
                "/api-docs/**"
            ).permitAll()
            httpRequest.anyRequest().authenticated()
        }



        return http.build()
    }

}