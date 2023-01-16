package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Bail;

public class RequeteSelectBailLogementImmeuble implements Requete<Bail>{

	@Override
	public String requete() {
		return "SELECT * FROM SAE_bail b where b.numero_l = ? and b.id_immeuble = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		prSt.setString(2, id[1]);
	}

	@Override
	public void parametresT(PreparedStatement prSt, Bail donnee) throws SQLException, ParseException {
		int nl = Integer.parseInt(donnee.getLogement().getNumero());
		prSt.setInt(1,nl);
		prSt.setInt(1,donnee.getLogement().getImmeuble().getIdImmeuble());
	}

}
