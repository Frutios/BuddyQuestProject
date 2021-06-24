package com.quest.buddy.controller;

import com.quest.buddy.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

import com.quest.buddy.services.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public void addUser(HttpServletRequest req) {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String inscriptionDateStr = req.getParameter("inscriptionDate");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String pseudonym = req.getParameter("pseudonym");
        String phone = req.getParameter("phone");


        LocalDate inscriptionDate = null;
        try {
            inscriptionDate = LocalDate.parse(inscriptionDateStr);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setInscriptionDate(inscriptionDate);
        user.setEmail(email);
        user.setPassword(password);
        user.setPseudonym(pseudonym);
        user.setPhone(phone);

        userService.create(user);
    }

    @GetMapping("/display-user-form")
    public String displayUserForm(){

        return "adduser";
    }


    @PostMapping("/auth/delete-car")
    public String deleteCar(@RequestParam("id") Long idParam) {
        // carService.removeCar(idParam);
        return "redirect:/list-car";
    }

    @GetMapping({"/", "/list-car"})
    public String displayHomePage(Model model) {
        // List<Car> carList = carService.fetchAllCars();
        // model.addAttribute("carList", carList);
        return "carlist";
    }

    @GetMapping("/details-car")
    public String displayDetails(@RequestParam("id") Long idParam, Model model) {
        // Car car = carService.fetchSpecificCar(idParam);
        // model.addAttribute("car", car);
        return "cardetails";
    }

}
