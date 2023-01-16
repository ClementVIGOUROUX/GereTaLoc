package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

public interface SousProgramme<T> {

	public abstract String appelSousProgramme();
	public abstract void parametres(CallableStatement prSt, String... parametres) throws SQLException;
	
}
