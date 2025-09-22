package com.pradip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pradip.model.User;
import com.pradip.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping
	public String list(Model model) {
		model.addAttribute("users", service.list());
		System.out.println(model);
		return "users/list";
	}

	@GetMapping("/new")
	public String newForm(Model model) {
		model.addAttribute("user", new User());
		return "users/form";
	}

	@GetMapping("/{id}")
	public String view(@PathVariable Long id, Model model, RedirectAttributes ra) {
		return service.find(id).map(user -> {
			model.addAttribute("user", user);
			return "users/view";
		}).orElseGet(() -> {
			ra.addFlashAttribute("error", "User not found");
			return "redirect:/users";
		});
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("user") User user, BindingResult br, RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "users/form";
		}
		service.createOrUpdate(user);
		ra.addFlashAttribute("success", "Saved user successfully");
		return "redirect:/users";
	}

	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Long id, RedirectAttributes ra) {
		service.delete(id);
		ra.addFlashAttribute("success", "Deleted user");
		return "redirect:/users";
	}
}
