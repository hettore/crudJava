package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("João Dias");
		contato.setIdade(75);
		contato.setDataCadastro(new Date());
		
		//contatoDao.save(contato);
		
		//atualizar o contato.
		Contato c1 = new Contato();
		c1.setNome("Maria Gabriela Dias Orlando");
		c1.setIdade(37);
		c1.setDataCadastro(new Date());
		c1.setId(1); // é o numero que esta no banco de dados da PK
		
		contatoDao.update(c1);
		
		//Visualização dos registros do banco de dados TODOS
		
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("contato: "+ c.getNome());
		}
	}

}
