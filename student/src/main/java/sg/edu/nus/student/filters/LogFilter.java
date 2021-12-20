package sg.edu.nus.student.filters;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class LogFilter implements Filter {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest  req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		LOGGER.setLevel(Level.ALL);
		LOGGER.severe("Filter: This is the ONLY severe warning");
		LOGGER.warning("Filter: Normal Warning Message");
		LOGGER.info("Filter: This is just for developer information");
		LOGGER.finest("Filter: Silly fine message");
		LOGGER.info("Filter: Logging Request  {} : {} "+req.getMethod()+" "+req.getRequestURI());
		// Call next filter in the filter chain
		chain.doFilter(request, response);
		LOGGER.info("Filter: Logging Response :{} "+res.getContentType());
	}
}
