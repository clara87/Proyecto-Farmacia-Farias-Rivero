package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControladorFarmacia5 {	
	//http://localhost:8080/proyecto-limpio-spring/operacion/3/+/6
			@RequestMapping("/operacion/{operando1}/{operador}/{operando2}")
			public ModelAndView operacion (@PathVariable Integer operando1, 
											@PathVariable  String operador,
											@PathVariable  Integer operando2){
					ModelMap modelo = new ModelMap();		
					modelo.put("o1", operando1);
					modelo.put("o2", operando2);
					modelo.put("op", operador);
					String  s = "+";
					if (operador.equals(s))
						return new ModelAndView("vistaCorrecta",modelo);
					
					else return new ModelAndView("vistaIncorrecta",modelo);		
			}
}
