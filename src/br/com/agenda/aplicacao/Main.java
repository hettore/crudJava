package br.com.agenda.aplicacao;

import java.util.Scanner;

import br.com.agenda.dao.ContatoDAO;

public class Main {

	Scanner sc = new Scanner(System.in);
	ContatoDAO contatoDao = new ContatoDAO();

	public static void main(String[] args) {

		Program crud = new Program();
		crud.menu();

	}
}
