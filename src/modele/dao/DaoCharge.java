package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Bail;
import modele.Charge;

import modele.dao.requetes.RequeteSelectCharge;
import modele.dao.requetes.RequeteSelectChargeBail;
import modele.dao.requetes.RequeteSelectChargeById;
import modele.dao.requetes.RequeteSelectChargeLocataire;
import modele.dao.requetes.SousProgrammeInsertCharge;


public class DaoCharge extends DaoModele<Charge> implements Dao<Charge> {
	
	private static Iterateur<Charge> iterateurCharge ;

	@Override
	public void create(Charge donnees) throws SQLException {
		SousProgrammeInsertCharge sP = new SousProgrammeInsertCharge();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sP.appelSousProgramme());
		
		sP.parametres(st, donnees.getNom(), Integer.toString(donnees.getIndex_c()),Integer.toString(donnees.getMontant()),Integer.toString(donnees.getBail().getIdBail()));
		st.execute();
		
	}

	@Override
	public void update(Charge donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Charge donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Charge findById(String... id) throws SQLException {
		RequeteSelectChargeById req = new RequeteSelectChargeById();
		return this.findById(req, id);
	}

	@Override
	public List<Charge> findAll() throws SQLException{
		RequeteSelectCharge rsB = new RequeteSelectCharge();
		return this.find(rsB);
	}

	@Override
	protected Charge creerInstance(ResultSet curseur) throws SQLException {
		DaoBail daoBail = new DaoBail();
		Bail b = daoBail.findById(Integer.toString(curseur.getInt(5)));
		return new Charge(curseur.getInt(1),curseur.getString(2),curseur.getInt(3),curseur.getInt(4),b);
	}

	public Iterateur<Charge> findByIdIterateur(String...id) throws SQLException{
        RequeteSelectChargeById req = new RequeteSelectChargeById();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();
        
     // Instanciation de l'it�rateur
        DaoCharge.iterateurCharge = new Iterateur<Charge>(res, this);
        return DaoCharge.iterateurCharge;
	}
	
	
	public Iterateur<Charge> findByLocataireIterateur(String...id) throws SQLException{
        RequeteSelectChargeLocataire req = new RequeteSelectChargeLocataire();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();
        
     // Instanciation de l'it�rateur
        DaoCharge.iterateurCharge = new Iterateur<Charge>(res, this);
        return DaoCharge.iterateurCharge;
	}
	
	public Iterateur<Charge> findByBailIterateur(String...id) throws SQLException{
        RequeteSelectChargeBail req = new RequeteSelectChargeBail();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();
        
     // Instanciation de l'it�rateur
        DaoCharge.iterateurCharge = new Iterateur<Charge>(res, this);
        return DaoCharge.iterateurCharge;
	}
	
	
	
	
	
	
}
