package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// nome do usuario do mysql
	private static final String USERNAME = "root";

	// Senha do banco
	private static final String PASSWORD = "";

	// caminho do banco de dados, porta, nome do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";

	// conexão com o banco de dados

	public static Connection createConnectionToMySQL() throws Exception {
		// faz com que a classe seja carregada pela jvm
		Class.forName("com.mysql.jdbc.Driver");

		// cria a conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}

	public static void main(String[] args) throws Exception {

		// Recuperar a conexão com o banco de dados
		Connection con = createConnectionToMySQL();

		// testar se a conexão é nula
		if (con != null) {
			System.out.println("Conexão obtida com sucesso!");
			con.close();
		}

	}

}
