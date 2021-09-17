import exceptions.TransitionNotFirableException;
import exceptions.TransitionNotFoundException;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PetriNet {
    //map zabezpeci to, ze v petriho sieti budu mat miesta a prechody jednoznacne ID, ktore sa nebude opakovat
    //ale moze sa stat, ze miesta/prechody budu mat rovnake meno, alebo budu bez mena

    private Map<Long, Place> places;             //<ID miesta, miesto>
    private Map<Long, Transition> transitions;   //<ID prechodu, prechod>
    private List<Edge> edges;                    //zoznam hran

    //konstruktory
    public PetriNet() { // vytvori sa prazdna petriho siet
        this.places = new LinkedHashMap<Long, Place>();
        this.transitions = new LinkedHashMap<Long, Transition>();
        this.edges = new LinkedList<Edge>();
    }
    public PetriNet(Map<Long, Place> places, Map<Long, Transition> transitions, List<Edge> edges) {
        this.places = new LinkedHashMap<Long, Place>(places);
        this.transitions = new LinkedHashMap<Long, Transition>(transitions);
        this.edges = new LinkedList<Edge>(edges);

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

    public List<Edge> getEdges() {
        return edges;
    }
    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    //vrati vsetky PT hrany z this.edges (aj + reset hrany)
    public List<PTEdge> findAllPTEdges(){
        List<PTEdge> pt_edges = new LinkedList<PTEdge>();

        for (Edge current_edge : this.edges){
            if (current_edge instanceof PTEdge){
                pt_edges.add((PTEdge) current_edge);
            }
        }
        return pt_edges;
    }

    //vrati vsetky TP hrany z this.edges
    public List<TPEdge> findAllTPEdges(){
        List<TPEdge> tp_edges = new LinkedList<TPEdge>();

        for (Edge current_edge : this.edges){
            if (current_edge instanceof TPEdge){
                tp_edges.add((TPEdge) current_edge);
            }
        }
        return tp_edges;
    }

    //najde PT hranu (funguje aj na reset hrany) pomocou id vstupneho a vystupneho vrcholu
    public PTEdge findPTEdge(long place_start_id, long transition_end_id){
        List<PTEdge> pt_edges = findAllPTEdges();

        for (Edge current_edge : pt_edges) {
            //rovnake ID zaciatocnych aj koncovych vrcholov
            if (place_start_id == current_edge.getVertex_start().getId() && transition_end_id == current_edge.getVertex_end().getId()) {
                return (PTEdge) current_edge;
            }
        }
        return null;
    }

    //najde TP hranu pomocou id vstupneho a vystupneho vrcholu
    public TPEdge findTPEdge(long transition_start_id, long place_end_id){
        List<TPEdge> tp_edges = findAllTPEdges();

        for (Edge current_edge : tp_edges) {
            //rovnake ID zaciatocnych aj koncovych vrcholov
            if (transition_start_id == current_edge.getVertex_start().getId() && place_end_id == current_edge.getVertex_end().getId()) {
                return (TPEdge) current_edge;
            }
        }
        return null;
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
        this.edges.add(edge);
    }


    //pridanie PT hrany pomocou id vstupneho a vystupneho vrcholu, defaultna nasobnost = 1
    public void addPTEdge(long place_start_id,long transition_end_id){
        Place place_start = this.places.get(place_start_id);
        Transition transition_end = this.transitions.get(transition_end_id);

        this.edges.add(new PTEdge(place_start,transition_end));
    }
    //pridanie TP hrany pomocou id vstupneho a vystupneho vrcholu, defaultna nasobnost = 1
    public void addTPEdge(long transition_start_id,long place_end_id){
        Transition transition_start = this.transitions.get(transition_start_id);
        Place place_end = this.places.get(place_end_id);

        this.edges.add(new TPEdge(transition_start,place_end));
    }
    //pridanie reset hrany pomocou id vstupneho a vystupneho vrcholu, defaultna nasobnost = 1
    public void addResetEdge(long place_start_id,long transition_end_id){
        Place place_start = this.places.get(place_start_id);
        Transition transition_end = this.transitions.get(transition_end_id);

        this.edges.add(new ResetEdge(place_start,transition_end));
    }
    //pridanie PT hrany pomocou id vstupneho a vystupneho vrcholu, vlastna nasobnost
    public void addPTEdge(long place_start_id,long transition_end_id, int weight){
        Place place_start = this.places.get(place_start_id);
        Transition transition_end = this.transitions.get(transition_end_id);

        this.edges.add(new PTEdge(place_start,transition_end, weight));
    }
    //pridanie TP hrany pomocou id vstupneho a vystupneho vrcholu, vlastna nasobnost
    public void addTPEdge(long transition_start_id,long place_end_id, int weight){
        Transition transition_start = this.transitions.get(transition_start_id);
        Place place_end = this.places.get(place_end_id);

        this.edges.add(new TPEdge(transition_start,place_end, weight));
    }

    //odstranenie miesta podla Id
    public void delPlace(long place_id) {
        //vytvori sa docasny zoznam hran, do ktoreho sa skopiruju hrany z this.edges
        //tento zoznam budem prechadzat v cykle, mazat budem z this.edges
        List<Edge>tmp_edges = new LinkedList<>(this.edges);

        for (Edge current_edge: tmp_edges) {
            //vymazu sa vystupne hrany
            if (current_edge.getVertex_start() == this.places.get(place_id)) {
                delPTEdge(place_id, current_edge.getVertex_end().getId());
            }
            //vymazu sa vstupne hrany
            if (current_edge.getVertex_end() == this.places.get(place_id)) {
                delTPEdge(current_edge.getVertex_start().getId(), place_id);
            }
        }
        //vymazanie miesta
        this.places.remove(place_id);
    }

    //odstranenie prechodu podla Id
    public void delTransition(long transition_id) {
        //vytvori sa docasny zoznam hran, do ktoreho sa skopiruju hrany z this.edges
        //tento zoznam budem prechadzat v cykle, mazat budem z this.edges
        List<Edge>tmp_edges = new LinkedList<>(this.edges);

        for (Edge current_edge: tmp_edges){
            //vymazu sa vstupne hrany
            if (current_edge.getVertex_end() == this.transitions.get(transition_id)){
                delPTEdge(current_edge.getVertex_start().getId(),transition_id);
            }
            //vymazu sa vystupne hrany
            if (current_edge.getVertex_start() == this.transitions.get(transition_id)){
                delTPEdge(transition_id,current_edge.getVertex_end().getId());
            }
        }
        //vymazanie prechodu
        this.transitions.remove(transition_id);
    }

    //vymazanie PT hrany - plati aj pre reset hrany
    public void delPTEdge(long place_start_id,long transition_end_id){
        this.edges.remove(findPTEdge(place_start_id,transition_end_id));
    }

    //vymazanie TP hrany
    public void delTPEdge(long transition_start_id,long place_end_id) {
        this.edges.remove(findTPEdge(transition_start_id,place_end_id));
    }

    //spustenie prechodu
    public void fireTransition(long transition_id) throws TransitionNotFirableException, TransitionNotFoundException {
        Transition transition_to_fire = transitions.get(transition_id);
        //ak prechod neexistuje - exception
        if (transition_to_fire == null) {
            throw new TransitionNotFoundException(transition_id);
        }

        List<PTEdge> pt_edges= findAllPTEdges();
        List<TPEdge> tp_edges= findAllTPEdges();

        //ak prechod nie je spustitelny - exception
        if (!transition_to_fire.isFirable(pt_edges)) {
            throw new TransitionNotFirableException(transition_to_fire.getId());
        }

        //konzumuje zo vstupnych miest
        transition_to_fire.consumeTokens(pt_edges);
        //produkuje do vystupnych miest
        transition_to_fire.produceTokens(tp_edges);
    }

    //vypis
    public void printPlaces() {
        System.out.println("MIESTA: ");

        for (Long current_id : this.places.keySet()) {
            System.out.println("Id: " + current_id + "     Nazov: " + this.places.get(current_id).getName() + "     Tokenov: " + this.places.get(current_id).getTokens());
        }
        System.out.println();
    }
    public void printTransitions() {
        List<PTEdge>pt_edges = findAllPTEdges();
        System.out.println("PRECHODY: ");

        for (Long current_id : this.transitions.keySet()) {
            System.out.print("Id: " + current_id + "     Nazov: " + this.transitions.get(current_id).getName());

            //hrany, ktore nie su spustitelne su oznacene "x"
            if (!this.transitions.get(current_id).isFirable(pt_edges)){
                System.out.print("   x");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void printEdges() {
        System.out.println("HRANY: ");

        for (Edge current_edge : edges) {

            if (current_edge instanceof PTEdge) {
                System.out.print("Typ: PTEdge     ");

                if (current_edge instanceof ResetEdge)
                    System.out.println("(" + current_edge.getVertex_start().getName() + ", " + current_edge.getVertex_end().getName() + ")     ResetEdge");

                else
                    System.out.println("(" + current_edge.getVertex_start().getName() + ", " + current_edge.getVertex_end().getName() + ")     Nasobnost: " + current_edge.getWeight());

            }
            else if (current_edge instanceof TPEdge){
                System.out.print("Typ: TPEdge     ");
                System.out.println("(" + current_edge.getVertex_start().getName() + ", " + current_edge.getVertex_end().getName() + ")     Nasobnost: "+current_edge.getWeight());

            }
        }
    }
    public void show() {
        //vypis miest
        this.printPlaces();
        //vypis prechodov
        this.printTransitions();
        //vypis hran
        this.printEdges();
        System.out.println();
    }

    //naplnenie petriho siete podla obrazku v zadani
    public void makePetriNet(){
        this.addTransition(new Transition(1, "T1"));
        this.addTransition(new Transition(2, "T2"));
        this.addTransition(new Transition(3, "T3"));
        this.addTransition(new Transition(4, "T4"));
        this.addTransition(new Transition(5, "T5"));

        this.addPlace(new Place(1, "P1"));
        this.addPlace(new Place(2, "P2"));
        this.addPlace(new Place(3, "P3", 1));
        this.addPlace(new Place(4, "P4",1));
        this.addPlace(new Place(5, "P5", 5));
        this.addPlace(new Place(6, "P6"));
        this.addPlace(new Place(7, "P7"));

        this.addPTEdge(2, 3);
        this.addTPEdge(2, 1, 5);
        this.addPTEdge(3, 4);
        this.addTPEdge(4, 3, 2);
        this.addPTEdge(4, 5);
        this.addResetEdge(5, 5);
        this.addTPEdge(5, 6);
        this.addTPEdge(5, 7);
    }

}