package com.uca.capas.TareaLabo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.TareaLabo3.domain.Product;

@Controller
public class ProductController {
	
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0, "La Agonia de Julian Bacaicoa", 35));
		productos.add(new Product(1, "Ana Karenina", 20));
		productos.add(new Product(2, "Guerra y Paz", 28));
		productos.add(new Product(3, "Miedo", 15));
		productos.add(new Product(4, "Crimen y Castigo", 13));
		productos.add(new Product(5, "El hombre en busca de sentido", 7));
		
		mav.setViewName("select");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		
		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		
		if(productos.get(product.getId()).getCantidad() >= product.getCantidad()) {
			mav.setViewName("compra");
			mav.addObject("nombre", productos.get(product.getId()).getNombre());
		} else {
			mav.setViewName("error");
			mav.addObject("nombre", productos.get(product.getId()).getNombre());
		}
		
		return mav;
	}
}
