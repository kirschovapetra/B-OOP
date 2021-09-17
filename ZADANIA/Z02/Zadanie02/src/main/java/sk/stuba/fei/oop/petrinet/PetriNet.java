package sk.stuba.fei.oop.petrinet;

import sk.stuba.fei.oop.exceptions.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PetriNet{
    private Map<Long, Place> places;                  //<ID miesta, miesto>
    private Map<Long, Transition> transitions;        //<ID prechodu, prechod>
    private Map<Long,Edge> edges;                     //<ID hrany, hrana>


    //konstruktory
    public PetriNet() {
        places = new LinkedHashMap<Long, Place>();
        transitions = new LinkedHashMap<Long, Transition>();
        edges = new LinkedHashMap<Long, Edge>();
    }

    public PetriNet(Map<Long, Place> places, Map<Long, Transition> transitions, Map<Long,Edge> edges) {
        this.places = new LinkedHashMap<Long, Place>(places);
        this.transitions = new LinkedHashMap<Long, Transition>(transitions);
        this.edges = new LinkedHashMap<Long,Edge>(edges);
    }

    //gettery, settery
    public Map<Long, Place> getPlaces() {
        return places;
    }
    public void setPlaces(Map<Long, Place> places) {
        this.places = places;
    }

    public Map<Long, Transition> getTransitions() {
        return transitions;
    }
    public void setTransitions(Map<Long, Transition> transitions) {
        this.transitions = transitions;
    }

    public Map<Long, Edge> getEdges() {
        return edges;
    }
    public void setEdges(Map<Long, Edge> edges) {
        this.edges = edges;
    }

    //pridaj miesto/prechod/hranu
    public void addPlace(Place place) {
        this.places.put(place.getId(), place);
    }

    public void addTransition(Transition transition) {
        this.transitions.put(transition.getId(), transition);
    }

    //typ hrany sa specifikuje pri vytvarani objektu
    public void addEdge(Edge edge) {
        this.edges.put(edge.getId(),edge);
    }


    //pridanie PT hrany pomocou id vstupneho a vystupneho vrcholu, defaultna nasobnost = 1
    public void addPTEdge(long edgeId, long placeStartId,long transitionEndId){
        Place placeStart = this.places.get(placeStartId);
        Transition transitionEnd = this.transitions.get(transitionEndId);

        PTEdge edgeToAdd = new PTEdge(edgeId,placeStart,transitionEnd);
        this.edges.put(edgeId,edgeToAdd);
    }
    //pridanie TP hrany pomocou id vstupneho a vystupneho vrcholu, defaultna nasobnost = 1
    public void addTPEdge(long edgeId,long transitionStartId,long placeEndId){
        Transition transitionStart = this.transitions.get(transitionStartId);
        Place placeEnd = this.places.get(placeEndId);

        TPEdge edgeToAdd = new TPEdge(edgeId,transitionStart,placeEnd);
        this.edges.put(edgeId,edgeToAdd);
    }
    //pridanie reset hrany pomocou id vstupneho a vystupneho vrcholu, defaultna nasobnost = 1
    public void addResetEdge(long edgeId, long placeStartId,long transitionEndId){
        Place placeStart = this.places.get(placeStartId);
        Transition transitionEnd = this.transitions.get(transitionEndId);

        ResetEdge edgeToAdd = new ResetEdge(edgeId,placeStart,transitionEnd);
        this.edges.put(edgeId,edgeToAdd);
    }
    //pridanie PT hrany pomocou id vstupneho a vystupneho vrcholu, vlastna nasobnost
    public void addPTEdge(long edgeId, long placeStartId,long transitionEndId, int weight){
        Place placeStart = this.places.get(placeStartId);
        Transition transitionEnd = this.transitions.get(transitionEndId);

        PTEdge edgeToAdd = new PTEdge(edgeId,placeStart,transitionEnd,weight);
        this.edges.put(edgeId,edgeToAdd);
    }
    //pridanie TP hrany pomocou id vstupneho a vystupneho vrcholu, vlastna nasobnost
    public void addTPEdge(long edgeId,long transitionStartId,long placeEndId, int weight){
        Transition transitionStart = this.transitions.get(transitionStartId);
        Place placeEnd = this.places.get(placeEndId);

        TPEdge edgeToAdd = new TPEdge(edgeId,transitionStart,placeEnd,weight);
        this.edges.put(edgeId,edgeToAdd);
    }

    //odstranenie miesta podla Id
    public void delPlace(long placeId) {
        //vytvori sa docasny zoznam hran, do ktoreho sa skopiruju hrany z this.edges
        //tento zoznam budem prechadzat v cykle, mazat budem z this.edges
        Map<Long,Edge>tmpEdges = new LinkedHashMap<Long,Edge>(this.edges);

        for (Edge currentEdge: tmpEdges.values()) {
            //vymazu sa vystupne a vystupne hrany
            if (currentEdge.getVertexStart() == this.places.get(placeId) ||
                    currentEdge.getVertexEnd() == this.places.get(placeId)) {
                delEdge(currentEdge.getId());
            }
        }
        //vymazanie miesta
        this.places.remove(placeId);
    }

    //odstranenie prechodu podla Id
    public void delTransition(long transitionId) {
        //vytvori sa docasny zoznam hran, do ktoreho sa skopiruju hrany z this.edges
        //tento zoznam budem prechadzat v cykle, mazat budem z this.edges
        Map<Long,Edge>tmpEdges = new LinkedHashMap<Long,Edge>(this.edges);

        for (Edge currentEdge: tmpEdges.values()){
            //vymazu sa vstupne a vystupne hrany
            if (currentEdge.getVertexEnd() == this.transitions.get(transitionId) ||
                    currentEdge.getVertexStart() == this.transitions.get(transitionId)){
                delEdge(currentEdge.getId());
            }
        }
        //vymazanie prechodu
        this.transitions.remove(transitionId);
    }

    //vymazanie hrany
    public void delEdge(long edgeId){
        Edge edge = edges.get(edgeId);
        if (edge instanceof PTEdge){
            ((Transition) edge.getVertexEnd()).delEdgeIn(edgeId);
        }
        else if (edge instanceof TPEdge){
            ((Transition) edge.getVertexStart()).delEdgeOut(edgeId);
        }

        this.edges.remove(edgeId);
    }

    //spustenie prechodu
    public void fireTransition(long transitionId) throws TransitionNotFirableException, TransitionNotFoundException {
        Transition transitionToFire = transitions.get(transitionId);

        //ak prechod neexistuje - exception
        if (transitionToFire == null) {
            throw new TransitionNotFoundException(transitionId);
        }

        transitionToFire.fire();
        updateTokens(transitionToFire);
    }

    private void updateTokens(Transition firedTransition){
        for (PTEdge currentEdge: firedTransition.getEdgesIn().values()){
            long placeId = currentEdge.getVertexStart().getId();
            int tokens = currentEdge.getVertexStart().getTokens();
            places.get(placeId).setTokens(tokens);
        }

        for (TPEdge currentEdge: firedTransition.getEdgesOut().values()){
            long placeId = currentEdge.getVertexEnd().getId();
            int tokens = currentEdge.getVertexEnd().getTokens();
            places.get(placeId).setTokens(tokens);
        }
    }

    public void clear(){
        this.edges.clear();
        this.places.clear();
        this.transitions.clear();
    }
}