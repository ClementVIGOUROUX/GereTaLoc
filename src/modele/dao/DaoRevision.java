package modele.dao;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import modele.Bail;
import modele.Revision;
import modele.dao.requetes.RequeteSelectRevision;
import modele.dao.requetes.RequeteSelectRevisionByBail;
import modele.dao.requetes.RequeteSelectRevisionById;
import modele.dao.requetes.RequeteUpdateProprietaire;
import modele.dao.requetes.RequeteUpdateRevision;
import modele.dao.requetes.SousProgrammeInsertRevision;

public class DaoRevision extends DaoModele<Revision> implements Dao<Revision>{
	
	private static Iterateur<Revision> iterateurRevision ;

	@Override
	public void create(Revision donnees) throws SQLException {
		SousProgrammeInsertRevision sP = new SousProgrammeInsertRevision();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sP.appelSousProgramme());
		
		sP.parametres(st, String.valueOf(donnees.getIrl()),
						  String.valueOf(donnees.getBail().getIdBail()));
		
		st.execute();
		st.close();
		
		
	}

	@Override
	public void update(Revision donnees) {
		RequeteUpdateRevision req = new RequeteUpdateRevision() ;
		try {
			this.miseAJour(req, donnees);
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Revision donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Revision findById(String... id) throws SQLException {
		RequeteSelectRevisionById req = new RequeteSelectRevisionById();
		return this.findById(req, id);
	}
	
	public Revision findByBail(String... id) throws SQLException {
		RequeteSelectRevisionByBail req = new RequeteSelectRevisionByBail();
		return this.findById(req, id);
	}
	

	@Override
	public List<Revision> findAll() throws SQLException{
		RequeteSelectRevision rsB = new RequeteSelectRevision();
		return this.find(rsB);
	}

	@Override
	protected Revision creerInstance(ResultSet curseur) throws SQLException {
		DaoBail daoBail = new DaoBail();
		//REPRENDRE ICI
		Bail bail = daoBail.findById(Integer.toString(curseur.getInt(3)));
		
		return new Revision(curseur.getInt(1),curseur.getInt(2),bail);
	}
	
	public Iterateur<Revision> findByIdIterateur(String...id) throws SQLException{
        RequeteSelectRevisionById req = new RequeteSelectRevisionById();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();
        
     // Instanciation de l'it�rateur
        DaoRevision.iterateurRevision = new Iterateur<Revision>(res, this);
        return DaoRevision.iterateurRevision;
	}

}
