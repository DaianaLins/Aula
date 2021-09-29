package com.projeto.clinicalfem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.projeto.clinicalfem.models.CadPaciente;
import com.projeto.clinicalfem.repository.CadPacienteRepository;

@Controller
public class CadPacienteController {
		
		@Autowired
		private CadPacienteRepository cadpr;
		
		
		
		@RequestMapping("/pacientes")
		public ModelAndView Pacientes() {
			ModelAndView mv = new ModelAndView("pacientesCadastrados");
			Iterable<CadPaciente> cadpacientes = cadpr.findAll();
			mv.addObject("cadpacientes", cadpacientes);
			return mv;
		}
		
		@RequestMapping(value="/cadastrarPaciente", method=RequestMethod.GET)
		public String form() {
			return "formCadPaciente";
		}
		@RequestMapping(value="/cadastrarPaciente", method=RequestMethod.POST)
		public String form(CadPaciente cadpaciente) {
			cadpr.save(cadpaciente);
			return "redirect:/cadastrarPaciente";
		}
	

}
