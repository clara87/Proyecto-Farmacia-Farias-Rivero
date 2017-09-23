package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Operaciones;


@Controller
public class ControladorFarmacia5 {	
	
			@RequestMapping("/operacion/{operando1}/{operador}/{operando2}")
			public ModelAndView operacion (@PathVariable Integer operando1, 
											@PathVariable  String operador,
											@PathVariable  Integer operando2){				
				Operaciones operaciones = new Operaciones(operando1, operando2, operador);
							
					ModelMap modelo = new ModelMap();		
					modelo.put("operaciones", operaciones);
					Integer resultado = null;
					
					String  s = "+";
					if (operador.equals(s)){
						resultado = operando1+operando2;
						modelo.put("resul", resultado);
						//http://localhost:8080/proyecto-limpio-spring/operacion/3/+/6
						return new ModelAndView("vistaCorrecta",modelo);}					
					else	
						//http://localhost:8080/proyecto-limpio-spring/operacion/3/-/6
						return new ModelAndView("vistaIncorrecta",modelo);		
			}
}
