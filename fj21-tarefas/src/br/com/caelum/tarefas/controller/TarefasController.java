package br.com.caelum.tarefas.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.model.ConnectionFactory;
import br.com.caelum.tarefas.model.Tarefa;
import br.com.caelum.tarefas.model.TarefaDAO;

@Controller
public class TarefasController {

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasFieldErrors("descricao")){
			return "tarefa/formulario";
		}
		
		try {
			Connection conn = new ConnectionFactory().getConnection();
			TarefaDAO dao = new TarefaDAO(conn);
			dao.adcionaTarefa(tarefa);
			conn.close();
			return "tarefa/tarefa-adicionada";
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
