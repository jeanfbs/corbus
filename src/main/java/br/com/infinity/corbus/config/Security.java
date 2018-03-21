package br.com.infinity.corbus.config;

import br.com.infinity.corbus.auth.AuthSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        .antMatchers("/css/**","/js/**", "/images/**", "/vendor/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

            http
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/registration", "/list").permitAll()
                    .antMatchers("/cpanel/dashboard").hasRole("USER")
                .anyRequest().authenticated().and()
                .formLogin()
                    .loginProcessingUrl("/auth")
                    .loginPage("/auth")
                    .failureUrl("/login-error")
                    .successHandler( new AuthSessionHandler())
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("remember-me").and()
                .rememberMe()
                .key("C0RBVS")
                .tokenValiditySeconds(300);
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }


    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
