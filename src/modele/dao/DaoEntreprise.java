package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modele.Entreprise;
import modele.dao.requetes.RequeteSelectEntreprise;
import modele.dao.requetes.RequeteSelectEntrepriseById;
import modele.dao.requetes.RequeteSelectEntrepriseByNom;
import modele.dao.requetes.SousProgrammeInsertEntreprise;

public class DaoEntreprise extends DaoModele<Entreprise> implements Dao<Entreprise> {

	private static Iterateur<Entreprise> iterateurEntreprise ;
	
	@Override
	public void create(Entreprise donnees) throws SQLException {
		SousProgrammeInsertEntreprise sP = new SousProgrammeInsertEntreprise();
		CallableStatement st = CictOracleDataSource.getConnectionBD().prepareCall(sP.appelSousProgramme());
		
		sP.parametres(st, donnees.getnSiret(),
						  donnees.getNomEnteprise(),
						  donnees.getAdresse(),
						  donnees.getCp(),
						  donnees.getVille(),
						  donnees.getEmail(),donnees.getTelephone());
		st.execute();
		st.close();
	}

	@Override
	public void update(Entreprise donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Entreprise donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entreprise findById(String... id) throws SQLException {
		RequeteSelectEntrepriseById req = new RequeteSelectEntrepriseById();
		return this.findById(req, id);
	}

	@Override
	public List<Entreprise> findAll() throws SQLException {
		RequeteSelectEntreprise rsE = new RequeteSelectEntreprise();
		return this.find(rsE);
	}
	
	public Entreprise findByNom(String... id) throws SQLException {
		RequeteSelectEntrepriseByNom req = new RequeteSelectEntrepriseByNom();
		return this.findById(req, id);
	}

	@Override
	protected Entreprise creerInstance(ResultSet curseur) throws SQLException {
		
		return new Entreprise(curseur.getString(1),curseur.getString(2), curseur.getString(3),
							  curseur.getString(4),curseur.getString(5),curseur.getString(6), 
							  curseur.getString(7));
	}
	
	public static Iterateur<Entreprise> getIterateurEntreprise() {
		return iterateurEntreprise ;
	}
	
	public Iterateur<Entreprise> findAllIterateur() throws SQLException{
        RequeteSelectEntreprise req = new RequeteSelectEntreprise();
        PreparedStatement st = CictOracleDataSource.getConnectionBD().prepareStatement(req.requete());
        req.parametresID(st);
        ResultSet res = st.executeQuery();

        // Instanciation de l'itérateur
        DaoEntreprise.iterateurEntreprise = new Iterateur<Entreprise>(res, this);
        return DaoEntreprise.iterateurEntreprise;
    }

}
