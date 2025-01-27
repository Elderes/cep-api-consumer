package com.accenture.consumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.accenture.consumo.model.Endereco;
import com.accenture.consumo.repository.EnderecoRepository;

@Controller
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/endereco/form")
    public String showForm(Model model) {
        model.addAttribute("endereco", new Endereco());
        return "endereco";
    }

    @PostMapping("/endereco/salvar")
    public String saveEndereco(@ModelAttribute Endereco endereco) {
        enderecoRepository.save(endereco);
        return "redirect:/endereco/form";
    }
}
