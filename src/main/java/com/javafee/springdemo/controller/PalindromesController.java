package com.javafee.springdemo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javafee.springdemo.entity.Numerator;
import com.javafee.springdemo.service.PalindromesService;

@Controller
@RequestMapping("/number")
public class PalindromesController {
	@Autowired
	private PalindromesService palindromesService;

	@GetMapping("/list")
	public String listNumbers(Model model) {
		List<Numerator> numbersList = palindromesService.getNumber();
		model.addAttribute("numbers", numbersList);
		return "list-numbers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Numerator number = new Numerator();
		model.addAttribute("number", number);
		return "number-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("numberId") int id, Model model) {
		Numerator number = palindromesService.getNumberById(id);
		model.addAttribute("number", number);
		return "number-form";
	}

	@GetMapping("/search")
	public String search(@RequestParam("searchNumber") int value, Model model) {
		List<Numerator> numbers = palindromesService.searchNumberByValue(value);
		model.addAttribute("numbers", numbers);
		return "list-numbers";
	}

	@GetMapping("/deleteNumber")
	public String deleteNumber(@RequestParam("numberId") int id) {
		palindromesService.deleteNumberById(id);
		return "redirect:/number/list";
	}

	@PostMapping("/saveNumber")
	public String saveNumber(@ModelAttribute("number") Numerator number) {
		palindromesService.checkNumberCorrectness(number.getValue());
		number.setAdditionDate(new Date(System.currentTimeMillis()));
		boolean isPalindrome = palindromesService.checkNumberIsPalindrome(number.getValue());
		number.setIsPalindrome(isPalindrome);
		palindromesService.saveNumber(number);
		return "redirect:/number/list";
	}

	@GetMapping("/checkNumber")
	public String checkNumberIsPalindrome(@RequestParam("checkNumber") int value, Model model) {
		boolean isPalindrome = palindromesService.checkNumberIsPalindrome(value);
		Numerator number= new Numerator(null, value,null, isPalindrome);
		model.addAttribute("nr", number);
		return "redirect:/number/list";
	}
}
