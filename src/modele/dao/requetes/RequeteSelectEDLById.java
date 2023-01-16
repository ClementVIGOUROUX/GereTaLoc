package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.EtatdesLieux;

public class RequeteSelectEDLById implements Requete<EtatdesLieux>{

	@Override
	public String requete() {
		return "select * from sae_etatdeslieux where id_edl = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametresT(PreparedStatement prSt, EtatdesLieux donnee) throws SQLException, ParseException {
		prSt.setInt(1, donnee.getIdEDL());
	}

}
