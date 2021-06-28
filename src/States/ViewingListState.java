package States;

import PM.Consumable;
import PM.ConsumableMain;

import java.util.List;

public class ViewingListState implements InputState {
    private ConsumableMain controller;

    public ViewingListState(ConsumableMain controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        controller.getPrinter().printTitles(controller.getConsumableType() + " Name", "Consumption Days", "Consumption Hours", "Rating");
        return "";
    }

    @Override
    public String getStateInfo() {
        List<Consumable> consumableList = controller.getConsumableList();
        int counter = 1;
        for (Consumable consumable : consumableList) {
            controller.getPrinter().printValuesWithoutLowerBoundary(counter++ + ". " +consumable.getName(), consumable.getConsumptionDays(), consumable.getConsumptionTimeInHours(), consumable.getRating());
        }
        controller.getPrinter().printUpDownBoundary(4);
        return "";
    }

    @Override
    public String getInputText() {
//        controller.getPrinter().printTitles("Type Name", "Consumption Days", "Consumption Hours");
        return "Select a " + controller.getConsumableType() + " to see further details: ";
    }

    @Override
    public void processInput(String input) {
        int index = Integer.parseInt(input);
        controller.setCurrentConsumable(index - 1);
        controller.setCurrentState(controller.getViewingConsumableState());
    }

    @Override
    public void goBack() {
        controller.setCurrentState(controller.getViewingState());
    }

    @Override
    public boolean shouldAddGap() {
        return true;
    }
}
