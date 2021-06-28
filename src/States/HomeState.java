package States;

import PM.ConsumableMain;

public class HomeState implements InputState{
    private ConsumableMain controller;

    public HomeState(ConsumableMain controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Type the number associated with the option and press enter to continue";
    }

    @Override
    public String getStateInfo() {
        String info = "1. Create a consumable\n" +
                "2. Edit a consumable\n" +
                "3. Delete a consumable\n" +
                "4. See consumable list\n" +
                "5. See overall info";
        return info;
    }

    @Override
    public String getInputText() {
        return "Enter the corresponding digit: ";
    }

    @Override
    public void processInput(String input) {
        if (input.equals("back")) {
            goBack();
            return;
        }
        if (input.equals(""))
            return;
        int command;
        try {
            command = Integer.parseInt(input);
        } catch (Exception e) {return;}
        switch (command) {
            case 1:
                controller.setCurrentState(controller.getCreatingState());
                break;
            case 2:
                controller.setCurrentState(controller.getEditState());
                break;
            case 3:
                controller.setCurrentState(controller.getDeleteState());
                break;
            case 4:
                controller.setCurrentState(controller.getViewingState());
                break;
            case 5:
                controller.setCurrentState(controller.getOverallInfoState());
        }
    }

    @Override
    public void goBack() { }

    @Override
    public boolean shouldAddGap() {
        return true;
    }
}
