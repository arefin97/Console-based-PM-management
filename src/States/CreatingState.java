package States;

import PM.ConsumableMain;

public class CreatingState implements InputState {
    private ConsumableMain controller;

    public CreatingState(ConsumableMain controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Type the number associated with the option and press enter to create a consumable";
    }

    @Override
    public String getStateInfo() {
        String info = "Select the corresponding number to create that type of consumable\n" +
                "1. Book\n" +
                "2. Movie\n" +
                "3. Series";
        return info;
    }

    @Override
    public String getInputText() {
        return "Enter the corresponding digit: ";
    }

    @Override
    public void processInput(String input) {
        int command;
        try {
            command = Integer.parseInt(input);
        } catch (Exception e) { return;}

        if (command > 3)
            return;

        controller.setCurrentConsumableTypeIndex(command);
        controller.setCurrentState(controller.getCreateStateName());
    }

    @Override
    public void goBack() {
        controller.setCurrentState(controller.getHomeState());
    }

    @Override
    public boolean shouldAddGap() {
        return true;
    }
}
