package com.example.springboot.dispatchservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dispatcher.DispatcherServlet;

import com.example.springboot.helloworld.*;


@WebServlet(name = "StudentServlet", urlPatterns = "/whatever")
//@WebServlet(name = "StudentServlet")
public class StudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER=LoggerFactory.getLogger(DispatcherServlet.class);
	
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOGGER.info("user servlet" + request.getRequestURI());
		RequestDispatcher rd=request.getRequestDispatcher("/user");  
        rd.forward(request, response);  
		//super.doGet(request, response);
		//processRequest(request, response);
	}
        
   

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("processing user here");
		
		//UserController userController = new UserController();
		//userController.redirect();		
	}
}
