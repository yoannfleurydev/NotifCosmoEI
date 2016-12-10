package eu.yoannfleury;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@EnableAutoConfiguration
@ComponentScan
@Configuration
@SpringBootApplication
public class NotifCosmoEiServerApplication {
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());

		// FireWall
		registrationBean.addUrlPatterns("/users/*");
		registrationBean.addUrlPatterns("/ingredients/*");
		registrationBean.addUrlPatterns("/notifications/*");
		registrationBean.addUrlPatterns("/effects/*");
		registrationBean.addUrlPatterns("/products/*");

		return registrationBean;
	}

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
		messageBundle.setBasename("classpath:messages/messages");
		messageBundle.setDefaultEncoding("UTF-8");
		return messageBundle;
	}

	public static void main(String[] args) {
		SpringApplication.run(NotifCosmoEiServerApplication.class, args);
	}
}
