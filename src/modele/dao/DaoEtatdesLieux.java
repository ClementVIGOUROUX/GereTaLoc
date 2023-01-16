package modele.dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Bail;
import modele.EtatdesLieux;
import modele.dao.requetes.RequeteSelectEDL;
import modele.dao.requetes.RequeteSelectEDLById;
import modele.dao.requetes.RequeteSelectEDLLogementImmeuble;
import modele.dao.requetes.SousProgrammeInsertEDL;

public class DaoEtatdesLieux extends DaoModele<EtatdesLieux>  implements Dao<EtatdesLieux>{

	private static Iterateur<EtatdesLieux> iterateurEtatdesLieux;
	
	@Override
	public void create(EtatdesLieux donnees) throws SQLException {
		SousProgrammeInsertEDL sP = new SousProgrammeInsertEDL();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sP.appelSousProgramme());
		
		sP.parametres(st, donnees.getDateEDL(),
						  String.valueOf(donnees.getBail().getIdBail()));
		
		st.execute();
		st.close();
		
	}

	@Override
	public void update(EtatdesLieux donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EtatdesLieux donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EtatdesLieux findById(String... id) throws SQLException {
		RequeteSelectEDLById req = new RequeteSelectEDLById();
		return this.findById(req, id);
	}

	@Override
	public List<EtatdesLieux> findAll() throws SQLException {
		RequeteSelectEDL req = new RequeteSelectEDL();
		return this.find(req);
	}

	@Override
	protected EtatdesLieux creerInstance(ResultSet curseur) throws SQLException {
		DaoBail daoBail = new DaoBail();
		Bail b = daoBail.findById(curseur.getString(3));
		Date dateEDL = curseur.getDate(2);
		
		return new EtatdesLieux(curseur.getInt(1), dateEDL.toString(), b);
	}
	
	public static Iterateur<EtatdesLieux> getIterateurEDL() {
		return iterateurEtatdesLieux ;
	}
	
	public Iterateur<EtatdesLieux> findByIdIterateur(String...id) throws SQLException{
        RequeteSelectEDLById req = new RequeteSelectEDLById();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0]);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoEtatdesLieux.iterateurEtatdesLieux = new Iterateur<EtatdesLieux>(res, this);
        return DaoEtatdesLieux.iterateurEtatdesLieux;
    }
	
	public Iterateur<EtatdesLieux> findByLogementImmeubleIterateur(String...id) throws SQLException{
		RequeteSelectEDLLogementImmeuble req = new RequeteSelectEDLLogementImmeuble();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st,id[0],id[1]);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoEtatdesLieux.iterateurEtatdesLieux = new Iterateur<EtatdesLieux>(res, this);
        return DaoEtatdesLieux.iterateurEtatdesLieux;
    }

}
