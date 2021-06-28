package States;
import PM.ConsumableMain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateStateStartingDate implements InputState{
    private ConsumableMain controller;

    public CreateStateStartingDate(ConsumableMain controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "";
    }

    @Override
    public String getStateInfo() {
        return "";
    }

    @Override
    public String getInputText() {
        return "starting date(yyyy-mm-dd): ";
    }

    @Override
    public void processInput(String input) {
        if (input.equals(""))
            controller.setStartingDate(null);
        else {
            try {
                Date date = new SimpleDateFormat("yyyy-mm-dd").parse(input);
                controller.setStartingDate(date);
            } catch (Exception e) {
                controller.setStartingDate(null);
            }
        }
        controller.setCurrentState(controller.getCreateStateEndingDate());
    }

    @Override
    public void goBack() {
        controller.setCurrentState(controller.getHomeState());
    }

    @Override
    public boolean shouldAddGap() {
        return false;
    }
}
