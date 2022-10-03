package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Pizza;
import com.cydeo.repository.PizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/design")
public class DesignPizzaController {

    private final PizzaRepository pizzaRepository;

    @GetMapping
    public String showDesignForm(Model model) {

        model.addAttribute("pizza", new Pizza());
        model.addAttribute("cheeses", DataGenerator.cheeseTypeList);
        model.addAttribute("sauces", DataGenerator.sauceTypeList);
        model.addAttribute("toppings", DataGenerator.toppingTypeList);

        return "/design";

    }

    @PostMapping("/createPizza")
    public String processPizza(@ModelAttribute("pizza") Pizza pizza) {

        pizzaRepository.createPizza(pizza);

        return "redirect:/orders/current?pizzaId=" + pizza.getId() ;
    }

}
