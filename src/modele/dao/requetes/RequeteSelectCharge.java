package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Charge;

public class RequeteSelectCharge implements Requete<Charge>{

	@Override
	public String requete() {
		return "select * from SAE_Charge";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
	}

	@Override
	public void parametresT(PreparedStatement prSt, Charge donnee) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		
	}

}
