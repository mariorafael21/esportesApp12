package com.example.esportesapp.controller;

import com.example.esportesapp.model.Produto;
import com.example.esportesapp.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProdutoContoller {

    ProdutoService service;
    @Autowired
    public void setService(ProdutoService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String getPage(Model model){

        var listaProdutos = service.findAll();
        model.addAttribute("listaProdutos", listaProdutos);
        return "index";
    }
    @RequestMapping("/cadastrar")
    public String getFormCadastro(Model model){
        Produto produto = new Produto();
        model.addAttribute("produto", produto);

        return "cadastrar";

    }
    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String doSalvar(@ModelAttribute @Valid Produto produto, Errors errors){

        if(errors.hasErrors()){
            return "cadastrar";
        }else{
            service.save(produto);
            return "redirect:/";
        }

    }

    @RequestMapping("/deletar/{id}")
    public String doDeletar(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";
    }
    @RequestMapping("/editar/{id}")
    public ModelAndView getFormEdicao(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("editar");
        Produto produto= service.findById(id);
        modelAndView.addObject("produto", produto);
        return modelAndView;
    }


}
