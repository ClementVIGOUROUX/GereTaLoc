package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterateur<T> implements Iterator<T> {
	
	private ResultSet resultSet ;
	private boolean nextrS ;
	private DaoModele<T> daoModele ;
	
	
	public Iterateur(ResultSet rS, DaoModele<T> dM) throws SQLException {
		this.resultSet = rS ;
		this.daoModele = dM ;
		this.nextrS = rS.next();
	}

	@Override
	public boolean hasNext() {
		return this.nextrS ;
	}

	@Override
	public T next() throws NoSuchElementException {
		T donnee = null ;
		try {
			donnee = this.daoModele.creerInstance(this.resultSet);
			this.nextrS = this.resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (donnee == null) {
			throw new NoSuchElementException();
		}
		
		return donnee ;
	
	}

}
