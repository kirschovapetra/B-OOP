package sk.stuba.fei.oop.gui;

public enum ButtonAction {
    ADD_PLACE("addPlaceButton"),
    ADD_TRANSITION("addTransitionButton"),
    ADD_REGULAR_EDGE("addRegularEdgeButton"),
    ADD_RESET_EDGE("addResetEdgeButton"),
    REMOVE("removeButton"),
    SIMULATION("simulationButton");

    private final String value;

    ButtonAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
