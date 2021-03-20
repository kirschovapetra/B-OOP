package buttons;

import listeners.CrossButtonListener;
import listeners.LineButtonListener;

import java.awt.*;

public class LineButton extends Button {
    private LineButtonListener lineButtonListener;

    public LineButton(LineButtonListener lineButtonListener) throws HeadlessException,IllegalArgumentException {
        super("Usecka");
        if (lineButtonListener==null)
            throw new IllegalArgumentException("treba zadat listener");

        this.lineButtonListener = lineButtonListener;
    }

    public LineButtonListener getLineButtonListener() {
        return lineButtonListener;
    }

    public void setLineButtonListener(LineButtonListener lineButtonListener) {
        this.lineButtonListener = lineButtonListener;
    }
}
