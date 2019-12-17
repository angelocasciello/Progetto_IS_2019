package unina.entity;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class DataAppello {
	
	protected LocalDate data;
	protected Corso esame;
	protected String aula;
	protected ArrayList<Studente> StudentiPrenotati = new ArrayList<Studente>();
	protected boolean concluso;
	protected tipoProva prova;
	
	public DataAppello() {
		this.data = LocalDate.of(1, Month.JANUARY, 2000); //data random default
		this.esame = null;
		this.aula = "";
		this.concluso = false;
	}
	
	public DataAppello(LocalDate data, Corso esame, String aula, tipoProva prova) {
		this.data = data;
		this.esame = esame;
		this.aula = aula;
		this.concluso = false;
		this.prova = prova;
	}
	
	//metodi "get"
	
	public LocalDate getData() {
		return data;
	}

	public Corso getEsame() {
		return esame;
	}
	
	public String getAula() {
		return aula;
	}
	
	public tipoProva getProva() {
		return prova;
	}
	
	public boolean getConcluso() {
		return concluso;
	}
	
	public ArrayList<Studente> getStudentiPrenotati(){
		return StudentiPrenotati;
	}
	
	//metodi "set"
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public void setEsame(Corso esame) {
		this.esame = esame;
	}
	
	public void setAula(String aula) {
		this.aula = aula;
	}
	
	public void setProva(tipoProva prova) {
		this.prova = prova;
	}
	
	public void setConcluso(boolean concluso) {
		this.concluso = concluso;
	}
	
}
