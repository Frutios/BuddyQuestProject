package com.buddyquest.controllers;

import java.time.LocalDate;
import java.util.List;

import com.buddyquest.models.User;

import com.buddyquest.services.BaseService;
import com.buddyquest.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

	@Autowired
    private BaseService<User, Long> userService;



	@GetMapping("/api/users")
	public String user(HttpServletRequest req, Model model) {
		String sId = req.getParameter("id");
		Long lId = Long.parseLong(sId);
		User user = userService.findById(lId);
		model.addAttribute("User", user);
		return "users";
	}
	@GetMapping("/api/listUser")
	public List<User> allUser(Model model) {
		List<User> listUser = userService.getAll();
		model.addAttribute("listUser",listUser);
		return listUser;
	}

	@PostMapping("/api/addUser")
	public String addUser(HttpServletRequest req) {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String inscriptionDate = req.getParameter("inscriptionDate");
		LocalDate dateInscription = LocalDate.now();
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String localisationId = req.getParameter("localisationId");
		String password = req.getParameter("password");
		String pseudonym = req.getParameter("pseudonym");

		try {
			User newUser = new User();
			newUser.setFirstName(firstName);
			newUser.setLastName(lastName);
			newUser.setInscriptionDate(dateInscription);
			newUser.setEmail(email);
			newUser.setPassword(password);
			newUser.setPseudonym(pseudonym);
			//user.setLocalisation(localisationId);
			userService.create(newUser);

		} catch (Exception e) {

		}
		return "";
	}

}