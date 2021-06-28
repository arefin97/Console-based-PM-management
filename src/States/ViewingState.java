package States;

import PM.ConsumableMain;

public class ViewingState implements InputState {
    private ConsumableMain controller;

    public ViewingState(ConsumableMain controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        controller.getPrinter().printTitles("Type Name", "Consumption Days", "Consumption Hours", "Count");
        return "";
    }

    @Override
    public String getStateInfo() {

        controller.getPrinter().printValues("1. Book", controller.getModel().getBookConsumeDays(), controller.getModel().getBookConsumeHour(), controller.getModel().getBookCount());
        controller.getPrinter().printValues("2. Movie", controller.getModel().getMovieConsumeDays(), controller.getModel().getMovieConsumeHour(), controller.getModel().getMovieCount());
        controller.getPrinter().printValues("3. Series", controller.getModel().getSeriesConsumeDays(), controller.getModel().getSeriesConsumeHour(), controller.getModel().getSeriesCount());
        return "";
    }

    @Override
    public String getInputText() {
//        controller.getPrinter().printTitles("Type Name", "Consumption Days", "Consumption Hours");
        return "Select a consumable type to see further details: ";
    }

    @Override
    public void processInput(String input) {

        int command = Integer.parseInt(input);
        controller.setCurrentConsumableTypeIndex(command);
        controller.setCurrentState(controller.getViewingListState());
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
