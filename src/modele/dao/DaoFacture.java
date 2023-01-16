package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Entreprise;
import modele.Facture;
import modele.Logement;
import modele.dao.requetes.RequeteSelectFacture;
import modele.dao.requetes.RequeteSelectFactureById;
import modele.dao.requetes.RequeteSelectFactureImmeuble;
import modele.dao.requetes.RequeteSelectFactureLogementImmeuble;
import modele.dao.requetes.SousProgrammeInsertFacture;


public class DaoFacture extends DaoModele<Facture> implements Dao<Facture> {

	private static Iterateur<Facture> iterateurFacture ;
	
	@Override
	public void create(Facture donnees) throws SQLException {
		SousProgrammeInsertFacture sP = new SousProgrammeInsertFacture();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sP.appelSousProgramme());
		
		String stringImmeuble ;
		if (donnees.isImmeuble() == true) {
			stringImmeuble = "1";
		} else {
			stringImmeuble = "0";
		}
		
		sP.parametres(st, donnees.getnFacture(), 
						  donnees.getTypeF(), 
						  donnees.getDateF(),
						  String.valueOf(donnees.getMontant()), 
						  String.valueOf(donnees.getMontantNonDeductible()), 
						  stringImmeuble, 
						  donnees.getEntreprise().getnSiret(), 
						  String.valueOf(donnees.getLogement().getImmeuble().getIdImmeuble()),
						  donnees.getLogement().getNumero());
		st.execute();
		st.close();
	}

	@Override
	public void update(Facture donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Facture donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Facture findById(String... id) throws SQLException {
		RequeteSelectFactureById req = new RequeteSelectFactureById();
		return this.findById(req, id);
	}

	@Override
	public List<Facture> findAll() throws SQLException {
		RequeteSelectFacture rsF = new RequeteSelectFacture();
		return this.find(rsF);
	}

	@Override
	protected Facture creerInstance(ResultSet curseur) throws SQLException {
		DaoLogement daoLogement = new DaoLogement();
		DaoEntreprise daoEntreprise = new DaoEntreprise();
		Logement l = daoLogement.findById(Integer.toString(curseur.getInt("ID_IMMEUBLE")),Integer.toString(curseur.getInt("NUMERO")));
		Entreprise e = daoEntreprise.findById(curseur.getString("N_SIRET"));
		
		return new Facture(curseur.getString("N_FACTURE"), curseur.getString("TYPE"), curseur.getDate("DATE_F").toString(),
				  		   curseur.getFloat("MONTANT"), curseur.getFloat("MONTANT_NOND"), l, e, curseur.getBoolean("IMMEUBLE"));
	}
	
	public static Iterateur<Facture> getIterateurBail() {
		return iterateurFacture ;
	}
	
	public Iterateur<Facture> findAllIterateur() throws SQLException{
		RequeteSelectFacture req = new RequeteSelectFacture();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoFacture.iterateurFacture = new Iterateur<Facture>(res, this);
        return DaoFacture.iterateurFacture;
    }
	
	public Iterateur<Facture> findByIdIterateur(String...id) throws SQLException{
		RequeteSelectFactureById req = new RequeteSelectFactureById();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoFacture.iterateurFacture = new Iterateur<Facture>(res, this);
        return DaoFacture.iterateurFacture;
    }
	
	public Iterateur<Facture> findByLogementImmeubleIterateur(String...id) throws SQLException{
		RequeteSelectFactureLogementImmeuble req = new RequeteSelectFactureLogementImmeuble();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();
        // Instanciation de l'itérateur
        DaoFacture.iterateurFacture = new Iterateur<Facture>(res, this);
        return DaoFacture.iterateurFacture;
    }
	
	public Iterateur<Facture> findByImmeubleIterateur(String...id) throws SQLException{
		RequeteSelectFactureImmeuble req = new RequeteSelectFactureImmeuble();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();
        // Instanciation de l'itérateur
        DaoFacture.iterateurFacture = new Iterateur<Facture>(res, this);
        return DaoFacture.iterateurFacture;
    }

}
