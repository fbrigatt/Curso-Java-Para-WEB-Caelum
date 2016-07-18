package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {

	@RequestMapping("/olaMundoSpring")
	public String OlaMundo() {
		System.out.println("Executando Ola Mundo no Spring!");
		return "ok";
	}
}
