package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Immeuble;
import modele.dao.requetes.RequeteSelectImmeuble;
import modele.dao.requetes.RequeteSelectImmeubleById;
import modele.dao.requetes.SousProgrammeInsertImmeuble;

public class DaoImmeuble extends DaoModele<Immeuble> implements Dao<Immeuble> {
	
	private static Iterateur<Immeuble> iterateurImmeuble ;

	//@Override
	//public void create(Immeuble donnees) {
		// TODO Auto-generated method stub
		//ATTEND LE TP FINI POUR IMPLEMENTER LA METHODE CREATE AFIN DAJOUTER UN IMMEUBLE
		//inserer_immeuble(donnees) ;
	//}
	
	public void create(Immeuble donnees) throws SQLException {
		
		SousProgrammeInsertImmeuble sP = new SousProgrammeInsertImmeuble();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sP.appelSousProgramme());
		
		String stringFibre ;
		if (donnees.isFibre() == true) {
			stringFibre = "1";
		} else {
			stringFibre = "0";
		}
		
		sP.parametres(st, donnees.getCp(), donnees.getVille(), donnees.getPays(), 
					  donnees.getRue(), stringFibre);
		st.execute();
		st.close();
	}

	@Override
	public void update(Immeuble donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Immeuble donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Immeuble findById(String... id) throws SQLException {
		RequeteSelectImmeubleById req = new RequeteSelectImmeubleById();
		return this.findById(req, id);
	}

	@Override
	public List<Immeuble> findAll() throws SQLException {
		RequeteSelectImmeuble rsI = new RequeteSelectImmeuble();
		return this.find(rsI);
	}

	@Override
	protected Immeuble creerInstance(ResultSet curseur) throws SQLException {
		return new Immeuble(curseur.getInt(1),curseur.getString(2), curseur.getString(3),curseur.getString(4),curseur.getString(5),curseur.getBoolean(6));
	}

	public static Iterateur<Immeuble> getIterateurImmeuble() {
		return iterateurImmeuble ;
	}
	
	public Iterateur<Immeuble> findAllIterateur() throws SQLException{
        RequeteSelectImmeuble req = new RequeteSelectImmeuble();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoImmeuble.iterateurImmeuble = new Iterateur<Immeuble>(res, this);
        return DaoImmeuble.iterateurImmeuble;
        
    }
	

	
}
