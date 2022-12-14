package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import graph.Graph;
import graph.Vertex;

public class Map {

    private Graph<String> graph;

    public void mapGenerate(){
        this.graph = new Graph<String>();
        this.graph.newVertice("A", "Hotel Apucarana Palace");
        this.graph.newVertice("B", "Construtora Hirose");
        this.graph.newVertice("C", "Loja Maçonica");
        this.graph.newVertice("D", "Wizard Apucarana");
        this.graph.newVertice("E", "Praça 28");
        this.graph.newVertice("F", "Clube 28");
        this.graph.newVertice("G", "Ceriani Craveiro Imoveis");

        this.graph.newVertice("H", "Shopping Centro Norte");
        this.graph.newVertice("I", "Mercearia Tókio");
        this.graph.newVertice("J", "Ponto de Onibus Garcia");
        this.graph.newVertice("K", "Auto Posto Catedral");
        this.graph.newVertice("L", "Bisa Cafés");
        this.graph.newVertice("M", "Atlanta Imóveis");
        this.graph.newVertice("N", "Cultura de Apucarana");
        
        this.graph.newVertice("O", "Praça Inventor Manuel Ribas");
        this.graph.newVertice("P", "Karlo's Calçados");
        this.graph.newVertice("Q", "Pernambucanas");
        this.graph.newVertice("R", "Catedral");
        this.graph.newVertice("S", "Lojas Colombo");
        this.graph.newVertice("T", "Valdar Moveis");
        this.graph.newVertice("U", "King Konfort Colchoes");

        this.graph.newVertice("V", "Monte Carlo Lava Car");
        this.graph.newVertice("W", "Facchiano Restaurante");
        this.graph.newVertice("X", "Correios");
        this.graph.newVertice("Y", "O Doidão Confecções");
        this.graph.newVertice("Z", "Casas Bahia");
        this.graph.newVertice("A'", "Atacadão do Suplemento");
        this.graph.newVertice("B'", "Molicenter");
        
        this.graph.newVertice("C'", "Haitatsu");
        this.graph.newVertice("D'", "Sicoob");
        this.graph.newVertice("E'", "CEBRAC");
        this.graph.newVertice("F'", "UNIMED");
        this.graph.newVertice("G'", "Pesqueiro Santo Antônio");
        this.graph.newVertice("H'", "Costela & Cia");
        this.graph.newVertice("I'", "Anacomdoçura");
        

        this.graph.addAresta("A","B","Clotário Portugal", 10);
        this.graph.addAresta("B","C","Clotário Portugal", 10);
        this.graph.addAresta("C","D","Clotário Portugal", 10);
        this.graph.addAresta("D","E","Clotário Portugal", 10);
        this.graph.addAresta("E","F","Clotário Portugal", 10);
        this.graph.addAresta("F","G","Clotário Portugal", 10);

        this.graph.addAresta("H","I","Munhoz da Rocha", 5);
        this.graph.addAresta("I","J","Munhoz da Rocha", 5);
        this.graph.addAresta("I","J","Munhoz da Rocha", 5);
        this.graph.addAresta("J","K","Munhoz da Rocha", 5);
        this.graph.addAresta("L","M","Munhoz da Rocha", 5);
        this.graph.addAresta("M","N","Munhoz da Rocha", 5);
        
        this.graph.addAresta("O","P","Avenida Curitiba", 10);
        this.graph.addAresta("P","Q","Avenida Curitiba", 10);
        this.graph.addAresta("Q","R","Avenida Curitiba", 10);
        this.graph.addAresta("R","S","Avenida Curitiba", 10);
        this.graph.addAresta("S","T","Avenida Curitiba", 10);
        this.graph.addAresta("T","U","Avenida Curitiba", 10);
        
        this.graph.addAresta("V","W","Ponta Grossa", 5);
        this.graph.addAresta("W","X","Ponta Grossa", 5);
        this.graph.addAresta("X","Y","Ponta Grossa", 5);
        this.graph.addAresta("Y","Z","Ponta Grossa", 5);
        this.graph.addAresta("Z","A'","Ponta Grossa", 5);
        this.graph.addAresta("A'","B'","Ponta Grossa", 5);
        
        this.graph.addAresta("C'","D'","Nagib Daher", 10);
        this.graph.addAresta("D'","E'","Nagib Daher", 10);
        this.graph.addAresta("E'","F'","Nagib Daher", 10);
        this.graph.addAresta("F'","G'","Nagib Daher", 10);
        this.graph.addAresta("G'","H'","Nagib Daher", 10);
        this.graph.addAresta("H'","I'","Nagib Daher", 10);
        
        this.graph.addAresta("A","H","Miguel Simião", 10);
        this.graph.addAresta("H","O","Miguel Simião", 10);
        this.graph.addAresta("O","V","Miguel Simião", 10);
        this.graph.addAresta("V","C'","Miguel Simião", 10);
        
        this.graph.addAresta("B","I","Oswaldo Cruz", 5);
        this.graph.addAresta("I","P","Oswaldo Cruz", 5);
        this.graph.addAresta("P","W","Oswaldo Cruz", 5);
        this.graph.addAresta("W","D'","Oswaldo Cruz", 5);
        
        this.graph.addAresta("C","J","Osório Ribas de Paula", 10);
        this.graph.addAresta("J","Q","Osório Ribas de Paula", 10);
        this.graph.addAresta("Q","X","Osório Ribas de Paula", 10);
        this.graph.addAresta("X","E'","Osório Ribas de Paula", 10);
        
        this.graph.addAresta("D","K","Rio Branco", 5);
        this.graph.addAresta("K","R","Rio Branco", 5);
        this.graph.addAresta("R","Y","Rio Branco", 5);
        this.graph.addAresta("Y","F'","Rio Branco", 5);
        
        this.graph.addAresta("E","L","Benjamin Braga Filho", 10);
        this.graph.addAresta("L","S","Benjamin Braga Filho", 10);
        this.graph.addAresta("S","Z","Benjamin Braga Filho", 10);
        this.graph.addAresta("Z","G'","Benjamin Braga Filho", 10);
        
        this.graph.addAresta("F","M","Renê Camargo", 5);
        this.graph.addAresta("M","T","Renê Camargo", 5);
        this.graph.addAresta("T","A'","Renê Camargo", 5);
        this.graph.addAresta("A'","H'","Renê Camargo", 5);
        
        this.graph.addAresta("G","N","Clóvis da Fonseca", 10);
        this.graph.addAresta("N","U","Clóvis da Fonseca", 10);
        this.graph.addAresta("U","B'","Clóvis da Fonseca", 10);
        this.graph.addAresta("B'","I'","Clóvis da Fonseca", 10);
        
        printarArestas();
    }
    
    public Vertex<String> getVertRandom() {
        ArrayList<Vertex<String>> list = this.graph.getVertices();
        Random rand = new Random();
        Vertex<String> v = list.get(rand.nextInt(list.size()));

        return v;
    }

    public void printarVertices() {
        for(int i = 0; i<this.graph.getVertices().size(); i++) {
            int num = i+1;
            System.out.println("'" + num + "' - " + this.graph.getVertices().get(i).getDesc());
        }
    }

    public void printarArestas() {
        this.graph.getArestas().forEach(a -> {
            System.out.println(a.toString());
        });
    }

    public List<Vertex<String>> getListaVert() {
        return this.graph.getVertices();
    }

    public Graph<String> getGraph(){
        return this.graph;
    }
}