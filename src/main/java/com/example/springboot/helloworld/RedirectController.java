package com.example.springboot.helloworld;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@Validated
public class RedirectController {
	
	@GetMapping(path="/redirectxxx")
	public String redirect() {
		return "redirect";
	}
	
	@GetMapping("/redirect_old")
    public RedirectView redirectWithUsingRedirectView(
      RedirectAttributes attributes) {
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("http://localhost/test/redirect.php");
    }
	
	@GetMapping("/redirect")
    public RedirectView redirectWithUsingRedirectView2(@RequestParam Map<String,String> allParams,
      RedirectAttributes attributes) {
        
		for(Map.Entry<String, String> queryString : allParams.entrySet()) {
			attributes.addAttribute(queryString.getKey(), queryString.getValue());
		}

        return new RedirectView("http://localhost/test/redirect.php");
    }	
	
	@GetMapping("/redirectParam/{id}")
    public RedirectView redirectWithUsingRedirectParam(@RequestParam Map<String,String> allParams, @PathVariable String id, 
    		HttpServletResponse response,
    		RedirectAttributes attributes) {
        
		for(Map.Entry<String, String> queryString : allParams.entrySet()) {
			attributes.addAttribute(queryString.getKey(), queryString.getValue());
		}
		
		String url = "http://localhost/test/redirect.php";
		url = url + "/" + id;
		
		
        return new RedirectView(url);
    }	
	
	@GetMapping("/redirectHeader")
    public RedirectView redirectWithHeaders( 
    		HttpServletResponse response,
    		RedirectAttributes attributes) {        
		
		
		String url = "http://localhost/test/redirect_header.php";		
		
        return new RedirectView(url);
    }	

}
