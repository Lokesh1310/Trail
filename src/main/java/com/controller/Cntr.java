package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Cntr {

	@RequestMapping("/tax")
	public String t() {
		
		System.out.println("ram------------------------------------------------------Ram");
return "input.jsp";
	
	}
	
	
	@RequestMapping("/compute")
	public void compute(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		int income=Integer.parseInt(req.getParameter("t1"));
		int age=Integer.parseInt(req.getParameter("t2"));
		
		int tax=0;
		int rebate=0;
		int netTax=0;
		if(income>=500000) {
			
			tax=income*20/100;
		}
		else {
			
			tax=income*10/100;
			
		}
		
		
		if(age>=60) {
			
			rebate=tax*20/100;
		}

	
		netTax=tax-rebate;
		
		PrintWriter out=res.getWriter();
		
		
		out.println("Income:"+income);
		out.println("Age:"+age);
		out.println("Tax:"+tax);
		out.println("Rebate:"+rebate);
		out.println("NetTax:"+netTax);
		
		
	} 
	
	
	
}
