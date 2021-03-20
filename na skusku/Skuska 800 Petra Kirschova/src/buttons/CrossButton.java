package buttons;

import listeners.CrossButtonListener;

import java.awt.*;

public class CrossButton extends Button {
    private CrossButtonListener crossButtonListener;

    public CrossButton(CrossButtonListener crossButtonListener) throws HeadlessException,IllegalArgumentException {
        super("Plus");
        if (crossButtonListener==null)
            throw new IllegalArgumentException("treba zadat listener");
        this.crossButtonListener = crossButtonListener;
    }

    public CrossButtonListener getCrossButtonListener() {
        return crossButtonListener;
    }

    public void setCrossButtonListener(CrossButtonListener crossButtonListener) {
        this.crossButtonListener = crossButtonListener;
    }
}
