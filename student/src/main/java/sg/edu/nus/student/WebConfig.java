package sg.edu.nus.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import sg.edu.nus.student.interceptors.LoggingInterceptor;

@Component
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	LoggingInterceptor logInterceptor;
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(logInterceptor);
	}
	
}
