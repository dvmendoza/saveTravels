package com.dvmendoza.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dvmendoza.savetravels.models.Expense;
import com.dvmendoza.savetravels.services.ExpenseService;

@Controller
public class MainController {
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		System.out.println(expenses);
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
        if (result.hasErrors()) {
    		List<Expense> expenses = expenseService.allExpenses();
    		model.addAttribute("expenses", expenses);
            return "index.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/";
        }
	}

}
