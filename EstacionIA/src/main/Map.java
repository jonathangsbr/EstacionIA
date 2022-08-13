package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import graph.Graph;
import graph.Vertex;

// =-= MAPA DE APUCARANA =-=
// --- Vertices: ---
// A- Praça Inventor Manoel Ribas / Shopping Centro Norte
// B- Catedral Oeste
// C- Catedral Leste
// D- Hotel Apucarana Palace
// E- Climeta (Clinica Médica e do Trabalho de Apucarana)
// F- Hospital da Providencia
// G- Farmacias
// H- Odonto Company
// I- Condominio Residencial Alphaville
// J- Loja Maçonica
// K- Praça 28 de Janeiro
// L- Clube 28 de Janeiro
// --- Arestas: ---
// A-B -- Avenida Curitiba
// A-I -- Miguel Simião
// A-E -- Miguel Simião
// B-C -- Praça Rui Barbosa
// B-J -- Osório Ribas
// B-F -- Osório Ribas
// C-K -- João Candido Ferreira
// C-D -- Avenida Curitiba
// C-G -- João Candido Ferreira
// D-L -- Clóvis da Fonseca
// D-H -- Clóvis da Fonseca
// I-J -- Clotário Portugal
// J-K -- Clotário Portugal
// K-L -- Clotário Portugal
// E-F -- Nagib Daher
// F-G -- Nagib Daher
// G-H -- Nagib Daher

public class Map {

    private Graph<String> graph;

    public void mapGenerate(){
        this.graph = new Graph<String>();
        this.graph.newVertice("A", "Praça Manoel Ribas");
        this.graph.newVertice("B", "Catedral Oeste");
        this.graph.newVertice("C", "Catedral Lest");
        this.graph.newVertice("D", "Hotel Apucarana Palace");
        this.graph.newVertice("E", "Climeta");
        this.graph.newVertice("F", "Hospital da Providência");
        this.graph.newVertice("G", "Farmacias");
        this.graph.newVertice("H", "Odonto Company");
        this.graph.newVertice("I", "Alphaville");
        this.graph.newVertice("J", "Loja Maçonica");
        this.graph.newVertice("K", "Praça 28");
        this.graph.newVertice("L", "Clube 28");
        
        this.graph.addAresta("A","B","Avenida Curitiba", 2);
        this.graph.addAresta("A","I","Miguel Simião", 2);
        this.graph.addAresta("A","E","Miguel Simião", 2);
        this.graph.addAresta("B","C","Praça Rui Barbosa", 2);
        this.graph.addAresta("B","J","Osório Ribas", 2);
        this.graph.addAresta("B","F","Osório Ribas", 2);
        this.graph.addAresta("C","K","João Candido Ferreira", 2);
        this.graph.addAresta("C","D","Avenida Curitiba", 2);
        this.graph.addAresta("C","G","João Candido Ferreira", 2);
        this.graph.addAresta("D","L","Clóvis da Fonseca", 2);
        this.graph.addAresta("D","H","Clóvis da Fonseca", 2);
        this.graph.addAresta("I","J","Clotário Portugal", 2);
        this.graph.addAresta("J","K","Clotário Portugal", 2);
        this.graph.addAresta("K","L","Clotário Portugal", 2);
        this.graph.addAresta("E","F","Nagib Daher", 2);
        this.graph.addAresta("F","G","Nagib Daher", 2);
        this.graph.addAresta("G","H","Nagib Daher", 2);
        // this.graph.getArestas().forEach(a -> {
        //     System.out.println(a.toString());
        // });

    }
    
    public Vertex<String> getVertRandom(){
        ArrayList<Vertex<String>> list = this.graph.getVertices();
        Random rand = new Random();
        Vertex<String> v = list.get(rand.nextInt(list.size()));

        return v;
    }

    public void printarVertices(){
        for(int i = 0; i<this.graph.getVertices().size(); i++) {
            int num = i+1;
            System.out.println("'" + num + "' - " + this.graph.getVertices().get(i).getDesc());
        }
    }

    public List<Vertex<String>> getListaVert(){
        return this.graph.getVertices();
    }
}
