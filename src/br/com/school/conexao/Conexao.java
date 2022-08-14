package br.com.school.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/agenda";

	public static Connection createConnectionToMySQL() throws Exception {

		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}

	public static void main(String[] args) throws Exception {

		Connection con = createConnectionToMySQL();
		if(con!=null) {
			System.out.println("Conexão realizada com sucesso!");
			con.close();
		}
	}
}
