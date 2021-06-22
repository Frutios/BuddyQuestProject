package com.buddyquest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthController {
    @GetMapping("/auth/login")
    public String displayLoginPage(HttpSession session) {
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        if (loggedIn) {
            return "redirect:/listevent";
        } else {
            return "/auth/login";
        }
    }
    @PostMapping("/auth/login")
    public String login(HttpServletRequest req, HttpServletResponse res) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Map<String, String> messages = new HashMap<>();

        if (username == null || username.isEmpty()) {
            messages.put("username", "Please enter username");
        }

        if (password == null || password.isEmpty()) {
            messages.put("password", "Please enter password");
        }

        if (messages.isEmpty()) {

            if (username.equals("admin") && password.equals("admin")) {
                req.getSession().setAttribute("user", username);
                return "redirect:/listevent";
            } else {
                messages.put("login", "Unknown login, please try again");
            }
        }
        req.setAttribute("messages", messages);
        return "/auth/login";
    }
    @GetMapping("/auth/logout")
    public String displayLogoutPage() {
        return "/auth/logout";
    }

    @PostMapping("/auth/leave")
    public String logout(HttpSession session, @RequestParam("leave") boolean leaveOk) {
        if (leaveOk) {
            session.invalidate();
        }
        return "redirect:/auth/login";
    }
}
