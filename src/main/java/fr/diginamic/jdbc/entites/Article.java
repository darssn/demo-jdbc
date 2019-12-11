package fr.diginamic.jdbc.entites;

public class Article {
	
	private int id ;
	private String ref;
	private String des;
	private double prix;
	private Fournisseur fournisseur;
	
	
	public Article(int id, String ref, String des, double prix, Fournisseur fournisseur) {
		
		this.id = id;
		this.ref = ref;
		this.des = des;
		this.prix = prix;
		this.fournisseur = fournisseur;
		
	}


	/**Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**Getter
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}


	/**Setter
	 * @param ref the ref to set
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}


	/**Getter
	 * @return the des
	 */
	public String getDes() {
		return des;
	}


	/**Setter
	 * @param des the des to set
	 */
	public void setDes(String des) {
		this.des = des;
	}


	/**Getter
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}


	/**Setter
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}


	/**Getter
	 * @return the fournisseur
	 */
	public Fournisseur getFournisseur() {
		return fournisseur;
	}


	/**Setter
	 * @param fournisseur the fournisseur to set
	 */
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Article [id=" + id + ", ref=" + ref + ", des=" + des + ", prix=" + prix + ", fournisseur=" + fournisseur
				+ "]";
	}
	
	
	
	
	

}
