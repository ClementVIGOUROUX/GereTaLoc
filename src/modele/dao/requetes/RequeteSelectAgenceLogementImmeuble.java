package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import modele.Agence; 


public class RequeteSelectAgenceLogementImmeuble implements Requete<Agence> {

	@Override
	public String requete() {
		return "SELECT a.* FROM sae_bail b,sae_agence a WHERE b.numero_siret = a.numero_siret AND b.numero_l = ? AND b.id_immeuble = ?";
	}
	
	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		prSt.setString(2, id[1]);
	}
	
	@Override
	public void parametresT(PreparedStatement prSt, Agence donnee) throws SQLException, ParseException {
		//sert à rien
	}
	
}







