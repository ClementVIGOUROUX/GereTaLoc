package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Caution;

public class RequeteSelectCautionById implements Requete<Caution> {

	@Override
	public String requete() {
		return "select * from SAE_Caution where id_caution = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(0, id[0]);
	}

	@Override
	public void parametresT(PreparedStatement prSt, Caution donnee) throws SQLException, ParseException {
		prSt.setInt(0, donnee.getIdCaution());
	}
}
