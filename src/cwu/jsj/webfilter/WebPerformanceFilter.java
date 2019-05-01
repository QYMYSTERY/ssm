package cwu.jsj.webfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class WebPerformanceFilter implements Filter{
	
	private FilterConfig filterConfig;
	private static final String ENCODING = "UTF-8";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String ENCODE=filterConfig.getInitParameter("Encode");
		if(ENCODE==null){
			ENCODE = ENCODING;
		}
		request.setCharacterEncoding(ENCODE);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig=arg0;
	}

}