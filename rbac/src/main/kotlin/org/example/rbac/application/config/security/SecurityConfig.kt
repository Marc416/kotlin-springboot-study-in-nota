package org.example.rbac.application.config.security


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
class SecurityConfig{


    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        //CSRF, CORS
        http.csrf { csrf: CsrfConfigurer<HttpSecurity> -> csrf.disable() }
//        http.cors(Customizer.withDefaults())

        // 권한 규칙 작성
        http.authorizeHttpRequests { httpRequest ->
            httpRequest.anyRequest().permitAll()
        }



        return http.build()
    }

}