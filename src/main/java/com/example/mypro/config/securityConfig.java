package com.example.mypro.config;
import com.example.mypro.filter.JWTAuthenticationTokenFilter;
import com.example.mypro.handler.AccessDeniedHandlerImpl;
import com.example.mypro.handler.AuthenticationEntryPointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class securityConfig {

    @Autowired
    private AuthenticationEntryPointImpl authenticationEntryPoint;
    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandler;
    //http设置
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((authorizeRequests)
                        ->authorizeRequests
                        .requestMatchers("/**").hasAuthority("admin")
                        .requestMatchers("/admin/**").hasAuthority("admin")
                )
                .formLogin((formLogin)
                        ->formLogin
                        .successHandler((request,response,authentication)->{
                            response.setContentType("application/json;charset=utf-8");
                            response.getWriter().write("登录成功");
                        })
                        .failureHandler((request,response,exception)->{
                            response.setContentType("application/json;charset=utf-8");
                            response.getWriter().write("登录失败");
                        })
                )
                .logout((logout)
                        ->logout
                        .logoutSuccessHandler((request,response,authentication)->{
                            response.setContentType("application/json;charset=utf-8");
                            response.getWriter().write("注销成功");
                        })
                )
                .addFilterBefore(new JWTAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling((exceptionHandling)
                        ->exceptionHandling
                        .authenticationEntryPoint(authenticationEntryPoint)
                        .accessDeniedHandler(accessDeniedHandler)
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/login");
    }

}
