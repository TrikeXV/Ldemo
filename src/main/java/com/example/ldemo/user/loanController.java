package com.example.ldemo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class loanController {
    @Autowired private service ls;

    @GetMapping("/loans")
    public String loanList(Model model){
        List<user> listLoans = ls.allLoans();
        model.addAttribute("listLoans",listLoans);
        return "loans";
    }

    @GetMapping("/loans/add")
    public String newLoan(Model model){
        model.addAttribute("loan",new user());
        return "newLoan";
    }

    @PostMapping("/loans/save")
    public String saveLoan(user users){
        ls.save(users);
        return "redirect:/loans";
    }


}
