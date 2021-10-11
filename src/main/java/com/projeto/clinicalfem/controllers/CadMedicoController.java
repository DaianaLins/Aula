package com.projeto.clinicalfem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.clinicalfem.models.CadMedico;
import com.projeto.clinicalfem.repository.CadMedicoRepository;

@Controller
public class CadMedicoController {
	
		@Autowired
		private CadMedicoRepository cadmr;
		
		@RequestMapping("/medicos")
		public ModelAndView CadMedico(){
			ModelAndView mv = new ModelAndView("medicosCadastrados");
			Iterable<CadMedico> cadmedicos = cadmr.findAll();
			mv.addObject("cadmedicos", cadmedicos);
			return mv;
		}
		@RequestMapping(value="/cadastrarMedico", method=RequestMethod.GET)
		public String form() {
			return "formCadMedico";
		}
		@RequestMapping(value="/cadastrarMedico", method=RequestMethod.POST)
		public String form(CadMedico cadmedico) {
			cadmr.save(cadmedico);
			return "redirect:/cadastrarMedico";
		}

}
