package codegym;

import codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("user").roles("USER")
//                .and()
//                .withUser("staff").password("staff").roles("STAFF")
//                .and()
//                .withUser("admin").password("admin").roles("ADMIN");
        auth.userDetailsService((UserDetailsService) userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/","/blog","/staff","/gallery","/user/**")
                .permitAll()
                .and().authorizeRequests().antMatchers("/blog/**")
                .hasAnyRole("USER","STAFF","ADMIN")
                .and()
                .authorizeRequests().antMatchers("/staff/**")
                .hasAnyRole("STAFF","ADMIN")
                .and()
                .authorizeRequests().antMatchers("/gallery/**","/admin/**")
                .hasRole("ADMIN")
                .and().formLogin()
                .loginPage("/login")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().csrf().disable();
    }
}
