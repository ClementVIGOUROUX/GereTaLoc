package modele;


public class Diagnostics {
	
	private int idDiagnostic ;
	private String dateD ;
	private String repertoire ;
	private Logement logement ;

	
	
	public Diagnostics(int idDiagnostic, String dateD, String repertoire, Logement logement) {
		super();
		this.idDiagnostic = idDiagnostic ;
		this.dateD = dateD ;
		this.repertoire = repertoire ;
		this.logement = logement;
	}



	public int getIdDiagnostic() {
		return idDiagnostic;
	}



	public void setIdDiagnostic(int idDiagnostic) {
		this.idDiagnostic = idDiagnostic;
	}



	public String getDateD() {
		return dateD;
	}



	public void setDateD(String dateD) {
		this.dateD = dateD;
	}



	public String getRepertoire() {
		return repertoire;
	}



	public void setRepertoire(String repertoire) {
		this.repertoire = repertoire;
	}



	public Logement getLogement() {
		return logement;
	}



	public void setLogement(Logement logement) {
		this.logement = logement;
	}



	@Override
	public String toString() {
		return "Diagnostics [idDiagnostic=" + idDiagnostic + ", dateD=" + dateD + ", repertoire=" + repertoire
				+ ", logement=" + logement + "]";
	}




	
	
	
	
	
	
	

}
