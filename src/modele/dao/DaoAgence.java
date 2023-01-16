package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Agence;
import modele.dao.requetes.RequeteSelectAgence;
import modele.dao.requetes.RequeteSelectAgenceById;
import modele.dao.requetes.RequeteSelectAgenceLogementImmeuble;
import modele.dao.requetes.SousProgrammeInsertAgence;

public class DaoAgence extends DaoModele<Agence> implements Dao<Agence>{

	private static Iterateur<Agence> iterateurAgence;
	
	@Override
	public void create(Agence donnees) throws SQLException {
		SousProgrammeInsertAgence sP = new SousProgrammeInsertAgence();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sP.appelSousProgramme());
		
		sP.parametres(st, donnees.getnSiret(),
						  donnees.getNom(),
						  donnees.getAdresse(),
						  donnees.getCp(),
						  donnees.getVille(),
						  donnees.getTelephone(),
						  donnees.getEmail());
		st.execute();
		st.close();
		
	}

	@Override
	public void update(Agence donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Agence donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Agence> findAll() throws SQLException {
		RequeteSelectAgence req = new RequeteSelectAgence();
		return this.find(req);
	}

	@Override 
	public Agence findById(String... id) throws SQLException { 
		RequeteSelectAgenceById req = new RequeteSelectAgenceById();
		return this.findById(req, id);
	}

	@Override
	protected Agence creerInstance(ResultSet curseur) throws SQLException {
		
		return new Agence(curseur.getString(1), curseur.getString(2), curseur.getString(3),
						  curseur.getString(4), curseur.getString(5), curseur.getString(6),
						  curseur.getString(7));
	}
	
	public static Iterateur<Agence> getIterateurAgence() {
		return iterateurAgence ;
	}
	
	public Iterateur<Agence> findByLogementImmeubleIterateur(String...id) throws SQLException{
		RequeteSelectAgenceLogementImmeuble req = new RequeteSelectAgenceLogementImmeuble();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0],id[1]);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoAgence.iterateurAgence = new Iterateur<Agence>(res, this);
        return DaoAgence.iterateurAgence;
    }

}
