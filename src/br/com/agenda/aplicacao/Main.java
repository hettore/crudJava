package br.com.agenda.aplicacao;

import br.com.agenda.dao.ContatoDAO;

public class Main {

		ContatoDAO contatoDao = new ContatoDAO();

	public static void main(String[] args) {

		Program crud = new Program();
		crud.menu();

	}
}
