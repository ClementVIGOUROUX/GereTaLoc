package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import modele.Diagnostics;
import modele.Logement;
import modele.dao.requetes.RequeteSelectDiagnostic;
import modele.dao.requetes.RequeteSelectDiagnosticById;
import modele.dao.requetes.RequeteSelectDiagnosticByLogementImmeuble;
import modele.dao.requetes.RequeteUpdateDiagnosticRepertoireDate;
import modele.dao.requetes.SousProgrammeInsertDiagnostic;

public class DaoDiagnostics extends DaoModele<Diagnostics> implements Dao<Diagnostics> {
	
	private static Iterateur<Diagnostics> iterateurDiagnostic ;

	@Override
	public void create(Diagnostics donnees) throws SQLException {
		SousProgrammeInsertDiagnostic sP = new SousProgrammeInsertDiagnostic();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sP.appelSousProgramme());
		
		
		sP.parametres(st, donnees.getDateD(), donnees.getRepertoire(), Integer.toString(donnees.getLogement().getImmeuble().getIdImmeuble()), 
					  donnees.getLogement().getNumero());
		st.execute();
	}

	@Override
	public void update(Diagnostics donnees) {
		RequeteUpdateDiagnosticRepertoireDate req = new RequeteUpdateDiagnosticRepertoireDate() ;
		try {
			this.miseAJour(req, donnees);
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateRepertoireDate(Diagnostics donnees) {
		RequeteUpdateDiagnosticRepertoireDate req = new RequeteUpdateDiagnosticRepertoireDate() ;
		try {
			this.miseAJour(req, donnees);
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Diagnostics donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Diagnostics findById(String... id) throws SQLException {
		RequeteSelectDiagnosticById req = new RequeteSelectDiagnosticById();
		return this.findById(req, id);
	}

	@Override
	public List<Diagnostics> findAll() throws SQLException {
		RequeteSelectDiagnostic rsL = new RequeteSelectDiagnostic();
		return this.find(rsL);
	}
	
	public List<Diagnostics> findListLDiagnosticsByLogementImmeuble(String id) throws SQLException {
		RequeteSelectDiagnosticByLogementImmeuble req = new RequeteSelectDiagnosticByLogementImmeuble();
		return this.find(req,id);
	}

	@Override
	protected Diagnostics creerInstance(ResultSet curseur) throws SQLException {
		DaoLogement daoLogement = new DaoLogement();
		Logement logement = daoLogement.findById(curseur.getString(3), curseur.getString(4));
		
		return new Diagnostics(curseur.getInt(1), curseur.getString(2), curseur.getString(5) , logement) ;
		
	}
	
	public static Iterateur<Diagnostics> getIterateurLogement() {
		return iterateurDiagnostic ;
	}
	
	public Iterateur<Diagnostics> findAllIterateur() throws SQLException{
        RequeteSelectDiagnostic req = new RequeteSelectDiagnostic();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st);
        ResultSet res = st.executeQuery();
        // Instanciation de l'itérateur
        DaoDiagnostics.iterateurDiagnostic = new Iterateur<Diagnostics>(res, this);
        return DaoDiagnostics.iterateurDiagnostic;
    }
	
	public Iterateur<Diagnostics> findDiagnosticByLogementImmeubleIterateur(String... id) throws SQLException{
        RequeteSelectDiagnosticByLogementImmeuble req = new RequeteSelectDiagnosticByLogementImmeuble();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st, id[0], id[1]);
        ResultSet res = st.executeQuery();
        // Instanciation de l'itérateur
        DaoDiagnostics.iterateurDiagnostic = new Iterateur<Diagnostics>(res, this);
        return DaoDiagnostics.iterateurDiagnostic;
    }

	
	

}
