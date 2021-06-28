package States;

import PM.ConsumableMain;
import PM.ConsumableStructure;

public class OverallInfoState implements InputState{
    private ConsumableMain controller;

    public OverallInfoState(ConsumableMain controller) {
        this.controller = controller;
    }

    @Override
    public String getHeaderInfo() {
        return "Productivity management overall info.";
    }

    @Override
    public String getStateInfo() {
        ConsumableStructure model = controller.getModel();
        String info = "";

        String que1 = "1. The total consumption time in hours across all types\n";
        String ans1 = "Ans: " + model.getOverallConsumeHour() + "\n\n";
        info += que1 + ans1;

        String que2 = "2. Individual consumption time in hours of each type\n";
        String ans2 = String.format("Ans: Book - %f, Movie - %f, Series - %f\n\n", model.getBookConsumeHour(), model.getMovieConsumeHour(), model.getSeriesConsumeHour());
        info += que2 + ans2;

        String que3 = "3. The total days of consumption across all types\n";
        String ans3 = String.format("Ans: %d\n\n", model.getOverallConsumptionDays());
        info += que3 + ans3;

        String que4 = "4. Individual days of consumption of each type\n";
        String ans4 = String.format("Ans: Book - %d, Movie - %d, Series - %d\n\n", model.getBookConsumeDays(), model.getMovieConsumeDays(), model.getSeriesConsumeDays());
        info += que4 + ans4;

        String que5 = "5. Average rating across all types\n";
        String ans5 = "Ans: " + model.getAverageConsumableRating() + "\n\n";
        info += que5 + ans5;

        String que6 = "6. Average individual rating of each type\n";
        String ans6 = String.format("Ans: Book - %f, Movie - %f, Series - %f\n\n", model.getAverageBookRating(), model.getAverageMovieRating(), model.getAverageSeriesRating());
        info += que6 + ans6;

        String que7 = "7. Total number of consumable across all types\n";
        String ans7 = "Ans: " + model.getConsumableCount() + "\n\n";
        info += que7 + ans7;

        String que8 = "8. Individual number of consumable of each type\n";
        String ans8 = String.format("Ans: Book - %d, Movie - %d, Series - %d\n\n", model.getBookCount(), model.getMovieCount(), model.getSeriesCount());
        info += que8 + ans8;
        return info;
    }

    @Override
    public String getInputText() {
        return "Type back or home and press enter to continue: ";
    }

    @Override
    public void processInput(String input) {
        if (input.equals("back")) {
            goBack();
            return;
        }
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
