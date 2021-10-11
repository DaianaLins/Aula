package com.projeto.clinicalfem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.clinicalfem.models.Agendamento;
import com.projeto.clinicalfem.repository.AgendamentoRepository;

@Controller
public class AgendamentoController {
	
	@Autowired
	private AgendamentoRepository ar;
	
	/**@Autowired
	private CadPacienteRepository cadpr;*/
	
	@RequestMapping("/consultas")
	public ModelAndView Consultas() {
		ModelAndView mv = new ModelAndView("consultasAgendadas");
		Iterable<Agendamento> agendamentos = ar.findAll();
		mv.addObject("agendamentos", agendamentos);
		return mv;
	}
	
	@RequestMapping(value="/agendarConsulta", method=RequestMethod.GET)
	public String form() {
		return "formAgendamento";
	}
	@RequestMapping(value="/agendarConsulta", method=RequestMethod.POST)
	public String form(Agendamento agendamento) {
		
		ar.save(agendamento);
		return "redirect:/agendarConsulta";
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesConsulta(@PathVariable("codigo") long codigo) {
		Agendamento agendamento = ar.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("detalhesConsulta");
		mv.addObject("agendamento", agendamento);
		return mv;
	}
	/*@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesConsulta(@PathVariable("codigo") long codigo, CadPaciente cadpaciente) {
		Agendamento agendamento = ar.findByCodigo(codigo);
		cadpaciente.setAgendamento(agendamento);
		cadpr.save(cadpaciente);
		return "redirect:/{codigo}";
	}*/

}
