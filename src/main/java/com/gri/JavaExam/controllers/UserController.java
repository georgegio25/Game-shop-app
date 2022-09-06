// r
package com.gri.JavaExam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gri.JavaExam.models.LoginUser;
import com.gri.JavaExam.models.User;
import com.gri.JavaExam.services.UserService;

//.. don't forget to inlcude all your imports! ..



@Controller
public class UserController {
//	
	@Autowired 
	private UserService serv;
        
	// Display
//	@GetMapping("/welcome") // changed from "/" to /welcome
//    public String index(Model model, HttpSession session) {
//		if(session.getAttribute("uuid")!=null) { // we're adding these to lines on top of each route to make sure user can't go to this page unless he's logged in
//			model.addAttribute("user", serv.getOne((Long) session.getAttribute("uuid"))); // adding attribute user if he logged in and going back to home page
//			return "redirect:/home"; // but don't forget to add session
//    	} //
//    
//        model.addAttribute("newUser", new User());
//        model.addAttribute("newLogin", new LoginUser());
//        return "index.jsp";
//    }
	
	@GetMapping("/register") // changed from "/" to /welcome
    public String indexReg(Model model, HttpSession session) {
		if(session.getAttribute("uuid")!=null) { // we're adding these to lines on top of each route to make sure user can't go to this page unless he's logged in
			model.addAttribute("user", serv.getOne((Long) session.getAttribute("uuid"))); // adding attribute user if he logged in and going back to home page
			return "redirect:/home"; // but don't forget to add session
    	} //
    
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "register.jsp";
    }
	
	@GetMapping("/signin") // changed from "/" to /welcome
    public String indexSign(Model model, HttpSession session) {
		if(session.getAttribute("uuid")!=null) { // we're adding these to lines on top of each route to make sure user can't go to this page unless he's logged in
			model.addAttribute("user", serv.getOne((Long) session.getAttribute("uuid"))); // adding attribute user if he logged in and going back to home page
			return "redirect:/home"; // but don't forget to add session
    	} //
    
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "signIn.jsp";
    }
    
    // action
    
    @PostMapping("/register/go")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
    	User user = serv.register(newUser, result);

        
        if(result.hasErrors()) {
            
            model.addAttribute("newLogin", new LoginUser());
            
            return "register.jsp";
            
        }
        
      session.setAttribute("uuid", user.getId());
        
    
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
    	User user = serv.login(newLogin, result);  
        
        // Add once service is implemented:
        // User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "signIn.jsp";
         
        }
        session.setAttribute("uuid", user.getId());       
        return "redirect:/home";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("uuid");
    	
    	return "redirect:/";
    }
    
}