package it.polito.tdp.toto;

import java.util.List;

public class Expander {

	public List<Schedina> expand(Pronostico p) {
		//deve fare la prima chiamata del metodo ricorsivo preparando le variabili che gli servono
		
		cerca(new Schedina(p.getN()),p, 0);
		
		return null;
	}

	//è il metodo ricorsivo
	private void cerca(Schedina parziale, Pronostico p, int livello) {
		//mi fermo quando la schedina è tutta piena, ovvero il parziale 
		//ha lo stesso numero di elementi del livello
		if(livello == p.getN()) {
			//caso terminale => ho la soluzione completa
			System.out.println(parziale);
			return;//return nel caso in cui l'algoritmo trova soluzione ai nodi terminali dell'albero: non serve andare oltre
		}
		
		
		Previsione mosse = p.get(livello) ;
		//get(0) mi darà il primo elemento del pronostico fatto dall'utente
		for( Risultato mossa : mosse.getValori() ) {
			parziale.add(mossa); // prova la soluzione
			cerca(parziale, p, livello+1) ;//ricorsione con la parziale aggiornata
			parziale.removeLast(); // backtrack
		}

	}
	
	/*
	Problema parziale: Schedina 1-X, livello 2
	Devo guardare pronostico p(2). Supponiamo sia X2
	Allora genererò le nuove soluzioni parziali 1-X-X, 1-X-2
	*/
}
