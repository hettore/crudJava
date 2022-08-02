package br.com.agenda.aplicacao;

import java.util.Date;
import java.util.Scanner;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Program {

	Scanner sc = new Scanner(System.in);

	ContatoDAO contatoDao = new ContatoDAO();

	// Menu de navegação do aplicativo
	public void menu() {

		System.out.println("Bem vindo ao CRUD em Java");
		System.out.println();
		System.out.println("Escolha uma opção a seguir: ");
		System.out.println("Opção 1 - Adicionar um novo contato.");
		System.out.println("Opção 2 - Atualizar um contato existente.");
		System.out.println("Opção 3 - Apagar um contato.");
		System.out.println("Opção 4 - Mostrar contatos existentes.");
		System.out.println("Opção 5 - Fechar o programa.");
		System.out.print("Opção desejada: ");

		int escolha = sc.nextInt();

		switch (escolha) {
		case 1:

			System.out.println();
			adicionarContato();
			System.out.println();
			System.out.println("---------------------------------");
			System.out.println("voltando para o menu inicial.");
			System.out.println("---------------------------------");
			System.out.println();
			menu();

			break;

		case 2:

			System.out.println();
			atualizar();
			System.out.println("---------------------------------");
			System.out.println("voltando para o menu inicial.");
			System.out.println("---------------------------------");
			System.out.println();
			menu();

			break;

		case 3:

			System.out.println();
			deletar();
			System.out.println("---------------------------------");
			System.out.println("voltando para o menu inicial.");
			System.out.println("---------------------------------");
			System.out.println();
			menu();

			break;

		case 4:

			System.out.println();
			mostrar();
			System.out.println("---------------------------------");
			System.out.println("voltando para o menu inicial.");
			System.out.println("---------------------------------");
			System.out.println();
			menu();

			break;

		case 5:

			System.out.println();
			System.out.println("Obrigado por utilizar nosso programa! Até a próxima.");
			break;

		default:
			System.out.println("Por favor escolha uma opção válida.");
		}
		// sc.close();
	}

	// Adicionar um contato no banco de dados
	public void adicionarContato() {

		Scanner c = new Scanner(System.in);

		Contato contato = new Contato();
		System.out.println("Digite o nome a ser adicionado: ");
		contato.setNome(c.nextLine());
		System.out.println("Digite a idade: ");
		contato.setIdade(c.nextInt());
		contato.setDataCadastro(new Date());

		contatoDao.save(contato);

	}

	// atualizar o contato.
	public void atualizar() {
		
		Scanner c = new Scanner(System.in);

		Contato c1 = new Contato();
		System.out.println("Digite um novo nome: ");
		c1.setNome(c.nextLine());
		System.out.println("Digite a nova idade: ");
		c1.setIdade(c.nextInt());
		c1.setDataCadastro(new Date());
		System.out.println("digite o id do contato a ser atualizado: ");
		c1.setId(c.nextInt()); // é o numero que esta no banco de dados da PK

		contatoDao.update(c1);
	}

	// Deletar o contato pelo numero de ID
	public void deletar() {

		System.out.println("Por favor para apagar um contato insira o id: ");
		int selecao = sc.nextInt();
		System.out.println("Tem certeza que deseja apagar o contato que esta na posição:  " + selecao + " s/n?");
		String escolha = sc.next();
		if (escolha.equals("s")) {
		
		contatoDao.deleteByID(selecao);
		} else if (escolha.equals("n")) {
			System.out.println("Contato não foi apagado.");
			System.out.println("Voltando para o menu.");
			menu();
		} else {
			System.out.println("por favor insira um valor válido");
			System.out.println("Voltando para o menu.");
			menu();
		}
	}

	// Visualização dos registros do banco de dados TODOS
	public void mostrar() {

//		for (Contato c : contatoDao.getContatos()) {
//			System.out.println("Id: " + c.getId() + " " + "Nome: " + c.getNome());
//		}

		contatoDao.getContatos().forEach(System.out::println);
	}

}
