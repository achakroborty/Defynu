package com.defynu.Controller;


import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




import com.defynu.Services.Main;
import com.defynu.Services.SendEmail;
import com.defynu.Dao.LoginDao;
import com.defynu.Dao.RegisterDao;
import com.defynu.Model.User;
import com.defynu.Model.Shirt;


@Controller
@Scope("session") 
public class LoginController extends HttpServlet  {
	ArrayList<Shirt> sht = new ArrayList<Shirt>();
	String uname;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView homepage(@RequestParam Map<String,String> reqPar,HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			ModelAndView model= null;

			model = new ModelAndView("index");
		
		return model;
		}

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public ModelAndView loginsucess(@RequestParam Map<String,String> reqPar,HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(); 
		System.out.println(session);
		String email = reqPar.get("email");
		String password = reqPar.get("password");
		boolean result=false;
		uname=email;
		session.setAttribute(email, session);

		System.out.println(email+password);

		User user= new User(email,password);
		LoginDao login = new LoginDao();

		result=login.isValidUser(user);


		System.out.println(result);

		ModelAndView model= null;

		if(result)
		{		 model = new ModelAndView("hello");
		System.out.println("User Login Successful");
		model.addObject("loggedInUser", user.getEmail());
		model.addObject("uname",session.getAttribute(email));

		Main crt= new Main();
		ArrayList<Shirt> sht1 = new ArrayList<Shirt>();
		sht1=crt.ShowCart(uname);
		System.out.println("sht1 ka size" + sht1.size());
		int j=0;
		int cart =0;
		while(j<sht1.size())
		{
			cart=cart+ sht1.get(j).getQty();
			j++;
		}
		model.addObject("cart", cart);
		model.addObject("cart", cart);
		}

		else
		{
			model = new ModelAndView("hello");
			model.addObject("message", "Invalid credentials!!");

		}

		return model; 

	}

	@RequestMapping(value = "/hello" , method = RequestMethod.GET)
	public ModelAndView  printHello(@RequestParam Map<String,String> reqPar,HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session=request.getSession(false); 
		ModelAndView model= null;
		if (session == null) {
			session = request.getSession();

			model = new ModelAndView("hello");

			Main crt= new Main();
			String y;
			ArrayList<Shirt> sht1 = new ArrayList<Shirt>();
			
			sht1=crt.ShowCart(uname);
			System.out.println("sht1 ka size" + sht1.size());
			int j=0;
			int cart =0;
			while(j<sht1.size())
			{
				cart=cart+ sht1.get(j).getQty();
				j++;
			}
			cart=sht.size();
			System.out.println("hhhhhh"+ sht.size());
			model.addObject("cart", cart);
			
			model.addObject("cart", cart);




		}

		else
		{		
			HttpSession session1=request.getSession(); 
			System.out.println(session1); 
			model = new ModelAndView("hello");
			System.out.println("User Login Successful");
			model.addObject("loggedInUser", uname);

			Main crt= new Main();
			String y;
			ArrayList<Shirt> sht1 = new ArrayList<Shirt>();
			//	y=crt.AddtoCart(shirt,uname);
			sht1=crt.ShowCart(uname);
			System.out.println("sht1 ka size" + sht1.size());
			int j=0;
			int cart =0;
			while(j<sht1.size())
			{
				cart=cart+ sht1.get(j).getQty();
				j++;
			}
			cart=cart+sht.size();
			System.out.println("hhhhhh"+ sht.size());
			model.addObject("cart", cart);
			/*for (int i = 0; i < sht.size(); i++) {
							System.out.println(sht.get(i).body + sht.get(i).outercollar);
						}
			 */
			model.addObject("cart", cart);

		} 

		return model; 

	}



	/* ****************************** SignOut ********************** */

	@RequestMapping(value = "/signout" , method = RequestMethod.GET)
	public ModelAndView  logout(@RequestParam Map<String,String> reqPar,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.invalidate();
		ModelAndView model= null;

		model = new ModelAndView("index");
		return model; 
	}

	/* ****************************** Register ********************** */


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam Map<String,String> reqPar) {
		String email = reqPar.get("email");
		String password = reqPar.get("password");  
		String result;

		User user= new User(email,password);
		RegisterDao register = new RegisterDao();

		result=register.isRegister(user);


		System.out.println(result);

		ModelAndView model= null;

		if(result == "N")
			{	
		SendEmail	mail= new SendEmail();
		mail.mail(email);
			model = new ModelAndView("hello");
		System.out.println("User Registered Successful");
		model.addObject("loggedInUser", user.getEmail());
		 

		}
		else
		{
			model = new ModelAndView("hello");
			model.addObject("message", "EmailId Already Registered");

		}

		return model; 

	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerForm(){

		ModelAndView model = new ModelAndView("hello");

		return model;
	}


}
