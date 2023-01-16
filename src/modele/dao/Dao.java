package modele.dao;
import java.sql.SQLException;
import java.util.List;

//import modele.Creneau;
//import modele.dao.requetes.RequeteSelectCreneau;

public interface Dao<T>  {

	/* public T findById(String... id) throws SQLException; */
	public void create(T donnee) throws SQLException;
	public void update(T donnee) throws SQLException;
	public void delete(T donnee) throws SQLException;
	public List<T> findAll() throws SQLException;
	public T findById(String... id) throws SQLException;
	
}
