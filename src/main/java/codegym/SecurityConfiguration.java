package codegym;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("staff").password("staff").roles("STAFF")
                .and()
                .withUser("admin").password("admin").roles("ADMIN");
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
//                .loginProcessingUrl("/user-login")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().csrf().disable();
    }
}
