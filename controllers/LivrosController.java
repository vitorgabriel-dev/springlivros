package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import web.model.Livros;
import web.repository.LivrosRepository;

@Controller
public class LivrosController {
@Autowired
	private LivrosRepository lr;

	@RequestMapping(value="/cadastrarLivros", method=RequestMethod.GET)
	public String form(){
		return "livros/formLivros";
	}
	
	@RequestMapping(value="/cadastrarLivros", method=RequestMethod.POST)
	public String form(Livros usuario){
		
		lr.save(usuario);
		return "redirect:/cadastrarLivros";
	}	

	@RequestMapping("/listaLivros")
		public ModelAndView listaLivros(){
			
			ModelAndView mv = new ModelAndView("livros/listaLivros");
			
			Iterable<Livros> livros = lr.findAll();
			//ur.findById(null)
			
			mv.addObject("livros", livros);
			return mv;
		}
	}
