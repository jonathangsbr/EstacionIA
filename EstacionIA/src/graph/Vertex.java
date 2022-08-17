package graph;

import java.util.ArrayList;
public class Vertex<T> {
    private T index;
    private String desc;
    private ArrayList<Edge<T>> vertAdj;

    public Vertex(){}

    public Vertex(T id, String valor) {
        this.index = id;
        this.desc = valor;
        this.vertAdj = new ArrayList<Edge<T>>();
    }

    public T getIndex() {
        return this.index;
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