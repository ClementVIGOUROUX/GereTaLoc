package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Bail;
import modele.Caution;
import modele.dao.requetes.RequeteSelectCaution;
import modele.dao.requetes.RequeteSelectCautionBail;
import modele.dao.requetes.RequeteSelectCautionById;
import modele.dao.requetes.RequeteSelectCautionLogementImmeuble;
import modele.dao.requetes.SousProgrammeInsertCaution;

public class DaoCaution extends DaoModele<Caution> implements Dao<Caution> {

	private static Iterateur<Caution> iterateurCaution ;
	
	@Override
	public void create(Caution donnees) throws SQLException {
		SousProgrammeInsertCaution sP = new SousProgrammeInsertCaution();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sP.appelSousProgramme());
		
		sP.parametres(st, donnees.getNom(),
						  donnees.getEmail(),
						  donnees.getTelephone(),
						  String.valueOf(donnees.getBail().getIdBail()));
		
		st.execute();
		st.close();
		
	}

	@Override
	public void update(Caution donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Caution donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Caution findById(String... id) throws SQLException {
		RequeteSelectCautionById req = new RequeteSelectCautionById();
		return this.findById(req, id);
	}

	@Override
	public List<Caution> findAll() throws SQLException {
		RequeteSelectCaution req = new RequeteSelectCaution();
		return this.find(req);
	}

	@Override
	protected Caution creerInstance(ResultSet curseur) throws SQLException {
		DaoBail daoBail = new DaoBail();
		Bail b = daoBail.findById(curseur.getString(5));
		
		return new Caution(curseur.getInt(1),curseur.getString(2),curseur.getString(3),curseur.getString(4),b);
	}

	public static Iterateur<Caution> getIterateurCaution() {
		return iterateurCaution ;
	}
	
	public Iterateur<Caution> findByIdIterateur(String...id) throws SQLException{
        RequeteSelectCautionById req = new RequeteSelectCautionById();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoCaution.iterateurCaution = new Iterateur<Caution>(res, this);
        return DaoCaution.iterateurCaution;
    }
	
	public Iterateur<Caution> findByBailIterateur(String...id) throws SQLException{
		RequeteSelectCautionBail req = new RequeteSelectCautionBail();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoCaution.iterateurCaution = new Iterateur<Caution>(res, this);
        return DaoCaution.iterateurCaution;
    }
	
	public Iterateur<Caution> findByLogementImmeubleIterateur(String...id) throws SQLException{
		RequeteSelectCautionLogementImmeuble req = new RequeteSelectCautionLogementImmeuble();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0],id[1]);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoCaution.iterateurCaution = new Iterateur<Caution>(res, this);
        return DaoCaution.iterateurCaution;
    }
	
}
