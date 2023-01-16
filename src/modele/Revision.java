package modele;

import java.util.Objects;

public class Revision {
	
	private int idRevision;
	private float irl;
	private Bail bail;
	
	
	public Revision(int idRevision, float irl, Bail bail) {
		super();
		this.idRevision = idRevision;
		this.irl = irl ;
		this.bail = bail ;
	}


	public int getIdRevision() {
		return idRevision;
	}


	public void setIdRevision(int idRevision) {
		this.idRevision = idRevision;
	}


	public float getIrl() {
		return this.irl ;
	}
	
	public void setIrl(float irl) {
		this.irl = irl ;
	}

	public Bail getBail() {
		return this.bail;
	}


	public void setBail(Bail bail) {
		this.bail = bail;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idRevision);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Revision)) {
			return false;
		}
		Revision other = (Revision) obj;
		return idRevision == other.idRevision;
	}


	@Override
	public String toString() {
		return "Revision [idRevision=" + idRevision + ", IRL =" + irl + "]";
	}
	
	
	
	

	

	
}
