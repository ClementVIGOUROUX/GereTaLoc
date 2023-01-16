package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Locataire;
import modele.dao.requetes.RequeteSelectLocataire;
import modele.dao.requetes.RequeteSelectLocataireAvecBail;
import modele.dao.requetes.RequeteSelectLocataireByBail;
import modele.dao.requetes.RequeteSelectLocataireById;
import modele.dao.requetes.RequeteSelectLocataireLogementImmeuble;
import modele.dao.requetes.RequeteSelectLocataireSansBail;
import modele.dao.requetes.SousProgrammeInsertLocataire;


public class DaoLocataire extends DaoModele<Locataire> implements Dao<Locataire>{
	
	private static Iterateur<Locataire> iterateurLocataire ;

	@Override
	public void create(Locataire donnees) throws SQLException {
		
		SousProgrammeInsertLocataire sP = new SousProgrammeInsertLocataire();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sP.appelSousProgramme());
		sP.parametres(st, donnees.getNom(), donnees.getTelephone(), donnees.getPrenom(), 
				      donnees.getEmail(), donnees.getSexe(), donnees.getProfession());
		st.execute();
		
		
	}

	@Override
	public void update(Locataire donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Locataire donnees) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public Locataire findById(String... id) throws SQLException {
		RequeteSelectLocataireById req = new RequeteSelectLocataireById();
		return this.findById(req, id);
	}

	@Override
	public List<Locataire> findAll() throws SQLException {
		RequeteSelectLocataire rsL = new RequeteSelectLocataire();
		return this.find(rsL);
	}
	
	public List<Locataire> findLocataireSansBail() throws SQLException {
		RequeteSelectLocataireSansBail rsSB = new RequeteSelectLocataireSansBail();
		return this.find(rsSB);
	}


	@Override
	protected Locataire creerInstance(ResultSet curseur) throws SQLException {
		return new Locataire(curseur.getInt(1),curseur.getString(2), curseur.getString(3),curseur.getString(4),curseur.getString(5),curseur.getString(6), curseur.getString(7));
	}

	public static Iterateur<Locataire> getIterateurLocataire() {
		return iterateurLocataire ;
	}
	
	public Iterateur<Locataire> findAllIterateur() throws SQLException{
        RequeteSelectLocataire req = new RequeteSelectLocataire();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoLocataire.iterateurLocataire = new Iterateur<Locataire>(res, this);
        return DaoLocataire.iterateurLocataire;
    }
	
	public Iterateur<Locataire> findByIdIterateur(String...id) throws SQLException{
        RequeteSelectLocataireById req = new RequeteSelectLocataireById();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoLocataire.iterateurLocataire = new Iterateur<Locataire>(res, this);
        return DaoLocataire.iterateurLocataire;
    }
	
	public Iterateur<Locataire> findByLogementImmeubleIterateur(String...id) throws SQLException{
		RequeteSelectLocataireLogementImmeuble req = new RequeteSelectLocataireLogementImmeuble();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0],id[1]);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoLocataire.iterateurLocataire = new Iterateur<Locataire>(res, this);
        return DaoLocataire.iterateurLocataire;
    }
	
	public Iterateur<Locataire> findByBailIterateur(String...id) throws SQLException{
		RequeteSelectLocataireByBail req = new RequeteSelectLocataireByBail();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoLocataire.iterateurLocataire = new Iterateur<Locataire>(res, this);
        return DaoLocataire.iterateurLocataire;
    }
	
	
	
	public Iterateur<Locataire> findAllAvecBail(String...id) throws SQLException{
		RequeteSelectLocataireAvecBail req = new RequeteSelectLocataireAvecBail();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoLocataire.iterateurLocataire = new Iterateur<Locataire>(res, this);
        return DaoLocataire.iterateurLocataire;
    }
	
	
	public Iterateur<Locataire> findSansBailIterateur() throws SQLException{
		RequeteSelectLocataireSansBail req = new RequeteSelectLocataireSansBail();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoLocataire.iterateurLocataire = new Iterateur<Locataire>(res, this);
        return DaoLocataire.iterateurLocataire;
    }
	

}
