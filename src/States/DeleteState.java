package States;
import PM.ConsumableMain;

public class DeleteState implements InputState {
    private ConsumableMain controller;

    public DeleteState(ConsumableMain controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Select consumable type";
    }

    @Override
    public String getStateInfo() {
        return "1. Book\n" +
                "2. Movie\n" +
                "3. Series";
    }

    @Override
    public String getInputText() {
        return "Enter number: ";
    }

    @Override
    public void processInput(String input) {
        int index = Integer.parseInt(input);
        controller.setCurrentConsumableTypeIndex(index);
        controller.setCurrentState(controller.getDeleteListState());
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
