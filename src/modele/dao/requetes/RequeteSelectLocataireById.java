package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Locataire;
public class RequeteSelectLocataireById implements Requete<Locataire> {
	

	@Override
	public String requete() {
		return "select * from SAE_LOGEMENT where ID_IMMEUBLE = ? and NUMERO_L = ?";
	}
	
	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
	
	

	@Override
	public void parametresT(PreparedStatement prSt, Locataire donnee) throws SQLException, ParseException {
		prSt.setInt(1,donnee.getIdLoc());
	}
	


}