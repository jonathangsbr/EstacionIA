package graph;

import java.util.ArrayList;

public class Graph<T> {
    private ArrayList<Vertex<T>> vertices;
    private ArrayList<Edge<T>> arestas;
    private Vertex<T> raiz;

    public Graph() {
        this.vertices = new ArrayList<Vertex<T>>();
        this.arestas = new ArrayList<Edge<T>>();
    }

    public void setRaiz(Vertex<T> root) {
        this.raiz = root;
    }

    public Vertex<T> getRaiz(){
        return this.raiz;
    }

    public void newVertice (T id, String dado){
        Vertex<T> novoVert = new Vertex<T>(id, dado);
        if(vertices.isEmpty()) {
            setRaiz(novoVert);
        }
        this.vertices.add(novoVert);
    }

    public void addVertice (Vertex<T> vertex){
        this.vertices.add(vertex);
    }

    public void addAresta (T dadoInicio, T dadoFim, String nome){
        Vertex<T> inicio = this.getVertice(dadoInicio);
        Vertex<T> fim = this.getVertice(dadoFim);
        
        Edge<T> arestaIn = new Edge<T>(inicio, fim, nome);
        Edge<T> arestaFi = new Edge<T>(fim, inicio, nome);
        arestaIn.GerarEstacionamento();

        arestaFi.setEsquerda(arestaIn.getDireita());
        arestaFi.setDireita(arestaIn.getEsquerda());
        
        inicio.addAjascente(arestaIn);
        fim.addAjascente(arestaFi);
        
        this.arestas.add(arestaIn);
        this.arestas.add(arestaFi);
    }
    
    public void addAresta (T dadoInicio, T dadoFim, String nome, int weight){
        Vertex<T> inicio = this.getVertice(dadoInicio);
        Vertex<T> fim = this.getVertice(dadoFim);
        
        Edge<T> arestaIn = new Edge<T>(inicio, fim, nome, weight);
        Edge<T> arestaFi = new Edge<T>(fim, inicio, nome, weight);
        arestaIn.GerarEstacionamento();
        
        arestaFi.setEsquerda(arestaIn.getDireita());
        arestaFi.setDireita(arestaIn.getEsquerda());
        
        inicio.addAjascente(arestaIn);
        fim.addAjascente(arestaFi);

        this.arestas.add(arestaIn);
        this.arestas.add(arestaFi);
    }

    public ArrayList<Vertex<T>> getVertices() {
        return this.vertices;
    }

    public void setVertices(ArrayList<Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Edge<T>> getArestas() {
        return this.arestas;
    }

    public void setArestas(ArrayList<Edge<T>> arestas) {
        this.arestas = arestas;
    }

    public Vertex<T> getVertice(T dado){
        Vertex<T> vertice = new Vertex<T>();
        for(int i = 0; i<this.vertices.size(); i++){
            if(this.vertices.get(i).getIndex().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

}