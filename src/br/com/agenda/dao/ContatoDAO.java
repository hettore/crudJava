package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {

	/*
	 * crud c: create r: read u: update d: delete
	 */

	public void save(Contato contato) {


		String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES(?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// criando uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();

			// criando uma PreparedStatement, para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			// adicionar os valores q são esperados pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

			// executar a query
			pstm.execute();

			System.out.println("Contato salvo com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// fechar as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	

	
	public void update(Contato contato) {
		
		String sql = "UPDATE contatos SET nome = ?, idade = ?, datacadastro = ? " +
		"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//criar a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//adicionar os valores para atualizar
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			//qual o id do registro que deseja atualizar
			pstm.setInt(4, contato.getId());
			
			//executar a query
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				
				}if(conn!=null) {
				conn.close();
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
}	
	
	
	
	public void deleteByID(int id) {
		
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
				
		}
	}
	
	
	

	public List<Contato> getContatos(){
		
		String sql = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. SELECT
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Contato contato = new Contato();
				
				//recuperar o id
				contato.setId(rset.getInt("id"));
				//recuperar o nome
				contato.setNome(rset.getString("nome"));
				//recuperar a idade
				contato.setIdade(rset.getInt("idade"));
				//recuperar a data de cadastro
				contato.setDataCadastro(rset.getDate("datacadastro"));
				
				contatos.add(contato);
				
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				
				try {
					if (rset != null) {
						rset.close();	
					}
			
					if (pstm!=null) {
						pstm.close();
					}
			
					if(conn!=null) {
						conn.close();
					}
			
				}catch (Exception e) {
				e.printStackTrace();
				}
			}
			
			return contatos;
		
	}
}

		
