package buttons;

import listeners.ChangeColorListener;

import java.awt.*;

public class ChangeColorButton extends Button {
    private ChangeColorListener changeColorListener;

    public ChangeColorButton(ChangeColorListener changeColorListener) throws HeadlessException,IllegalArgumentException {
        super("Zmen farbu");
        if (changeColorListener == null){
            throw new IllegalArgumentException("treba zadat listener");
        }
        this.changeColorListener = changeColorListener;
    }


    public ChangeColorListener getChangeColorListener() {
        return changeColorListener;
    }

    public void setChangeColorListener(ChangeColorListener changeColorListener) {
        this.changeColorListener = changeColorListener;
    }
}
