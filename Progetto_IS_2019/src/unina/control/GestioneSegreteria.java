package unina.control;

import java.util.ArrayList;
import unina.entity.*;
import unina.exceptions.*;

public class GestioneSegreteria {
	
	private ArrayList<Corso> Corsi = new ArrayList<Corso>();
	private ArrayList<Appello> Appelli = new ArrayList<Appello>();

	public GestioneSegreteria() {
	}
	
	//funzione per la creazione di un corso
	
	public void inserisciCorso(Corso corso) throws CorsoGi‡PresenteException  {
		
		if(Corsi.contains(corso)) {
			
			throw new CorsoGi‡PresenteException("Il corso Ë gi‡ presente.");
			
		} else {
			
		Corsi.add(corso);
		
		System.out.println("Nuovo corso aggiunto. \n"+corso.toString());
	   }
	}
	
	//funzione per la rimozione di un corso
	
	public void eliminaCorso(Corso corso) throws CorsoNonTrovatoException {
		
		if(Corsi.contains(corso)) {
			
		Corsi.remove(corso);
		
		System.out.println("Corso rimosso con successo.");
		
		}
		else {
			
			throw new CorsoNonTrovatoException("Il corso scelto non Ë presente.");
			
		}
	}
	
	//funzione per la creazione di un appello d'esame
	
	public void inserisciAppello(Appello appello) throws AppelloGi‡PresenteException {
		
		for (Corso corso : Corsi) {  //itera sull' ArrayList "Corsi"
			
			if(corso == appello.getEsame()) {  //verifica se l'appello d'esame si riferisce ad un corso esistente
				
				if(Appelli.contains(appello)) {
					
					throw new AppelloGi‡PresenteException("L'appello Ë gi‡ presente");
					
				} else {
				
				Appelli.add(appello);		//aggiunge l'appello	
				
				System.out.println("Appello aggiunto con successo.");
				
				}
			}
		}
	}
	
	//funzione per la creazione di una data d'appello d'esame
	
	public void insericiDataAppello(DataAppello data) throws DataAppelloGi‡PresenteException{
		
		for (Appello appello : Appelli) { //itera sull' ArrayList "Appelli"
			
			if(appello.getEsame() == data.getEsame()) { //verifica se la data d'esame si riferisce ad un appello d'esame
				
				if(appello.getDateAppello().contains(data)) {
					
					throw new DataAppelloGi‡PresenteException("La data d'appello Ë gi‡ presente");
					
				} else {
					
				appello.addDataAppello(data); //aggiunge la data d'appello
				
				System.out.println("Data d'appello aggiunta con successo.");
				
				}
			}
		}
	}
	
	/*funzione per la prenotazione di un esame,
	 che lo studente, attraverso un'interfaccia (la boundary del diagramma, esempio: SEGREPASS),
	 chiama ogni qualvolta intende effettuare una prenotazione */

	public void prenotaEsame(Studente s, DataAppello data) throws AppelloNonTrovatoException, DataAppelloNonTrovataException, Gi‡PrenotatoException { //lo studente specifica l'esame e la data desiderata per il sostenimento (i dati dello studente vengono passati in automatico effettuando l'accesso all'interfaccia)
		
		boolean appelloTrovato = false;
		boolean dataTrovata = false;
		
		for (Appello appello: Appelli) { //itera sull' ArrayList "Appelli"
				
			if(appello.getEsame() == data.getEsame()) { //verifica se l'esame Ë presente fra gli appelli 
				
				appelloTrovato = true;
				
				for(DataAppello dataAppello: appello.getDateAppello()) { //itera sull' ArrayList "DateAppello" relative all'appello
					
					if(dataAppello.getData() == data.getData()) { //verifica se la data specificata Ë una data d'appello
						
						dataTrovata = true;
						
						if(dataAppello.getStudentiPrenotati().contains(s)) {
							
							throw new  Gi‡PrenotatoException("La prenotazione Ë gi‡ stata effettuata.");
							
						} else {
						
						dataAppello.getStudentiPrenotati().add(s); //in caso positivo, aggiunge lo studente alla lista degli studenti prenotati
						
						System.out.println("Prenotazione effettuata con successo.");
						
						}
					}
					
				} if(dataTrovata == false) {
					
					throw new DataAppelloNonTrovataException("Non esistono date d'appello nella data scelta");
					
				}
			} 
			
		} if(appelloTrovato == false) {
			
			throw new AppelloNonTrovatoException("Non esistono appelli per l'esame scelto.");
			
		}
	}

	//funzione per la consultazione degli studenti prenotati ad una data d'appello (che si intende come appello)
	
	public void visualizzaStudentiPrenotati(DataAppello data) throws AppelloNonTrovatoException, DataAppelloNonTrovataException {
	
	boolean appelloTrovato = false;
	boolean dataTrovata = false;
		
	ArrayList<Studente> Prenotati = new ArrayList<Studente>();
		
     for (Appello appello: Appelli) { //itera sull' ArrayList "Appelli"
			
			if(appello.getEsame() == data.getEsame()) { //verifica se l'esame Ë presente fra gli appelli 
				
				appelloTrovato = true;
				
				for(DataAppello dataAppello: appello.getDateAppello()) { //itera sull' ArrayList "DateAppello" relative all'appello
					
					if(dataAppello.getData() == data.getData()) { //verifica se la data specificata Ë una data d'appello
						
						dataTrovata = true;
						
						Prenotati = dataAppello.getStudentiPrenotati();
						
						if(Prenotati.size() == 0) {
							
							System.out.println("Nessuno studente attualmente prenotato.");
							
						} else {
						
						System.out.println(dataAppello.getEsame().getNomeCorso()+"\nSTUDENTI PRENOTATI:");
						
						for (Studente StudentePrenotato: Prenotati) { //itera sull' ArrayList "Prenotati"
							
							System.out.println(StudentePrenotato.toString()); //stampa lo studente prenotato
						 }
					   }
					 }		
				 } if(dataTrovata == false) {
						
						throw new DataAppelloNonTrovataException("Non esistono date d'appello nella data scelta");
				 }
			 }
         } if(appelloTrovato == false) {
 			
 			throw new AppelloNonTrovatoException("Non esistono appelli per l'esame scelto.");
 			
 		}
	 }

}
