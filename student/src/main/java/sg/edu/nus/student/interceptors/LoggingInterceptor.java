package sg.edu.nus.student.interceptors;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
    public boolean preHandle(HttpServletRequest request, HttpServletResponse 
            response, Object handler) {
    	LOGGER.setLevel(Level.ALL);
		LOGGER.info("Interceptor: preHandle");
		return true;
	}
    
    public void postHandle(HttpServletRequest request, HttpServletResponse 
    		response, Object handler, ModelAndView modelAndView) {
    		LOGGER.info("Interceptor: postHandle");
    	}
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, Object handler, Exception ex) {
			LOGGER.info("Interceptor: afterCompletion");
		}



}
