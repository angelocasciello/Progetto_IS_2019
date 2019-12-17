package unina.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import unina.control.*;
import unina.entity.*;
import unina.exceptions.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GestioneSegreteriaTest {
	
	GestioneSegreteria Segreteria;

	@Before
	public void setUp() throws Exception {
		
		 Segreteria = new GestioneSegreteria();
		
	}

	@Test
	public void test01PrenotatiUnaDataAppelloUnoStudente() {
		
		Studente s1 = new Studente("Angelo","Casciello", 1111);
		
		Corso Analisi1 = new Corso("Analisi 1", "Pietro Baldi", 6);
		
		try {
			Segreteria.inserisciCorso(Analisi1);
		} catch (CorsoGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		DataAppello primoAppelloAnalisi1 = new DataAppello(primaData, Analisi1, Aula1, Prova1);
		
		try {
			Segreteria.insericiDataAppello(primoAppelloAnalisi1);
		} catch (DataAppelloGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.prenotaEsame(s1, primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException | Gi‡PrenotatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.visualizzaStudentiPrenotati(primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(1, primoAppelloAnalisi1.getStudentiPrenotati().size());
	}
	
	@Test
	public void test02PrenotatiUnaDataAppelloNessunoStudente() {
		
Corso Analisi1 = new Corso("Analisi 1", "Pietro Baldi", 6);
		
		try {
			Segreteria.inserisciCorso(Analisi1);
		} catch (CorsoGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		DataAppello primoAppelloAnalisi1 = new DataAppello(primaData, Analisi1, Aula1, Prova1);
		
		try {
			Segreteria.insericiDataAppello(primoAppelloAnalisi1);
		} catch (DataAppelloGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			Segreteria.visualizzaStudentiPrenotati(primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(0, primoAppelloAnalisi1.getStudentiPrenotati().size());
		
	}
	
	@Test
	public void test03PrenotatiUnaDataAppelloPi˘Studenti() {
		
        Studente s1 = new Studente("Angelo","Casciello", 1111);
        
        Studente s2 = new Studente("Emanuele", "Apolloni", 2222);
		
		Corso Analisi1 = new Corso("Analisi 1", "Pietro Baldi", 6);
		
		try {
			Segreteria.inserisciCorso(Analisi1);
		} catch (CorsoGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		DataAppello primoAppelloAnalisi1 = new DataAppello(primaData, Analisi1, Aula1, Prova1);
		
		try {
			Segreteria.insericiDataAppello(primoAppelloAnalisi1);
		} catch (DataAppelloGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.prenotaEsame(s1, primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException | Gi‡PrenotatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.prenotaEsame(s2, primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException | Gi‡PrenotatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.visualizzaStudentiPrenotati(primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(2, primoAppelloAnalisi1.getStudentiPrenotati().size());
		
	}
	
	@Test
	public void test04PrenotatiDataAppelloNonPresente() {
		
		Corso Analisi1 = new Corso("Analisi 1", "Pietro Baldi", 6);
	
		try {
			Segreteria.inserisciCorso(Analisi1);
		} catch (CorsoGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		DataAppello primoAppelloAnalisi1 = new DataAppello(primaData, Analisi1, Aula1, Prova1);
		
		try {
			Segreteria.visualizzaStudentiPrenotati(primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			assertEquals(0, primoAppelloAnalisi1.getStudentiPrenotati().size());
	     }
	
	 }
	
	@Test
	public void test05PrenotatiAppelloNonPresente() {
		
		Corso Analisi1 = new Corso("Analisi 1", "Pietro Baldi", 6);
		
		try {
			Segreteria.inserisciCorso(Analisi1);
		} catch (CorsoGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		@SuppressWarnings("unused")
		Appello PrimoAppello = new Appello(Analisi1);
		
        LocalDate primaData = LocalDate.of(2019, Month.JANUARY, 06); 
		
		String Aula1 = "Aula 1";
		
		tipoProva Prova1 = tipoProva.SCRITTA;
		
		DataAppello primoAppelloAnalisi1 = new DataAppello(primaData, Analisi1, Aula1, Prova1);
		
		try {
			Segreteria.visualizzaStudentiPrenotati(primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			assertEquals(0, primoAppelloAnalisi1.getStudentiPrenotati().size());
		
	    }
	}
	
	@Test
	public void test06PrenotatiUnoStudenteDueVolte() {
		
		Studente s1 = new Studente("Angelo","Casciello", 1111);
		
		Corso Analisi1 = new Corso("Analisi 1", "Pietro Baldi", 6);
		
		try {
			Segreteria.inserisciCorso(Analisi1);
		} catch (CorsoGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		DataAppello primoAppelloAnalisi1 = new DataAppello(primaData, Analisi1, Aula1, Prova1);
		
		try {
			Segreteria.insericiDataAppello(primoAppelloAnalisi1);
		} catch (DataAppelloGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.prenotaEsame(s1, primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException | Gi‡PrenotatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.prenotaEsame(s1, primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException | Gi‡PrenotatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.visualizzaStudentiPrenotati(primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(1, primoAppelloAnalisi1.getStudentiPrenotati().size());
		
	}
	
	@Test
	public void test07PrenotatiUnoStudenteNull() {
		
        Studente s1 = null;
		
		Corso Analisi1 = new Corso("Analisi 1", "Pietro Baldi", 6);
		
		try {
			Segreteria.inserisciCorso(Analisi1);
		} catch (CorsoGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		DataAppello primoAppelloAnalisi1 = new DataAppello(primaData, Analisi1, Aula1, Prova1);
		
		try {
			Segreteria.insericiDataAppello(primoAppelloAnalisi1);
		} catch (DataAppelloGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.prenotaEsame(s1, primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException | Gi‡PrenotatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.visualizzaStudentiPrenotati(primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(0, primoAppelloAnalisi1.getStudentiPrenotati().size());
			
	}
	
	@Test
	public void test08PrenotatiUnAppelloNull() {
		
		Studente s1 = new Studente("Angelo","Casciello", 1111);
		
		Corso Analisi1 = new Corso("Analisi 1", "Pietro Baldi", 6);
		
		try {
			Segreteria.inserisciCorso(Analisi1);
		} catch (CorsoGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Appello PrimoAppello = null;
		
		try {
			Segreteria.inserisciAppello(PrimoAppello);
		} catch (AppelloGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LocalDate primaData = LocalDate.of(2019, Month.JANUARY, 06); 
		
		String Aula1 = "Aula 1";
		
		tipoProva Prova1 = tipoProva.SCRITTA;
		
		DataAppello primoAppelloAnalisi1 = new DataAppello(primaData, Analisi1, Aula1, Prova1);
		
		try {
			Segreteria.insericiDataAppello(primoAppelloAnalisi1);
		} catch (DataAppelloGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.prenotaEsame(s1, primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException | Gi‡PrenotatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.visualizzaStudentiPrenotati(primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(0, primoAppelloAnalisi1.getStudentiPrenotati().size());
		
	}
	
	@SuppressWarnings("null")
	@Test
	public void test09PrenotatiUnaDataAppelloNull() {
		
		Studente s1 = new Studente("Angelo","Casciello", 1111);
		
		Corso Analisi1 = new Corso("Analisi 1", "Pietro Baldi", 6);
		
		try {
			Segreteria.inserisciCorso(Analisi1);
		} catch (CorsoGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Appello PrimoAppello = new Appello(Analisi1);
		
		try {
			Segreteria.inserisciAppello(PrimoAppello);
		} catch (AppelloGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DataAppello primoAppelloAnalisi1 = null;
		
		try {
			Segreteria.insericiDataAppello(primoAppelloAnalisi1);
		} catch (DataAppelloGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.prenotaEsame(s1, primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException | Gi‡PrenotatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.visualizzaStudentiPrenotati(primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(0, primoAppelloAnalisi1.getStudentiPrenotati().size());
		
	}
	
	@SuppressWarnings("null")
	@Test
	public void test10PrenotatiCorsoNull() {
		
		Studente s1 = new Studente("Angelo","Casciello", 1111);
		
		Corso Analisi1 = null;
		
		try {
			Segreteria.inserisciCorso(Analisi1);
		} catch (CorsoGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Appello PrimoAppello = new Appello(Analisi1);
		
		try {
			Segreteria.inserisciAppello(PrimoAppello);
		} catch (AppelloGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DataAppello primoAppelloAnalisi1 = null;
		
		try {
			Segreteria.insericiDataAppello(primoAppelloAnalisi1);
		} catch (DataAppelloGi‡PresenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.prenotaEsame(s1, primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException | Gi‡PrenotatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Segreteria.visualizzaStudentiPrenotati(primoAppelloAnalisi1);
		} catch (AppelloNonTrovatoException | DataAppelloNonTrovataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(0, primoAppelloAnalisi1.getStudentiPrenotati().size());
		
	}
	
}
