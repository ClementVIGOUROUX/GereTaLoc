package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import modele.Agence; 


public class RequeteSelectAgenceById implements Requete<Agence> {

	@Override
	public String requete() {
		return "select * from SAE_AGENCE where Numero_Siret = ?";
	}
	
	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
	
	@Override
	public void parametresT(PreparedStatement prSt, Agence donnee) throws SQLException, ParseException {
		prSt.setString(1,donnee.getnSiret());
		prSt.setString(2, donnee.getNom());
		prSt.setString(3, donnee.getAdresse());
		prSt.setString(4, donnee.getCp());
		prSt.setString(5, donnee.getVille());
		prSt.setString(6, donnee.getTelephone());
		prSt.setString(7, donnee.getEmail());
		
	}
	
}







