package graph;

import java.util.ArrayList;
import java.util.Random;

import objects.Parking;

public class Edge<T> {
    private Random rand = new Random();
    private String nome;
    private Vertex<T> inicio;
    private Vertex<T> fim;
    private ArrayList<Parking> esquerda;
    private ArrayList<Parking> direita;
    private int peso;

    public Edge(Vertex<T> start, Vertex<T> end, String rua, int distancia) {
        this.inicio = start;
        this.fim = end;
        this.peso = distancia;
        this.nome = rua;
        this.direita = new ArrayList<Parking>();
        this.esquerda = new ArrayList<Parking>();
    }

    public Edge(Vertex<T> start, Vertex<T> end, String rua) {
        this.inicio = start;
        this.fim = end;
        this.peso = 0;
        this.nome = rua;
        this.direita = new ArrayList<Parking>();
        this.esquerda = new ArrayList<Parking>();
    }

    public void GerarEstacionamento() {
        int lados = rand.nextInt(10);
        if(lados<8) {
            this.GerarVagas(this.esquerda);
            this.GerarVagas(this.direita);
        }
        else {
            this.GerarVagas(this.esquerda);
        }
    }

    public void GerarVagas(ArrayList<Parking> lista) {
        for(int i=0; i<15+rand.nextInt(16); i++) {
            int tipo = 2;
            boolean ocupado = true;

            int chanceVeiculo = rand.nextInt(100);
            int chanceOcupado = rand.nextInt(100);

            if(chanceVeiculo >= 70 && chanceVeiculo < 95) {
                tipo = 1; //gera moto

            }else if(chanceVeiculo >= 95) {
                tipo = 3; //gera caminhao
            }
            if(chanceOcupado >= 95) {
                ocupado = false;
            }
            lista.add(new Parking(tipo, ocupado)); //tipo 1-3 e ocupado?
        }
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Vertex<T> getInicio() {
        return this.inicio;
    }

    public void setInicio(Vertex<T> inicio) {
        this.inicio = inicio;
    }

    public Vertex<T> getFim() {
        return this.fim;
    }

    public void setFim(Vertex<T> fim) {
        this.fim = fim;
    }

    public void setEsquerda(ArrayList<Parking> esquerda){
        this.esquerda = esquerda;
    }

    public ArrayList<Parking> getEsquerda(){
        return this.esquerda;
    }

    public void setDireita(ArrayList<Parking> direita){
        this.direita = direita;
    }

    public ArrayList<Parking> getDireita(){
        return this.direita;
    }

    @Override
    public String toString() {
        String txt = "";

        txt += this.inicio.getIndex() + ": " + this.inicio.getDesc();
        txt += " -> Rua: " + this.nome + " - Distancia: " + this.peso + " -> ";
        txt += this.fim.getIndex() + ": " + this.fim.getDesc() + "\n";
        
        for(Parking vaga: this.esquerda) {
            txt += vaga.toString();
        }
        txt += "\n";
        if(this.esquerda.size() >= this.direita.size()) {
            for(int i=0; i<this.esquerda.size(); i++) {
                txt += "---";
            }
        }
        if(this.direita.size() > this.esquerda.size()) {
            for(int i=0; i<this.direita.size(); i++) {
                txt += "---";
            }
        }
        txt += "\n";
        if(!this.direita.isEmpty()) {
            for(Parking vaga : this.direita) {
                txt += vaga.toString();
            }
        }
        else {
            for(int i=0; i<this.esquerda.size(); i++) {
                txt += "[X]";
            }
        }
        return txt+"\n";
    }

}