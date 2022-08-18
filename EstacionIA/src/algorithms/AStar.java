package algorithms;

import java.util.ArrayList;

import queue.Queue;
import graph.Edge;
import graph.Vertex;

public class AStar<T> {
    
    private Queue<Edge<T>> aberta;
    private ArrayList<Edge<T>> fechada = new ArrayList<>();
    private int objetivo;
    
    public AStar(int vaga){
        this.aberta = new Queue<Edge<T>>();
        this.objetivo = vaga;
    }

    public void buscar(Edge<T> raiz) {
        this.aberta.enqueue(raiz,0,0);

        MetaH<T> mh = new MetaH<>(this.objetivo);
        
        while(!aberta.isEmpty()) {
            
            Edge<T> atual = aberta.dequeue();
            System.out.println(atual.getNome() + " adicionado na lista fechada!");
            fechada.add(atual);
            
            if(atual.containVaga(this.objetivo)) {
                //sucesso
                System.out.println("\n\nENCONTROU UMA VAGA NA RUA");
                System.out.print(atual.toString());
                System.out.println("Valor heuristico: " + atual.getF());
                break;
            }
            
            Vertex<T> vertice = atual.getFim();

            ArrayList<Edge<T>> filhos = new ArrayList<>();


            System.out.println("Adicionando as arestas adjascentes!");
            for (Edge<T> edge : vertice.getVertAdj()) {
                filhos.add(edge);
                System.out.println(edge.getNome() + " é adjascente de " + atual.getNome() + " via vértice " + edge.getFim().getIndex());
            }
            
            System.out.println("\nCriando a Heuristica para as ruas(arestas)");
            for (Edge<T> filho : filhos) {
                System.out.println("\nFilho:");
                System.out.println(filho.toString());
                if(contem(filho,fechada)) {
                    System.out.println(filho.getNome() + " está na lista fechada");
                    continue;
                }
                filho.setG(atual.getG() + distancia(filho.getFim(), atual.getFim()));
                filho.setH(mh.metaHeuristica(filho));
                filho.setF(filho.getG() + filho.getH());
                
                if(aberta.contains(filho) && filho.getG() > aberta.maxG()) {
                    System.out.println("A lista aberta contém filho e filho é maior que o Gmaximo da lista aberta");
                    continue;
                }
                System.out.println("De " + filho.getInicio().getIndex() + " -> " + filho.getNome() + " -> até " + filho.getFim().getIndex() + "\nCom G: " + filho.getG() + ", H: " + filho.getH() + " e F:" + filho.getF() + " adicionado na lista aberta");
                aberta.enqueue(filho, filho.getG(), filho.getF());
            }
        }
    }

    private boolean contem(Edge<T> filho, ArrayList<Edge<T>> lista) {
        for (Edge<T> objeto : fechada) {
            if(filho.getNome().equals(objeto.getNome())) {
                return true;
            }
        }
        return false;
    }

    private int distancia(Vertex<T> origem, Vertex<T> destino) {
        int distancia = 0;

        for(Edge<T> aresta : origem.getVertAdj()) {
            if(aresta.getFim().equals(destino)) {
                distancia = aresta.getPeso();
            }
        }

        System.out.println("Distancia de " + origem.getDesc() + " até " + destino.getDesc() + " é " + distancia);
        return distancia;
    }

}