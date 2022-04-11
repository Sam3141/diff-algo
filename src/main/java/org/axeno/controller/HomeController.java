package org.axeno.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import org.axeno.diff.Diffclass;


/**
 * Servlet implementation class HomeController
 */
@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/*
	 * public HomeController() { super(); // TODO Auto-generated constructor stub }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String text1 = request.getParameter("textarea1");
		text1=text1.replace("\n"," <br> ");
		String text2 = request.getParameter("textarea2");
		text2=text2.replace("\n"," <br> ");

		List<List<String>> ans = prediffalgo(text1,text2);
		request.setAttribute("ans", ans);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private List<List<String>> prediffalgo(String text1,String text2){
		List<List<String>> ans = null;
		String[] oldt = text1.split(" ");
		String[] newt = text2.split(" ");
		List<String> oldtxt=new ArrayList<String>();
		List<String> newtxt=new ArrayList<String>();
		for(int i=0;i<oldt.length;i++) {
			if(!(oldt[i].equals(""))) {
				oldtxt.add(oldt[i].trim());
			}
		}
		
		System.out.println(oldtxt);
		
		for(int i=0;i<newt.length;i++) {
			if(!(newt[i].equals(""))) {
				newtxt.add(newt[i].trim());
			}
		}
		
		System.out.println(newtxt);
		
		ans = (new Diffclass()).diffwbyw(oldtxt, newtxt);
		return ans;
	}

}
