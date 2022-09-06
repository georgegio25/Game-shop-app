// game
package com.gri.JavaExam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gri.JavaExam.models.Game;
import com.gri.JavaExam.models.User;
import com.gri.JavaExam.services.GameService;
import com.gri.JavaExam.services.UserService;

@Controller
public class GameController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private GameService gameServ;
	
	// display
	
	//============= all changes here =================================
	
	@GetMapping("/")
	public String index(Model model) {
		return "redirect:/home";
	}
	
	//============= END all changes here =============================


    @GetMapping("/home") // #1login this is the home page:
    public String games(Model model, HttpSession session){
    	if(session.getAttribute("uuid")!=null) { // #2login if user logged in, he can add new game or log out
    	model.addAttribute("user", userServ.getOne((Long) session.getAttribute("uuid")));
    }
    	model.addAttribute("games", gameServ.getAll()); // #3login if not logged in, he can just see games, no adding (this goes to games.jsp items (line 27))
    	return "games.jsp";
    }
    
    @GetMapping("/games/{id}")
    public String card(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if(session.getAttribute("uuid")==null) { // we're adding these to lines on top of each route to make sure user can't go to this page unless he's logged in
    		//return "redirect:/"; // removed    		
    		model.addAttribute("game", gameServ.getOne(id)); // added
    		return "card.jsp"; // added
    	}
    	model.addAttribute("user", userServ.getOne((Long) session.getAttribute("uuid"))); // we have to pass user's info to this page in order to show edit/delete buttons only to creator (see <c:if> in card.jsp). Also later need to do extra validation in routes to make sure they can't use link 
    	model.addAttribute("game", gameServ.getOne(id));
    	
    	return "card.jsp";
    	
    }

    
    @GetMapping("/games/new") // TODO validation 
    public String newGame(@ModelAttribute("game") Game game, HttpSession session) {
    	if(session.getAttribute("uuid")==null) { // we're adding these to lines on top of each route to make sure user can't go to this page unless he's logged in
    		return "redirect:/"; // 
    	} //
    	return "newGame.jsp"; 
    }
    
    @GetMapping("/games/{id}/edit")
    public String editGame(@PathVariable("id") Long id, Model model, HttpSession session, Game game) {    
    	
        if(session.getAttribute("uuid")==null ) { // validations: you can't visit this page if you're: not logged in
    		return "redirect:/";  
    	} 
    	
    	model.addAttribute("game", gameServ.getOne(id));
    	model.addAttribute("user", userServ.getOne((Long) session.getAttribute("uuid")));
    	return "edit.jsp";    	
    }
    
      
    
    // ACTION
    @PostMapping("/games/create")
    public String createGame(@Valid @ModelAttribute("game") Game game, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "newGame.jsp";
    	}
    	User user = userServ.getOne((Long) session.getAttribute("uuid"));	// in order to get creator's id, we can either use hidden input in our form or
    	game.setCreator(user); // we must make sure that each game connected to user, otherwise relationship won't be made. 
    	gameServ.save(game);
    	
    	return "redirect:/home";
    }
    
    @PutMapping("/games/{id}/update")
    public String updateGame(@Valid @ModelAttribute("game") Game game, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "edit.jsp";
    	}else {
    		User user = userServ.getOne((Long) session.getAttribute("uuid"));	// in order to get creator's id, we can either use hidden input in our form or
        	game.setCreator(user);
    		gameServ.save(game);
    		
    		return "redirect:/home";
    	}
    }
    
    
    @RequestMapping(value="/games/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        gameServ.delete(id);
        return "redirect:/home";
    }

}