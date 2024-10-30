package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {
	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		this(20);
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
			if (innlegg.erLik(innleggtabell[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) != -1;
	}

	public boolean ledigPlass() {
		return nesteledig < innleggtabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
	}
	
	public String toString() {
		String str = nesteledig + "\n";
		for (int i = 0; i < nesteledig; i++) {
			str += innleggtabell[i].toString();
		}
		return str;
	}
	

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nTabell = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < nesteledig; i++) {
			nTabell[i] = innleggtabell[i];
		}
		innleggtabell = nTabell; 
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if (leggTil(innlegg)) {
			return true;
		}
		if (!ledigPlass()) {
			utvid();
			return leggTil(innlegg);
		}
		return false;
	}
	
	public boolean slett(Innlegg innlegg) {
		if (finnes(innlegg)) {
			innleggtabell[finnInnlegg(innlegg)] = null;
			nesteledig--;
			return true;
		}
		return false;
	}
	
	public int[] search(String keyword) {
		//Malen matvher ikke oppgaven fra github?
		throw new UnsupportedOperationException(TODO.method());

	}
}