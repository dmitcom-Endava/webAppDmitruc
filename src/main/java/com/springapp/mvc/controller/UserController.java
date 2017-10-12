package com.springapp.mvc.controller;

import com.springapp.mvc.model.Gender;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.springapp.mvc.model.Gender.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(Model model) {
        model.addAttribute("message", "Hi there! Log in, please");
        model.addAttribute("listOfAges",userService.getListOfAges());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("user") User user) {
        System.out.println(user);
        if (userService.checkUser(user)) {

            model.addAttribute(user);
            return "redirect:/allusers";
        } else {
            model.addAttribute("error", "Invalid Details");
            return "error";
        }
    }

    @RequestMapping(value = "/allusers", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("listOfAges", userService.getListOfAges());
        model.addAttribute("listOfGender", userService.getGenderList());
        return "welcome";
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("age") int age,@ModelAttribute("gender") Gender gender) {
        model.addAttribute("list", userService.getAllByGenderAge(gender, age));
        model.addAttribute("gender", gender);
        model.addAttribute("age", age);
        return "genderAge";

    }

    @RequestMapping(value = "/showMales", method = RequestMethod.GET)
    public String showOnlyMales(Model model) {
        model.addAttribute("gender", "boys");
        model.addAttribute("list", userService.getAllByGender(MALE));
        model.addAttribute("age", "18");
        model.addAttribute("listByAges",userService.getAllByAge(18));
        return "gender";
    }

    @RequestMapping(value = "/showFemales", method = RequestMethod.GET)
    public String showOnlyFemales(Model model) {
        model.addAttribute("gender", "girls");
        model.addAttribute("list", userService.getAllByGender(FEMALE));
        model.addAttribute("age", "27");
        model.addAttribute("listByAges",userService.getAllByAge(27));
        return "gender";
    }

}