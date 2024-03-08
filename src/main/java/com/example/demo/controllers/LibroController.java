package com.example.demo.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Genero;
import com.example.demo.model.Libro;
import com.example.demo.service.GeneroService;
import com.example.demo.service.LibroService;

@Controller
@RequestMapping("/libros")
public class LibroController {

	@Autowired
	private LibroService libroService;

	@Autowired
	private GeneroService generoService;

	@GetMapping("/libros")
	public String getAllLibros(Model model) {

		List<Libro> listLibros = libroService.getAllLibros();

		model.addAttribute("libros", listLibros);

		return "libroList";
	}

	@GetMapping("/register")
	public String register(Model model) {
		List<Genero> listGenero = generoService.getAllGeneros();
		model.addAttribute("generos", listGenero);
		return "libroRegister";
	}

	@PostMapping("/register")
	public String createLibro(@RequestParam("nombre") String nombre, @RequestParam("autor") String autor,
			@RequestParam("fechaEstreno") Date fechaEstreno, @RequestParam("generoId") Long generoId, Model model) {

		Libro libro = new Libro();
		libro.nombre = nombre;
		libro.autor = autor;
		libro.fechaEstreno = fechaEstreno;
		
		Genero genero = generoService.getGeneroById(generoId);
		libro.genero = genero;

		libroService.createLibro(libro);

		List<Libro> listLibro = libroService.getAllLibros();

		model.addAttribute("libros", listLibro);

		return "libroList";
	}

	@GetMapping("/edit/{id}")
	public String getLibroByID(@PathVariable Long id, Model model) {
		Libro libro = libroService.getLibroById(id);
		List<Genero> listGenero = generoService.getAllGeneros();

		model.addAttribute("libro", libro);
		model.addAttribute("generos", listGenero);
		return "libroEdit";
	}

	@PostMapping("/edit")
	public String editLibro(@RequestParam("id") Long id, @RequestParam("nombre") String nombre,
			@RequestParam("autor") String autor, @RequestParam("fechaEstreno") Date fechaEstreno,
			@RequestParam("generoId") Long generoId, Model model) {

		Libro libro = libroService.getLibroById(id);
		libro.nombre = nombre;
		libro.autor = autor;
		libro.fechaEstreno = fechaEstreno;

		Genero genero = generoService.getGeneroById(generoId);
		libro.genero = genero;

		libroService.createLibro(libro);

		List<Libro> listLibro = libroService.getAllLibros();
		model.addAttribute("libros", listLibro);

		return "libroList";
	}

	@GetMapping("/delete/{id}")
	public String deleteLibro(@PathVariable Long id, Model model) {
		libroService.deleteLibro(id);

		List<Libro> listLibro = libroService.getAllLibros();
		model.addAttribute("libros", listLibro);

		return "libroList";
	}

}
