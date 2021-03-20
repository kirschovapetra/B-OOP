package sk.stuba.fei.oop.generated;
import sk.stuba.fei.oop.petrinet.*;

public class PetriNetTransformer {
    private PetriNet petriNet = new PetriNet();

    //getter, setter
    public PetriNet getPetriNet() {
        return petriNet;
    }
    public void setPetriNet(PetriNet petriNet) {
        this.petriNet = petriNet;
    }

    public void transform(Document document) {
        try {
            transformPlaces(document);
            transformTransitions(document);
            transformEdges(document);
        }
        catch(IllegalArgumentException exception){
            System.out.println(exception);
        }
        catch(UnsupportedOperationException exception){
            System.out.println(exception);
        }
    }

    //transformacia miest
    public void transformPlaces(Document document) throws IllegalArgumentException{
        //ku kazdemu Place v Documente sa vytvori nove Place z sk.stuba.fei.oop.petrinet
        for (Place currentGeneratedPlace : document.getPlace()) {

            long currentId = currentGeneratedPlace.getId();
            String currentName = currentGeneratedPlace.getLabel();
            int currentTokens = currentGeneratedPlace.getTokens();

            petriNet.addPlace(new sk.stuba.fei.oop.petrinet.Place(currentId, currentName, currentTokens));
        }
    }

    //transformacia prechodov
    public void transformTransitions(Document document) throws IllegalArgumentException{
        //ku kazdemu Transition v Documente sa vytvori nove Transition z sk.stuba.fei.oop.petrinet
        for (Transition currentGeneratedTransition : document.getTransition()) {

            long currentId = currentGeneratedTransition.getId();
            String currentName = currentGeneratedTransition.getLabel();

            petriNet.addTransition(new sk.stuba.fei.oop.petrinet.Transition(currentId, currentName));
        }
    }

    //transformacia hran
    public void transformEdges(Document document) throws IllegalArgumentException,UnsupportedOperationException{
        //ku kazdej Arc v Documente sa vytvori nova Edge z sk.stuba.fei.oop.petrinet

        for (Arc currentArc : document.getArc()) {

            long sourceId = currentArc.getSourceId();
            long destId = currentArc.getDestinationId();
            long currentId = currentArc.getId();
            int currentWeight = currentArc.getMultiplicity();

            //reset hrana: Place -> Transition
            if (currentArc.getType() == ArcType.RESET ) {
                sk.stuba.fei.oop.petrinet.Place sourcePlace = petriNet.getPlaces().get(sourceId);
                sk.stuba.fei.oop.petrinet.Transition destTransition = petriNet.getTransitions().get(destId);

                petriNet.addEdge(new ResetEdge(currentId,sourcePlace,destTransition));
            }

            else if (currentArc.getType()== ArcType.REGULAR ) {

                //v .xml su id jedinecne v ramci celej siete, takze podla id vieme urcit aj typ vrcholu

                //PT hrana: Place -> Transition
                if (petriNet.getPlaces().containsKey(sourceId)) { //sourceId sa nachadza medzi miestami => PT
                    sk.stuba.fei.oop.petrinet.Place sourcePlace = petriNet.getPlaces().get(sourceId);
                    sk.stuba.fei.oop.petrinet.Transition destTransition = petriNet.getTransitions().get(destId);

                    petriNet.addEdge(new PTEdge(currentId,sourcePlace,destTransition, currentWeight));
                }
                //TP hrana: Transition -> Place
                else if (petriNet.getTransitions().containsKey(sourceId)) { //sourceId sa nachadza medzi prechodmi => TP
                    sk.stuba.fei.oop.petrinet.Transition source = petriNet.getTransitions().get(sourceId);
                    sk.stuba.fei.oop.petrinet.Place dest = petriNet.getPlaces().get(destId);
                    petriNet.addEdge(new TPEdge(currentId,source,dest, currentWeight));
                }
            }
        }
    }
}
