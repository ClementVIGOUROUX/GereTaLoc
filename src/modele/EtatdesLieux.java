package modele;

import java.util.Objects;

public class EtatdesLieux {
	
	private int idEDL;
	private String dateEDL;
	private String repertoire ;
	private Bail bail ;
	
	
	public EtatdesLieux(int idEDL, String dateEDL, String repertoire, Bail bail) {
		super();
		this.idEDL = idEDL;
		this.dateEDL = dateEDL;
		this.repertoire = repertoire ;
		this.bail = bail;
	}


	public int getIdEDL() {
		return idEDL;
	}


	public void setIdEDL(int idEDL) {
		this.idEDL = idEDL;
	}


	public String getDateEDL() {
		return dateEDL;
	}


	public void setDateEDL(String dateEDL) {
		this.dateEDL = dateEDL;
	}
	
	public String getRepertoire() {
		return repertoire;
	}


	public void setRepertoire(String repertoire) {
		this.repertoire = repertoire;
	}


	public Bail getBail() {
		return bail;
	}


	public void setBail(Bail bail) {
		this.bail = bail;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idEDL);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EtatdesLieux)) {
			return false;
		}
		EtatdesLieux other = (EtatdesLieux) obj;
		return idEDL == other.idEDL;
	}


	@Override
	public String toString() {
		return "EtatdesLieux [idEDL=" + idEDL + ", dateEDL=" + dateEDL + ", bail=" + bail + "]";
	}
	
	
	
	

	
	

}
