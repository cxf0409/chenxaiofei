package cn.com.taiji.learn.sshelloworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("i")
                .password(passwordEncoder().encode("i"))
                .roles("USER")
                .and().withUser("a")
                .password(passwordEncoder().encode("a"))
                .roles("ADMIN");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/test/bar").permitAll()
                .antMatchers("/user/test/ou").hasRole("USER")
                .antMatchers("/user/test/foo").hasRole("ADMIN")
                .anyRequest().authenticated();
        http.formLogin()
        .loginPage("/login1").permitAll()
                .loginProcessingUrl("/doLogin");

        http.logout().permitAll().logoutUrl("/logout");
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/images/**","/css/**");
    }
}
