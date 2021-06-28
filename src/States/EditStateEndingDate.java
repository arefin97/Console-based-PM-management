package States;

import PM.ConsumableMain;



import java.text.SimpleDateFormat;
import java.util.Date;

public class EditStateEndingDate implements InputState{
    private ConsumableMain controller;

    public EditStateEndingDate(ConsumableMain controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Enter the new date";
    }

    @Override
    public String getStateInfo() {
        return "";
    }

    @Override
    public String getInputText() {
        return "ending date(yyyy-mm-dd): ";
    }

    @Override
    public void processInput(String input) {
        try {
            Date endingDate = new SimpleDateFormat("yyyy-mm-dd").parse(input);
            controller.setConsumableEndingDate(endingDate);
            controller.setCurrentState(controller.getEditParameterState());
        } catch (Exception p) {
            p.printStackTrace();
            goBack();
            return;
        } 
    }

    @Override
    public void goBack() {
        controller.setCurrentState(controller.getEditParameterState());
    }

    @Override
    public boolean shouldAddGap() {
        return false;
    }
}
