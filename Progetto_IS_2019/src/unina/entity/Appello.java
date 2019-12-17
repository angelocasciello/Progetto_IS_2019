package unina.entity;

import java.util.ArrayList;

public class Appello {
	
	protected ArrayList<DataAppello> dateAppello = new ArrayList<DataAppello>();
	protected Corso esame;

	public Appello(Corso esame) {
		this.esame = esame;
	}
	
	public Appello(ArrayList<DataAppello> dateAppello, Corso esame) {
		this.dateAppello = dateAppello;
		this.esame = esame;
	}

	//metodi "get"
	
	public Corso getEsame() {
		return esame;
	}
	
	public ArrayList<DataAppello> getDateAppello(){
		return dateAppello;
	}
	
	//metodi "set"
	
	public void setEsame(Corso esame) {
		this.esame = esame;
	}
	
	public void addDataAppello(DataAppello data) {
		dateAppello.add(data);
	}
}
