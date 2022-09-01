package dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DispatcherServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER=LoggerFactory.getLogger(DispatcherServlet.class);
	
	
	@Override
    protected void doGet(
        HttpServletRequest req,
        HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info(">>>>>>>>>>> CustomServlet doGet() method is invoked");
            super.doGet(req, resp);
    }
	
	

}
