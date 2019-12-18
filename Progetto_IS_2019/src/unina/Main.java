package unina;

import java.time.LocalDate;
import java.time.Month;

import unina.control.*;
import unina.entity.*;
import unina.exceptions.*;

public class Main {
	
	public static void main(String[] args) {
		
		GestioneSegreteria Segreteria = new GestioneSegreteria();
		
		//creazione di un corso
		
		Corso Analisi1 = new Corso("Analisi 1", "Pietro Baldi", 6);
		
		try {
			Segreteria.inserisciCorso(Analisi1);
		} catch (CorsoGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//creazione di un appello 
		
		Appello PrimoAppello = new Appello(Analisi1);
		
		try {
			Segreteria.inserisciAppello(PrimoAppello);
		} catch (AppelloGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LocalDate primaData = LocalDate.of(2019, Month.JANUARY, 06); 
		
		String Aula1 = "Aula 1";
		
		tipoProva Prova1 = tipoProva.SCRITTA;
		
		//creazione di una data d'appello
		
		DataAppello primoAppelloAnalisi1 = new DataAppello(primaData, Analisi1, Aula1, Prova1);
		
		try {
			Segreteria.insericiDataAppello(primoAppelloAnalisi1);
		} catch (DataAppelloGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//prenotazione di uno studente ad un appello
		
		Studente s1 = new Studente("Angelo", "Casciello", 1111);
		
		try {
			Segreteria.prenotaEsame(s1, primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException | Gi‡PrenotatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Studente s2 = new Studente("Emanuele", "Apolloni", 2222);
		
		try {
			Segreteria.prenotaEsame(s2, primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException | Gi‡PrenotatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//consultazione degli studenti prenotati ad un certo appello
		
		try {
			Segreteria.visualizzaStudentiPrenotati(primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//doppia prenotazione da parte di uno studente (solleva l'eccezione "Gi‡PrenotatoException")
		
		try {
			Segreteria.prenotaEsame(s2, primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException | Gi‡PrenotatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
   }
}
