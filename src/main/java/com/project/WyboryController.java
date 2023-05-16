package com.project;

    import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
        @Controller
        public class WyboryController {

        @GetMapping("/wybory")
        public String showForm() {
            return "form";
        }

        @PostMapping("/submit")
        public String submitForm(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("age") int age,
                                 Model model) {
            model.addAttribute("firstName", firstName);
            model.addAttribute("lastName", lastName);
            model.addAttribute("age", age);

            if (age < 18) {
                return "cannotVote";
            } else if (age < 35) {
                return "canVote";
            } else {
                return "canRunForPresident";
            }
        }
    }


