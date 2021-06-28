package States;

import PM.Consumable;
import PM.ConsumableMain;


public class ViewingConsumableState implements InputState {
    private ConsumableMain controller;

    public ViewingConsumableState(ConsumableMain controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        controller.getPrinter().printTitles(controller.getConsumableType() + " Name", "Consumption Days", "Consumption Hours", "Rating", "Starting Date", "Ending Date");
        return "";
    }

    @Override
    public String getStateInfo() {
        Consumable consumable = controller.getCurrentConsumable();
        controller.getPrinter().printValuesWithoutLowerBoundary(consumable.getName(), consumable.getConsumptionDays(), consumable.getConsumptionTimeInHours(), consumable.getRating(), consumable.getStartingDate(), consumable.getEndingDate());
        controller.getPrinter().printUpDownBoundary(6);
        return "";
    }

    @Override
    public String getInputText() {
//        controller.getPrinter().printTitles("Type Name", "Consumption Days", "Consumption Hours");
        return "Type back or home and press enter: ";
    }

    @Override
    public void processInput(String input) {

    }

    @Override
    public void goBack() {
        controller.setCurrentState(controller.getViewingListState());
    }

    @Override
    public boolean shouldAddGap() {
        return true;
    }
}
