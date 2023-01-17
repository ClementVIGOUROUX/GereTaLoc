package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Bail;
import modele.Paiement;
import modele.dao.requetes.RequeteSelectPaiement;
import modele.dao.requetes.RequeteSelectPaiementByBail;
import modele.dao.requetes.RequeteSelectPaiementById;
import modele.dao.requetes.RequeteSelectPaiementByLogement;
import modele.dao.requetes.RequeteSelectPaiementLogementImmeuble;
import modele.dao.requetes.SousProgrammeInsertPaiement;

public class DaoPaiement extends DaoModele<Paiement> implements Dao<Paiement>{
	
	private static Iterateur<Paiement> iterateurPaiement ;

	@Override
	public void create(Paiement donnees) throws SQLException {
		SousProgrammeInsertPaiement sP = new SousProgrammeInsertPaiement();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sP.appelSousProgramme());
		
		sP.parametres(st, donnees.getMoyen(),
						  String.valueOf(donnees.getMontant()),
						  donnees.getDateP(),
						  String.valueOf(donnees.getProvisionCharges()),
						  String.valueOf(donnees.getBail().getIdBail()));
		
		st.execute();
		st.close();
		
		
	}

	@Override
	public void update(Paiement donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Paiement donnees) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Paiement findById(String... id) throws SQLException {
		RequeteSelectPaiementById req = new RequeteSelectPaiementById();
		return this.findById(req, id);
	}
	
	public List<Paiement> findByLogement(String... id) throws SQLException {
		RequeteSelectPaiementByLogement req = new RequeteSelectPaiementByLogement();
		return this.find(req, id);
	}
	

	@Override
	public List<Paiement> findAll() throws SQLException{
		RequeteSelectPaiement rsB = new RequeteSelectPaiement();
		return this.find(rsB);
	}

	@Override
	protected Paiement creerInstance(ResultSet curseur) throws SQLException {
		DaoBail daoBail = new DaoBail();
		Bail b = daoBail.findById(Integer.toString(curseur.getInt(6)));
		String dateP = curseur.getString(4);
		return new Paiement(curseur.getInt(1),curseur.getString(2),curseur.getInt(3),dateP,curseur.getFloat(5),b);
	}
	
	public Iterateur<Paiement> findByIdIterateur(String...id) throws SQLException{
        RequeteSelectPaiementById req = new RequeteSelectPaiementById();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();
        
     // Instanciation de l'itérateur
        DaoPaiement.iterateurPaiement = new Iterateur<Paiement>(res, this);
        return DaoPaiement.iterateurPaiement;
	}
	
	
	public Iterateur<Paiement> findByBail(String...id) throws SQLException{
        RequeteSelectPaiementByBail req = new RequeteSelectPaiementByBail();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();
        
     // Instanciation de l'itérateur
        DaoPaiement.iterateurPaiement = new Iterateur<Paiement>(res, this);
        return DaoPaiement.iterateurPaiement;
	}
	
	public Iterateur<Paiement> findByLogementImmeubleIterateur(String...id) throws SQLException{
		RequeteSelectPaiementLogementImmeuble req = new RequeteSelectPaiementLogementImmeuble();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0],id[1]);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoPaiement.iterateurPaiement = new Iterateur<Paiement>(res, this);
        return DaoPaiement.iterateurPaiement;
    }
	
}
