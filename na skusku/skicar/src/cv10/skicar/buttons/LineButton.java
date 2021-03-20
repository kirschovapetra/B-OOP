package cv10.skicar.buttons;

import cv10.skicar.listeners.LineAdapter;

import java.awt.*;

public class LineButton extends Button {
    private LineAdapter lineAdapter;

    public LineButton(String label, LineAdapter lineAdapter) throws HeadlessException {
        super(label);
        this.lineAdapter = lineAdapter;
    }

    public LineAdapter getLineAdapter() {
        return lineAdapter;
    }

    public void setLineAdapter(LineAdapter lineAdapter) {
        this.lineAdapter = lineAdapter;
    }
}
