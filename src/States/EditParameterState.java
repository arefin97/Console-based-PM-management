package States;

import PM.ConsumableMain;

public class EditParameterState implements InputState {
    private ConsumableMain controller;

    public EditParameterState(ConsumableMain controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {

        return "Select which parameter you want to edit";
    }

    @Override
    public String getStateInfo() {
        String info = "1. Edit rating\n" +
                "2. Edit ending date\n" +
                "3. Add consumption time";
        return info;
    }

    @Override
    public String getInputText() {
        return "Enter number: ";
    }

    @Override
    public void processInput(String input) {
        int index;
        try {
            index = Integer.parseInt(input);
        } catch (Exception e) {
            return;
        }
        switch (index) {
            case 1:
                controller.setCurrentState(controller.getEditStateRating());
                break;
            case 2:
                controller.setCurrentState(controller.getEditStateEndingDate());
                break;
            case 3:
                controller.setCurrentState(controller.getEditStateTime());
                break;
        }
    }

    @Override
    public void goBack() {
        controller.setCurrentState(controller.getEditListState());
    }


    @Override
    public boolean shouldAddGap() {
        return true;
    }
}
