package no.hvl.dat100.oppgave7;


import java.io.IOException;
import java.net.ServerSocket;

import no.hvl.dat100.oppgave2.Bilde;
import no.hvl.dat100.oppgave2.Tekst;
import no.hvl.dat100.oppgave3.Blogg;
import no.hvl.dat100.oppgave4.SkrivBlogg;

public class WebServer {
	
	public static void main(String[] args) {
		
		// int serverport = Configuration.SERVERPORT;
			
		// System.out.println("TCP server starting # " + serverport);
		
		// try (ServerSocket welcomeSocket = new ServerSocket(serverport)) {
				
		// 	BloggApp server = new BloggApp(welcomeSocket);

		// 	int n = Configuration.N;
			
		// 	while (n>0) {
				
		// 		server.process();
			
		// 		n--;
		// 	}
			
		// } catch (IOException ex) {
		// 	System.out.println("TCP server: " + ex.getMessage());
		// 	ex.printStackTrace();
		// } 
		
		// System.out.println("TCP Server shutting down");

		Tekst innlegg1 = new Tekst(1,"Ole Olsen","23-10","en tekst");
		Bilde innlegg2 = new Bilde(2,"Oline Olsen","24-10","et bilde","http://www.picture.com/oo.jpg");
		
		Blogg samling = new Blogg();
		
		samling.leggTil(innlegg1);
		samling.leggTil(innlegg2);
		
		SkrivBlogg.skriv(samling, System.getProperty("user.dir") + "/src/test/java/no/hvl/dat100/tests/", "blogg.dat");

	}
}
