package modele.dao.requetes;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.ParseException;

import modele.Charge;

public class RequeteSelectChargeBail implements Requete<Charge>{
	
	

	@Override
	public String requete() {
		return "SELECT * from SAE_CHARGE where ID_BAIL = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}



	@Override
	public void parametresT(PreparedStatement prSt, Charge donnee) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		
	}

}
