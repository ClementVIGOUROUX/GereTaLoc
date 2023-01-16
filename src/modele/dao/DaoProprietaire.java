package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import modele.Proprietaire;
import modele.dao.requetes.RequeteSelectProprietaire;
import modele.dao.requetes.RequeteSelectProprietaireById;
import modele.dao.requetes.RequeteUpdateProprietaire;

public class DaoProprietaire extends DaoModele<Proprietaire>  implements Dao<Proprietaire> {

	@Override
	public void create(Proprietaire donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Proprietaire donnees) throws SQLException {
		RequeteUpdateProprietaire req = new RequeteUpdateProprietaire() ;
		try {
			this.miseAJour(req, donnees);
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Proprietaire donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Proprietaire> findAll() throws SQLException {
		RequeteSelectProprietaire rsc = new RequeteSelectProprietaire();
		return this.find(rsc);
	}

	@Override 
	public Proprietaire findById(String... id) throws SQLException { 
		RequeteSelectProprietaireById req = new RequeteSelectProprietaireById();
		return this.findById(req, id);
	}

	@Override
	protected Proprietaire creerInstance(ResultSet curseur) throws SQLException {
		
		return new Proprietaire(curseur.getInt(1), curseur.getString(2), curseur.getString(3),
						  curseur.getString(4), curseur.getString(5));
	}



}
