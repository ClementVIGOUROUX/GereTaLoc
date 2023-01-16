package modele.dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import modele.Agence;
import modele.Bail;
import modele.Locataire;
import modele.Logement;
import modele.dao.requetes.RequeteSelectBail;
import modele.dao.requetes.RequeteSelectBailById;
import modele.dao.requetes.RequeteSelectBailLocataire;
import modele.dao.requetes.RequeteSelectBailLogementImmeuble;
import modele.dao.requetes.RequeteUpdateBailDateFin;
import modele.dao.requetes.RequeteUpdateProprietaire;
import modele.dao.requetes.SousProgrammeInsertBail;
import modele.dao.requetes.SousProgrammeInsertSigner;

public class DaoBail extends DaoModele<Bail> implements Dao<Bail> {

	private static Iterateur<Bail> iterateurBail ;
	
	@Override
	public void create(Bail donnees) throws SQLException {
		SousProgrammeInsertBail sP = new SousProgrammeInsertBail();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sP.appelSousProgramme());
		
		String siret = "";
		
		if (donnees.getAgence() != null) {
			siret = donnees.getAgence().getnSiret();
		}
		
		sP.parametres(st, donnees.getDateDebut(),
						  donnees.getDateFin(),
						  String.valueOf(donnees.getLogement().getImmeuble().getIdImmeuble()),
						  donnees.getLogement().getNumero(),
						  siret,
						  String.valueOf(donnees.getDepotGarantie()));
		
		st.execute();
		st.close();
		
	}

	@Override
	public void update(Bail donnees) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateDateFin(Bail donnees) {
		RequeteUpdateBailDateFin req = new RequeteUpdateBailDateFin() ;
		try {
			this.miseAJour(req, donnees);
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Bail donnees) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void insertSigner(Locataire loc, Bail bail) throws SQLException {
		SousProgrammeInsertSigner sP = new SousProgrammeInsertSigner();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sP.appelSousProgramme());

		
		sP.parametres(st, String.valueOf(loc.getIdLoc()),String.valueOf(bail.getIdBail()));
		st.execute();
		st.close();
	}
	

	@Override
	public List<Bail> findAll() throws SQLException {
		RequeteSelectBail rsB = new RequeteSelectBail();
		return this.find(rsB);
	}

	@Override
	protected Bail creerInstance(ResultSet curseur) throws SQLException {
		DaoLogement daoLogement = new DaoLogement();
		DaoAgence daoAgence = new DaoAgence();
		Logement l = daoLogement.findById(Integer.toString(curseur.getInt(4)),Integer.toString(curseur.getInt(5)));
		Agence a = daoAgence.findById(curseur.getString(6));
		Date dateDeb = curseur.getDate(2);
		Date dateFin = curseur.getDate(3);
		String dateFinString = null ;
		if(dateFin != null) {
			dateFinString = dateFin.toString() ;
		}else {
		}
		
		return new Bail(curseur.getInt(1),dateDeb.toString(),dateFinString, curseur.getInt(7),l,a);
	}

	@Override
	public Bail findById(String... id) throws SQLException {
		RequeteSelectBailById req = new RequeteSelectBailById();
		return this.findById(req, id);
	}
	
	
	public Bail findByLogement(String... id) throws SQLException {
		RequeteSelectBailLogementImmeuble req = new RequeteSelectBailLogementImmeuble();
		return this.findById(req, id);
	}
	
	public List<Bail> findListBailLogement(String... id) throws SQLException {
		RequeteSelectBailLogementImmeuble req = new RequeteSelectBailLogementImmeuble();
		return this.find(req,id);
	}
	
	public static Iterateur<Bail> getIterateurBail() {
		return iterateurBail ;
	}
	
	public Iterateur<Bail> findAllIterateur() throws SQLException{
        RequeteSelectBail req = new RequeteSelectBail();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoBail.iterateurBail = new Iterateur<Bail>(res, this);
        return DaoBail.iterateurBail;
    }
	
	public Iterateur<Bail> findByIdIterateur(String...id) throws SQLException{
        RequeteSelectBailById req = new RequeteSelectBailById();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoBail.iterateurBail = new Iterateur<Bail>(res, this);
        return DaoBail.iterateurBail;
    }

	public Iterateur<Bail> findByLogementImmeubleIterateur(String...id) throws SQLException{
		RequeteSelectBailLogementImmeuble req = new RequeteSelectBailLogementImmeuble();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0],id[1]);
        ResultSet res = st.executeQuery();
        // Instanciation de l'itérateur
        DaoBail.iterateurBail = new Iterateur<Bail>(res, this);
        return DaoBail.iterateurBail;
    }
	
	public Iterateur<Bail> findByLocataireIterateurUnique(String...id) throws SQLException{
		RequeteSelectBailLocataire req = new RequeteSelectBailLocataire();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();
        // Instanciation de l'itérateur
        DaoBail.iterateurBail = new Iterateur<Bail>(res, this);
        return DaoBail.iterateurBail;
    }



	
}
