package modele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import modele.dao.requetes.Requete;

public abstract class DaoModele<T> implements Dao<T> {

	protected abstract T creerInstance(ResultSet curseur) throws SQLException;
	
	protected List<T> select(PreparedStatement prSt) throws SQLException {
		List<T> result = new LinkedList<T>();
		ResultSet curseur = prSt.executeQuery();
		while (curseur.next()) {
			result.add(this.creerInstance(curseur));
		}
		curseur.close();
		prSt.close();
		return result;
	}
	
	public int miseAJour(Requete<T> req, T donnee) throws SQLException, ParseException {
		Connection cn = CictOracleDataSource.getConnectionBD();
		PreparedStatement prSt = cn.prepareStatement(req.requete());
		req.parametresT(prSt, donnee);
		int k = prSt.executeUpdate();
		//prSt.close();
		return k;
	}
	
	public List<T> find(Requete<T> req, String... id) throws SQLException {
		Connection cn = CictOracleDataSource.getConnectionBD();
		PreparedStatement prSt = cn.prepareStatement(req.requete());
		req.parametresID(prSt, id);
		return this.select(prSt);
	}
	
	public T findById(Requete<T> req, String... id) throws SQLException {
		List<T> result = this.find(req, id);
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
	}

	
	
}