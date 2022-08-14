package br.com.school.crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.school.aluno.Aluno;
import br.com.school.conexao.Conexao;

public class AgendaDAO {
	//Métodos do CRUD, para o Delete foi usado opção por id ou exclusão de dos cadastros
	
	public void save (Aluno aluno) {

		String sql = "INSERT INTO alunos (nome, idade, disciplina, serie, turma) VALUES (?,?,?,?,?) ";
		Connection conn =  null; 

		PreparedStatement pstm = null;

		try {
			conn =  Conexao.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1,aluno.getNomeAluno()); 
			pstm.setInt(2, aluno.getIdade());
			pstm.setString(3, aluno.getDisciplina());
			pstm.setString(4, aluno.getSerie());
			pstm.setString(5, aluno.getTurma());
			pstm.execute();
			System.out.println("O Aluno " +  aluno.getNomeAluno() +" foi inserido com sucesso!");
		
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally  {
			try {
				if (pstm != null ) {
					pstm.close(); 
				}
				if (pstm != null ) {
					conn.close(); }

			} catch (Exception e ) {
				e.printStackTrace();
			}
		}
	}

	public List<Aluno> getAlunos () {

		String sql = "SELECT * FROM alunos";
		List<Aluno> alunos = new ArrayList<Aluno>();

		Connection conn =  null; 
		PreparedStatement pstm = null;
	
		ResultSet rset= null; 

		try {
			conn =  Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql); 
			rset = pstm.executeQuery(sql);

			while (rset.next()) {
				Aluno dadosAlunos = new Aluno (); 

				dadosAlunos.setIdAluno(rset.getInt("id"));
				dadosAlunos.setNomeAluno(rset.getString("Nome"));
				dadosAlunos.setIdade(rset.getInt("Idade"));
				dadosAlunos.setSerie(rset.getString("Serie"));
				dadosAlunos.setTurma(rset.getString("Turma"));
				dadosAlunos.setDisciplina(rset.getString("Disciplina"));

				alunos.add(dadosAlunos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset !=null ) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn!=null ) {
					conn.close();
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
		} return alunos; 
	}

	public void update (Aluno aluno) {
		String sql = "UPDATE alunos SET nome = ?, idade = ?, disciplina = ?, serie = ? ," + 
				" turma = ? WHERE  id = ?";  

		Connection conn =  null; 
		PreparedStatement pstm = null;
		try {
			conn =  Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql); 

			pstm.setString(1, aluno.getNomeAluno());
			pstm.setInt(2, aluno.getIdade());
			pstm.setString(3, aluno.getDisciplina());
			pstm.setString(4, aluno.getSerie());
			pstm.setString(5, aluno.getTurma());

			pstm.setInt(6, aluno.getIdAluno());

			pstm.execute();

			System.out.println("Os dados do aluno" + aluno.getNomeAluno() + "foi alterado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			try {
				if (pstm!= null ) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				} 
			}catch (Exception e ) {
				e.printStackTrace();
			}
		}
	}

	public void deleteId (int id) {

		String sql = "DELETE FROM alunos WHERE id  = ? "; 

		Connection conn =  null; 
		PreparedStatement pstm = null;

		try {
			conn =  Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql); 

			pstm.setInt(1, id);
			pstm.execute();

		}  catch (Exception e) {
			e.printStackTrace();
		}  finally {
			try {
				if (pstm != null ) {
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
	public void deleteList () {

		String sql = "DELETE FROM alunos "; 

		Connection conn =  null; 
		PreparedStatement pstm = null;

		try {
			conn =  Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql); 

			pstm.execute();
			System.out.println("A lista da turma foi excluída com sucesso");
		}  catch (Exception e) {
			e.printStackTrace();
		}  finally {
			try {
				if (pstm != null ) {
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
}

