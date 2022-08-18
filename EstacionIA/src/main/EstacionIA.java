package main;

import java.util.Scanner;

import algorithms.AStar;
import algorithms.TabuSearch;
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
        AStar<String> aAlg = new AStar<>(this.veicule);
        TabuSearch<String> tAlg = new TabuSearch<String>(this.veicule, 5);
        switch (algoritmo) {
            case 1:
                System.out.println("--- Algoritmo A* para encontrar uma vaga de estacionamento ---:");
                aAlg.buscar(this.arestaInicial);
                break;

                case 2:
                System.out.println("--- Algoritmo Busca Tabu para encontrar uma vaga de estacionamento ---:");
                tAlg.buscar(this.arestaInicial);
                break;

                case 3:
                System.out.println("--- Comparando os dois Algoritmos ---\n\n");
                System.out.println("--- Algoritmo A* para encontrar uma vaga de estacionamento ---:");
                aAlg.buscar(this.arestaInicial);
                System.out.println("\n\n\n--- Aperte enter para continuar para o próximo algoritmo ---\n\n\n");
                new Scanner(System.in).nextLine();
                System.out.println("--- Algoritmo Busca Tabu para encontrar uma vaga de estacionamento ---:");
                tAlg.buscar(this.arestaInicial);
        }
    }

}
