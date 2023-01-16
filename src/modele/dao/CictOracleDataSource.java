package modele.dao;
import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

@SuppressWarnings("serial")
public class CictOracleDataSource extends OracleDataSource {


	private static Connection connection;
	
	private CictOracleDataSource(String login, String mdp) throws SQLException {
		this.setURL("jdbc:oracle:thin:@telline.univ-tlse3.fr:1521:etupre");
		this.setUser(login);
		this.setPassword(mdp);
	}
	
	public static void creerAcces(String login, String mdp) throws SQLException {
		CictOracleDataSource bd = new CictOracleDataSource(login, mdp);
		CictOracleDataSource.connection = bd.getConnection();
	}
	
	public static Connection getConnectionBD() {
		return CictOracleDataSource.connection;
	}
	
	public static void Deconnecter() throws SQLException {
		CictOracleDataSource.connection.close();
		CictOracleDataSource.connection = null;
	}

}
