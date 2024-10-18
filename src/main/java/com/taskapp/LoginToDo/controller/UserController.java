package com.taskapp.LoginToDo.controller;

//import java.util.List;
//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import com.taskapp.LoginToDo.constants.Constants;
import com.taskapp.LoginToDo.controller.bean.User;
import com.taskapp.LoginToDo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	 // Redirect root to login page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "redirect:/login";
    }
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String welcomePage(ModelMap model, @RequestParam String userId, @RequestParam String password) {
		User user = userService.getUserByUserId(userId);
		
		if (user != null && user.getPassword().equals(password)) {
				//session.setAttribute("loggedInUser", userId);
				model.put("userId", userId);
				return "redirect:/viewToDoList";
				//return "user";
			}
		
		model.put("errorMsg", "Please provide the correct userid and password");
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user, ModelMap model) {
		int count = userService.createNewUser(user);
		
		 if (count == -1) {
		        model.put("errorMsg", "User ID already exists. Please choose a different User ID.");
		        return "register"; 
		    } else if (count != 1) {
		        model.put("errorMsg", "Some issue occurred with registration.");
		        return "register"; 
		    }
		    
		    model.put("successMsg", "User created successfully!!");
		    return "login"; 
		}
	
}