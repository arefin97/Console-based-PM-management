package States;

import PM.ConsumableMain;
public class CreateStateName implements InputState{
    private ConsumableMain controller;

    public CreateStateName(ConsumableMain controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Creating new " + controller.getConsumableType();
    }

    @Override
    public String getStateInfo() {
        return "";
    }

    @Override
    public String getInputText() {
        return "name: ";
    }

    @Override
    public void processInput(String input) {
        controller.setName(input);
        controller.setCurrentState(controller.getCreateStateRating());
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
