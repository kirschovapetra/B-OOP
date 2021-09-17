package sk.stuba.fei.oop.petrinet;

import sk.stuba.fei.oop.exceptions.TransitionNotFirableException;

import java.util.LinkedHashMap;
import java.util.Map;

public class Transition extends Vertex {
    private Map<Long,PTEdge> edgesIn;   //vstupne hrany
    private Map<Long,TPEdge> edgesOut;  //vystupne hrany

    //konstruktory - id povinne
    public Transition(long id) { //bez mena
        super(id);
        this.edgesIn = new LinkedHashMap<Long,PTEdge>();
        this.edgesOut = new LinkedHashMap<Long,TPEdge>();
    }
    public Transition(long id, String name) {
        super(id, name);
        this.edgesIn = new LinkedHashMap<Long,PTEdge>();
        this.edgesOut = new LinkedHashMap<Long,TPEdge>();
    }

    //gettery, settery
    public Map<Long, PTEdge> getEdgesIn() {
        return edgesIn;
    }
    public void setEdgesIn(Map<Long, PTEdge> edgesIn) {
        this.edgesIn = edgesIn;
    }

    public Map<Long, TPEdge> getEdgesOut() {
        return edgesOut;
    }
    public void setEdgesOut(Map<Long, TPEdge> edgesOut) {
        this.edgesOut = edgesOut;
    }

    //pridanie vstupnej/vystupnej hrany
    public void addEdgeIn(PTEdge ptEdge){
        this.edgesIn.put(ptEdge.getId(),ptEdge);
    }
    public void addEdgeOut(TPEdge tpEdge){
        this.edgesOut.put(tpEdge.getId(),tpEdge);
    }

    //vymazanie vstupnej/vystupnej hrany
    public void delEdgeIn(long edgeId){
        this.edgesIn.remove(edgeId);
    }
    public void delEdgeOut(long edgeId){
        this.edgesOut.remove(edgeId);
    }

    //test spustitelnosti
    public boolean isFirable() {
        for (PTEdge currentEdge : edgesIn.values()) { //testuju sa len PT hrany

            //len tie hrany, ktore vstupuju do daneho prechodu
            if (this == currentEdge.getVertexEnd()) {

                //reset hrany neovplyvnuju spustitelnost
                if (!(currentEdge instanceof ResetEdge)) {

                    //ked je v mieste menej tokenov ako je nasobnost vstupnej hrany = nie je spustitelny
                    if (currentEdge.getVertexStart().getTokens() < currentEdge.getWeight()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //konzumuje tokeny zo vstupnych miest
    public void consumeTokens() {
        if (this.isFirable()) { //ak je prechod spustitelny

            for (PTEdge currentEdge : edgesIn.values()) {

                //hrany vstupujuce do daneho prechodu
                if (this == currentEdge.getVertexEnd()) {

                    if (currentEdge instanceof ResetEdge){
                        //reset hrana vynuluje znackovanie
                        currentEdge.getVertexStart().setTokens(0);
                    }
                    else {
                        //odpocita sa z miesta tolko tokenov, kolko je nasobnost hrany
                        currentEdge.getVertexStart().updateTokens(-currentEdge.getWeight());
                    }
                }
            }
        }
    }

    //produkuje tokeny do vystupnych miest
    public void produceTokens() {
        for (TPEdge currentEdge : edgesOut.values()) {

            //pre hrany vystupujuce z daneho prechodu
            if (this == currentEdge.getVertexStart()) {

                //pripocita sa do miesta tolko tokenov, kolko je nasobnost vystupnej hrany
                currentEdge.getVertexEnd().updateTokens(currentEdge.getWeight());
            }
        }
    }
    public void fire() throws TransitionNotFirableException{

        //ak prechod nie je spustitelny - exception
        if (!isFirable()) {
            throw new TransitionNotFirableException(getId());
        }

        consumeTokens();
        produceTokens();
    }
}
