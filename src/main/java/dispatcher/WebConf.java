package dispatcher;

import dispatcher.DispatcherServlet;

import java.util.Arrays;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class WebConf {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(DispatcherServlet.class);
	
	
	@Bean
    public ServletRegistrationBean customServletBean(ServletContext servletContext) {
		
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
		
		/*
		ServletRegistrationBean srb = new ServletRegistrationBean();
        srb.setServlet(new DispatcherServlet());
        srb.setUrlMappings(Arrays.asList("/path2/*"));
        LOGGER.info(">>>>>>>>>>> CustomServlet doGet() method is invoked 2222");
        return srb;
        */
        
		
		/*
        ServletRegistrationBean bean
                = new ServletRegistrationBean(new DispatcherServlet(), "/*");
        
        LOGGER.info(">>>>>>>>>>> CustomServlet doGet() method is invoked 2222");
        return bean;
        */
		
		return null;
    }
	

	/*
	@Bean
    public ServletListenerRegistrationBean<ServletContextListener> customListenerBean() {
        ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean();
        bean.setListener(new CustomListener());
        return bean;
    }
    */

}
