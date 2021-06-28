package States;

import PM.ConsumableMain;
public class CreateStateRating implements InputState{
    private ConsumableMain controller;

    public CreateStateRating(ConsumableMain controller) {
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
        return "rating: ";
    }

    @Override
    public void processInput(String input) {
        try {
            controller.setRating(Float.parseFloat(input));
        } catch (Exception e) {};
        controller.setCurrentState(controller.getCreateStateStartingDate());

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
