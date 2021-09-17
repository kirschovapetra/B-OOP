import java.util.List;

public class Transition extends Vertex {

    //konstruktory - id povinne
    public Transition(long id) { //bez mena
        super(id);
    }

    public Transition(long id, String name) {
        super(id, name);
    }

    //test spustitelnosti
    public boolean isFirable(List<PTEdge> pt_edges) {
        for (PTEdge current_edge : pt_edges) { //testuju sa len PT hrany

            //len tie hrany, ktore vstupuju do daneho prechodu
            if (this == current_edge.getVertex_end()) {

                //reset hrany neovplyvnuju spustitelnost
                if (!(current_edge instanceof ResetEdge)) {

                    //ked je v mieste menej tokenov ako je nasobnost vstupnej hrany = nie je spustitelny
                    if (current_edge.getVertex_start().getTokens() < current_edge.getWeight()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //konzumuje tokeny zo vstupnych miest
    public void consumeTokens(List<PTEdge> pt_edges) {
        if (this.isFirable(pt_edges)) { //ak je prechod spustitelny

            for (PTEdge current_edge : pt_edges) {

                //hrany vstupujuce do daneho prechodu
                if (this == current_edge.getVertex_end()) {

                    if (current_edge instanceof ResetEdge){
                        //reset hrana vynuluje znackovanie
                        current_edge.getVertex_start().setTokens(0);
                    }
                    else {
                        //odpocita sa z miesta tolko tokenov, kolko je nasobnost hrany
                        current_edge.getVertex_start().updateTokens(-current_edge.getWeight());
                    }
                }
            }
        }
    }

    //produkuje tokeny do vystupnych miest
    public void produceTokens(List<TPEdge> tp_edges) {
        for (TPEdge current_edge : tp_edges) {

            //pre hrany vystupujuce z daneho prechodu
            if (this == current_edge.getVertex_start()) {

                //pripocita sa do miesta tolko tokenov, kolko je nasobnost vystupnej hrany
                current_edge.getVertex_end().updateTokens(current_edge.getWeight());
            }
        }
    }
}
