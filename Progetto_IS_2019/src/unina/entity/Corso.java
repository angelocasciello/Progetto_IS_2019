package unina.entity;

public class Corso {

		protected String nomeCorso;
		protected String nomeDocente; /*per semplicità "nomeDocente" è solo un attributo di tipo String di "Corso"
		 								(l'entity "Docente" avrebbe avuto solo Nome e Cognome,
		 								 si è scelto pertanto di ovviare la sua creazione)*/
		protected int CFU;
		
		public Corso(String nomeCorso) {
			this.nomeCorso = nomeCorso;
			this.nomeDocente = "";
			this.CFU = 0;
		}
		
		public Corso(String nomeCorso, String nomeDocente, int CFU) {
			this.nomeCorso = nomeCorso;
			this.nomeDocente = nomeDocente;
			this.CFU = CFU;
		}
		
		//per visualizzare il corso 
		
		public String toString() {
			return "CORSO = "+this.nomeCorso+ "\nDOCENTE = "+this.nomeDocente+"\nCFU = "+this.CFU;
		}

		//metodi "get"
		
	  public String getNomeCorso() {
		  return nomeCorso;
	}
	  
	  public String getNomeDocente() {
		  return nomeDocente;
	}

	  public int getCFU() {
		  return CFU;
	  }
	  
	  //metodi "set"
	  
	  public void setNomeCorso(String nomeCorso) {
		  this.nomeCorso = nomeCorso;
	  }
	  
	  public void setNomeDocente(String nomeDocente) {
		  this.nomeDocente = nomeDocente;
	  }
	  
	  public void setCFU(int CFU) {
		  this.CFU = CFU;
	  }
}
