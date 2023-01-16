package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Immeuble;
import modele.Logement;
import modele.dao.requetes.RequeteSelectLogement;
import modele.dao.requetes.RequeteSelectLogementById;
import modele.dao.requetes.RequeteSelectLogementImmeuble;
import modele.dao.requetes.RequeteSelectLogementSansBail;
import modele.dao.requetes.SousProgrammeInsertLogement;

public class DaoLogement extends DaoModele<Logement> implements Dao<Logement>{

	private static Iterateur<Logement> iterateurLogement ;
	
	@Override
	public void create(Logement donnees) throws SQLException {
		
		SousProgrammeInsertLogement sP = new SousProgrammeInsertLogement();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sP.appelSousProgramme());
		
		String stringGarage ;
		if (donnees.isGarage() == true) {
			stringGarage = "1";
		} else {
			stringGarage = "0";
		}
		
		sP.parametres(st, Integer.toString(donnees.getImmeuble().getIdImmeuble()), donnees.getNumero(), donnees.getSurface(), 
					  Integer.toString(donnees.getNbPieces()), stringGarage, donnees.getParking());
		st.execute();
		
	}

	@Override
	public void update(Logement donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Logement donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Logement findById(String... id) throws SQLException {
		RequeteSelectLogementById req = new RequeteSelectLogementById();
		return this.findById(req, id);
	}

	@Override
	public List<Logement> findAll() throws SQLException {
		RequeteSelectLogement rsL = new RequeteSelectLogement();
		return this.find(rsL);
	}
	
	public List<Logement> findListLogementByImmeuble(String id) throws SQLException {
		RequeteSelectLogementImmeuble req = new RequeteSelectLogementImmeuble();
		return this.find(req,id);
	}
	
	public List<Logement> findListLogementSansBail(String... id) throws SQLException {
		RequeteSelectLogementSansBail req = new RequeteSelectLogementSansBail();
		return this.find(req,id);
	}

	@Override
	protected Logement creerInstance(ResultSet curseur) throws SQLException {
		DaoImmeuble daoImmeuble = new DaoImmeuble();
		//DaoBail daoBail = new DaoBail();
		Immeuble immeuble = daoImmeuble.findById(curseur.getString(1));
		//Bail bail = daoBail.findByLogement(curseur.getString(2), Integer.toString(immeuble.getIdImmeuble()));
		
		return new Logement(curseur.getString(2), curseur.getString(3), curseur.getInt(4) ,curseur.getBoolean(5),
				curseur.getString(6), immeuble,null) ;
	}
	
	public static Iterateur<Logement> getIterateurLogement() {
		return iterateurLogement ;
	}
	
	public Iterateur<Logement> findAllIterateur() throws SQLException{
        RequeteSelectLogement req = new RequeteSelectLogement();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st);
        ResultSet res = st.executeQuery();
        // Instanciation de l'itérateur
        DaoLogement.iterateurLogement = new Iterateur<Logement>(res, this);
        return DaoLogement.iterateurLogement;
    }

}
