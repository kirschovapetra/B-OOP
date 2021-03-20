package sk.stuba.fei.oop.buttons;

import sk.stuba.fei.oop.mouseAdapters.SimulationModeAdapter;

import java.awt.*;

public class SimulationButton extends Button{
    private SimulationModeAdapter simulationModeAdapter;
    public SimulationButton() throws HeadlessException {
    }
    public SimulationButton(String label) throws HeadlessException {
        super(label);
    }
    public SimulationButton(SimulationModeAdapter simulationModeAdapter) throws HeadlessException {
        this.simulationModeAdapter = simulationModeAdapter;
    }
    public SimulationButton(String label, SimulationModeAdapter simulationModeAdapter) throws HeadlessException {
        super(label);
        this.simulationModeAdapter = simulationModeAdapter;
    }

    public SimulationModeAdapter getSimulationModeAdapter() {
        return simulationModeAdapter;
    }

    public void setSimulationModeAdapter(SimulationModeAdapter simulationModeAdapter) {
        this.simulationModeAdapter = simulationModeAdapter;
    }
}
