package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Bail;

public class RequeteSelectBailById implements Requete<Bail>{

	@Override
	public String requete() {
		return "select * from SAE_BAIL where id_bail = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametresT(PreparedStatement prSt, Bail donnee) throws SQLException, ParseException {
		prSt.setInt(1, donnee.getIdBail());
	}

}
