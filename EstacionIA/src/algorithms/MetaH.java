package algorithms;

import graph.Edge;

public class MetaH<T> {

    //2m - moto
    //6m - carro
    //10m - caminhão

    private int veiculo;

    public MetaH(int objetivo) {
        this.veiculo = objetivo;
    }

    public int metaHeuristica(Edge<T> filho) {
        int mHeuristica=0;
        int tam = (filho.getDireita().size() > filho.getEsquerda().size()) ? filho.getDireita().size() : filho.getEsquerda().size();
        
        for(int i=0; i<tam; i++) {
            if(i < filho.getDireita().size()) {
                if(!filho.getDireita().get(i).isOcupado() && this.veiculo == filho.getDireita().get(i).getTipo()) return mHeuristica;
                mHeuristica += filho.getDireita().get(i).getTamanho();
            }
            if(i < filho.getEsquerda().size()) {
                if(!filho.getEsquerda().get(i).isOcupado() && this.veiculo == filho.getEsquerda().get(i).getTipo()) return mHeuristica;
                mHeuristica += filho.getEsquerda().get(i).getTamanho();
            }
        }

        return mHeuristica;
    }
}