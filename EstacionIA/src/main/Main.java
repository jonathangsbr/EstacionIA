package main;

import java.util.HashMap;
import java.util.Random;

import graph.Vertex;

public class Main {

    public static HashMap<Integer, String> veic = new HashMap<Integer, String>();
    public static HashMap<Integer, String> alg = new HashMap<Integer, String>();
    
    public static void main(String[] args) throws Exception {
        veic.put(1, "moto");
        veic.put(2, "carro");
        veic.put(3, "caminhão");
        alg.put(1, "A Estrela (A*)");
        alg.put(2, "Pesquisa Tabu (Tabu Search)");
        alg.put(3, "Roda os dois algoritmos");
        Map mapa = new Map();
        mapa.mapGenerate();
        int veiculo = 1; //tipo do veiculo
        int algoritmo = 1; //algoritmo utilizado
        Vertex<?> localizacao = mapa.getListaVert().get(0);
        
        for(int i = 0; i<args.length; i++) {
            if(args[i].equals("-H")) {
                System.out.println("=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("Comandos: ");
                System.out.println("'-V x' (x sendo o veículo)");
                System.out.println("'-A alg' (alg sendo um algoritmo para busca)");
                System.out.println("'-L local' (local sendo o vértice inicial)");
                System.out.println("=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("Lista de veículos:");
                System.out.println("'1' - Moto - [-]: vaga vazia / [M]: vaga preenchida");
                System.out.println("'2' - Carro - [+]: vaga vazia / [C]: vaga preenchida");
                System.out.println("'3' - Caminhão - [*]: vaga vazia / [T]: vaga preenchida");
                System.out.println("=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("Lista de algoritmos:");
                System.out.println("'1' - A Estrela (A*)");
                System.out.println("'2' - Pesquisa Tabu (Tabu Search)");
                System.out.println("'3' - Roda os dois algoritmos");
                System.out.println("=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("Lista de vértices:");
                mapa.printarVertices();
                System.out.println("=-=-=-=-=-=-=-=-=-=-=");
            }
            else if(args[i].equals("-V")) {
                try {
                    veiculo = Integer.parseInt(args[i+1]);
                    if(!veic.containsKey(veiculo)){
                        throw new Exception();
                    }
                    System.out.println("Veículo selecionado: " + veic.get(veiculo));
                    
                } catch (Exception e) {
                    Random rand = new Random();
                    veiculo = rand.nextInt(3)+1;
                    System.out.println("Argumento para veículo inválido");
                    System.out.println("Aleatorizando veículo: " + veic.get(veiculo));
                }
            }
            else if(args[i].equals("-A")) {
                try {
                    algoritmo = Integer.parseInt(args[i+1]);
                    if(!alg.containsKey(algoritmo)){
                        throw new Exception();
                    }
                    System.out.println("Algoritmo selecionado: " + alg.get(algoritmo));
                    
                } catch (Exception e) {
                    Random rand = new Random();
                    algoritmo = rand.nextInt(3)+1;
                    System.out.println("Argumento para algoritmo inválido");
                    System.out.println("Aleatorizando algoritmo: " + alg.get(algoritmo));
                    
                }
            }
            else if(args[i].equals("-L")) {
                try {
                    localizacao = mapa.getListaVert().get(Integer.parseInt(args[i+1])-1);
                    System.out.println("Localização selecionada: " + localizacao.getDesc());

                    
                } catch (Exception e) {
                    localizacao = mapa.getVertRandom(); //localização inicial (vertice)
                    System.out.println("Argumento para localização inválido");
                    System.out.println("Aleatorizando localização: " + localizacao.getDesc());

                }
            }
        }
        EstacionIA estacionar = new EstacionIA(veiculo, mapa, localizacao);
        estacionar.solucao(algoritmo);
    }
}
