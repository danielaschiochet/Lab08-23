package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;


public class Model {

	private Graph<Airport, DefaultWeightedEdge> grafo;
	private List<Airport> aeroporti;
	private Map<Integer, Airport> aeroportiIdMap;

	
	public void creaGrafo(int d) {
		
		
		//crea l'oggetto grafo
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		//aggiungi i vertici
		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		aeroporti = dao.loadAllAirports();
		
		aeroportiIdMap = new HashMap<>();
		for(Airport a : this.aeroporti) {
			this.aeroportiIdMap.put(a.getId(), a);
		}

		Graphs.addAllVertices(grafo, aeroporti);
		
		//aggiungi gli archi
		//faccio una query per prendermi tutti gli edges (con classe di appoggio e idMap) -più veloce
		List<Distanza> coppie = dao.trovaDistanza(d, aeroportiIdMap);
		for(Distanza c: coppie) {
			Graphs.addEdge(grafo, c.getPartenza(), c.getArrivo(), c.getDistanza());
		}
		
		System.out.println("Grafo creato con "+this.grafo.vertexSet().size()+" vertici e "+grafo.edgeSet().size()+" archi.");
		System.out.println(grafo);

	}
	
	public int getVertici() {
		
		return grafo.vertexSet().size();
	}
	
	public int getArchi() {
		
		return grafo.edgeSet().size();
	}
	
	public List<Distanza> getRotte(int d){
		
		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		List<Distanza> coppie = dao.trovaDistanza(d, aeroportiIdMap);
		
		return coppie;
	}
}
