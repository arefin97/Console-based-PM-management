package States;

import PM.ConsumableMain;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateStateEndingDate implements InputState{
    private ConsumableMain controller;

    public CreateStateEndingDate(ConsumableMain controller) {
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
        return "ending date(yyyy-mm-dd): ";
    }

    @Override
    public void processInput(String input) {
        if (input.equals(""))
            controller.setEndingDate(null);
        else {
            try {
                Date date = new SimpleDateFormat("yyyy-mm-dd").parse(input);
                controller.setEndingDate(date);
            } catch (Exception e) {
                controller.setEndingDate(null);
            }
        }
        controller.setCurrentState(controller.getCreateStateConsumptionTime());
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
