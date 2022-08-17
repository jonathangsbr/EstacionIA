package main;

import algorithms.AStar;
import graph.Edge;
import graph.Vertex;

public class EstacionIA {

    private int veicule;
    private Edge<String> arestaInicial;

    public EstacionIA(int veiculo, Map mapa, Vertex<String> localizacao) {
        this.veicule = veiculo;
        Vertex<String> Z = new Vertex<>("Z", "Inicial");
        mapa.getGraph().addVertice(Z);
        this.arestaInicial = new Edge<>(Z, localizacao, "Inicio", 0);
        mapa.getGraph().addArestaIni(this.arestaInicial);
    }
    
    // S-> 0 -> localizacao

    public void solucao(int algoritmo) {
        switch (algoritmo) {
            case 1:
                System.out.println("--- Algoritmo A* para encontrar uma vaga de estacionamento ---:");
                AStar<String> aAlg = new AStar<>(this.veicule);
                aAlg.buscar(this.arestaInicial);
                break;
            case 2:
                System.out.println("--- Algoritmo Busca Tabu para encontrar uma vaga de estacionamento ---:");
                // TabuSearch tAlg = new TabuSearch();
                break;
        }
    }

}
