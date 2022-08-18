package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;

import graph.Edge;

public class TabuSearch<T> {
    /* PSEUDO CODIGO:
        initialize parameters: tolerance, initial seed, maxiterations,max_tabu_size
        Sbest <- S0
        best_candidate <- S0
        tabu_list <- empty
        tabu_list.push(S0)
        while iterations < max_iterations do
            s_neighborhood <- get_neighbors(best_ca)
            best_candidate <- s_neighnorhood[0]
            for s_candidate in s_neighborhood
                if(not tabulist.contains(s_candidate)) && (fitness(s_candidate) > fitness(best_candidate)) then
                    best_Candidate <- s_Candidate
                end if
            end for
            if fitness(bext_Candidate) > fitness(s_Best) then
                s_Best <- best_Candidate
            end if
            tabu_list.push(best_Cantdidate)
            if tabu_list.size > max_Tabu_Size then
                tabu_list.remove_First()
            end if
        end while
    */


    private int objetivo;
    private int maxTabuSize;
    private Edge<T> bestCandidate;
    private LinkedList<Edge<T>> tabuList;

    public TabuSearch(int vaga, int maxTabuSize){
        this.tabuList = new LinkedList<>();
        this.objetivo = vaga;
        this.maxTabuSize = maxTabuSize;
    }

    public void buscar(Edge<T> raiz) {
        MetaH<T> mh = new MetaH<>(this.objetivo);
        raiz.setH(Integer.MAX_VALUE);
        this.bestCandidate = raiz;
        int i = 0;
        int maxIterations = 200;
        boolean encontrou = false;

        tabuList.add(raiz);
        while(i<maxIterations) {
            // new Scanner(System.in).nextLine();
            if(bestCandidate.containVaga(this.objetivo)) {
                System.out.println("\n\nENCONTROU UMA VAGA NA RUA");
                System.out.print(bestCandidate.toString());
                System.out.println("Valor metaheuristico: " + bestCandidate.getH());
                encontrou = true;
                break;
            }

            System.out.println("Adicionando as arestas adjascentes!");
            ArrayList<Edge<T>> RuasVizinhas = bestCandidate.getFim().getVertAdj();
            System.out.println("Criando a metaheuristica para as ruas(arestas)");
            for (Edge<T> Rua : RuasVizinhas) {
                Rua.setH(mh.metaHeuristica(Rua));
                System.out.println("De " + Rua.getInicio().getIndex() + " -> " + Rua.getNome() + " -> até " + Rua.getFim().getIndex() + "\nCom H: " + Rua.getH());
            }

            Edge<T> menorCandidatoTemp = new Edge<T>();
            menorCandidatoTemp.setH(Integer.MAX_VALUE);
            
            for (Edge<T> Candidate : RuasVizinhas) {
                boolean contain = false;
                for (Edge<T> RuaTabu : tabuList) {
                    if(Candidate.getH()==RuaTabu.getH() && Candidate.getNome().equals(RuaTabu.getNome())) {
                        contain = true;
                        continue;
                    }
                }
                if(!contain && Candidate.getH() < menorCandidatoTemp.getH()) {
                    menorCandidatoTemp = Candidate;
                }
                // System.out.println("Lista Tabu contem " + Candidate.getNome() + ": " + this.tabuList.contains(Candidate.getNome()));
            }
            bestCandidate = menorCandidatoTemp;

            System.out.println("Melhor candidato para ser expandido: ");
            System.out.println(bestCandidate.toString());
            
            System.out.println("De " + bestCandidate.getInicio().getIndex() + " -> " + bestCandidate.getNome() + " -> até " + bestCandidate.getFim().getIndex() + "\nCom H: " + bestCandidate.getH());
            System.out.println("Adicionado na lista tabu");
            this.tabuList.push(bestCandidate);

            if(this.tabuList.size() > this.maxTabuSize) {
                System.out.println("LISTA TABU ATINGIU TAMANHO MÁXIMO!");
                System.out.println("Removendo da lista: " + this.tabuList.removeLast().getNome());
            }
            i++;
        }
        if(!encontrou) System.out.println("NÃO FOI ENCONTRADO NENHUMA VAGA");
    }

}
