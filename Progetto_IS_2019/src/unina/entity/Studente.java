package unina.entity;


public class Studente {


	protected String nome;
	protected String cognome;
	protected int matricola;
	
	public Studente() {
		this.nome = "";
		this.cognome = "";
		this.matricola = 0;
	}

	public Studente(String nome, String cognome, int matricola) {
		this.nome = new String(nome);
		this.cognome = new String(cognome);
		this.matricola = matricola;

	}
	
	//per visualizzare lo studente
	
	public String toString() {
		return "NOME = "+this.nome+ "\nCOGNOME = "+this.cognome+"\nMATRICOLA = "+this.matricola;
	}
	
	//metodi "get"
	
	public String getNome(){
		
		return this.nome;
	}

	public String getCognome() {
		return cognome;
	}
	
	public int getMatricola() {
		return matricola;
	}
	
	//metodi "set"
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}	
	
}
