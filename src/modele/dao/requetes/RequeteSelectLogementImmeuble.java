package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Logement;

public class RequeteSelectLogementImmeuble implements Requete<Logement> {
	

	@Override
	public String requete() {
		return "select * from SAE_LOGEMENT where ID_IMMEUBLE = ?";
	}
	
	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}
	
	

	@Override
	public void parametresT(PreparedStatement prSt, Logement donnee) throws SQLException, ParseException {
		prSt.setInt(1,donnee.getImmeuble().getIdImmeuble());
	}
	


}