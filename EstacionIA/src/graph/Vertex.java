package graph;

import java.util.ArrayList;
public class Vertex<T> {
    private T index;
    private String desc;
    private int G,H,F;
    private ArrayList<Edge<T>> vertAdj;

    public Vertex(){}

    public Vertex(T id, String valor) {
        this.G = 0; // distancia do filho até o atual
        this.H = 0; // distancia do filho até o objetivo
        this.F = 0; // soma das distancias
        this.index = id;
        this.desc = valor;
        this.vertAdj = new ArrayList<Edge<T>>();
    }

    public Vertex(T id, String valor, int heuristic) {
        this.G = 0; // distancia do filho até o atual
        this.H = heuristic; // distancia do filho até o objetivo
        this.F = 0; // soma das distancias
        this.index = id;
        this.desc = valor;
        this.vertAdj = new ArrayList<Edge<T>>();
    }

    public T getIndex() {
        return this.index;
    }

    public int getG() {
        return this.G;
    }

    public void setG(int Gg) {
        this.G = Gg;
    }

    public int getH() {
        return this.H;
    }

    public void setH(int Hh) {
        this.H = Hh;
    }

    public int getF() {
        return this.F;
    }

    public void setF(int Ff) {
        this.F = Ff;
    }

    public ArrayList<Edge<T>> getVertAdj() {
        return this.vertAdj;
    }

    public void setVertAdj(ArrayList<Edge<T>> vertAdj) {
        this.vertAdj = vertAdj;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String valor) {
        this.desc = valor;
    }

    public void addAjascente(Edge<T> adj) {
        this.vertAdj.add(adj);
    }
}