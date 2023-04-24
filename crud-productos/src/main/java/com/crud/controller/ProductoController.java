package com.crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.model.Producto;
import com.crud.repository.ProductoRepository;

@Controller
@RequestMapping("/productos")//http:localhost:8080/productos
public class ProductoController {

	
	
	@Autowired
	private ProductoRepository productoRepository; 
	
	@GetMapping("")
	public String home(Model model) {
		
		model.addAttribute("productos", productoRepository.findAll());
		
	    return "home";
	}
	
	@GetMapping("/create")//http:localhost:8080/productos/create
	public String create() {
	
		return "create";
		
	}
	
	@PostMapping("/save")
	public String save(Producto producto) {
		
		productoRepository.save(producto);
		return "redirect:/productos";
	}
	
	
	
}






