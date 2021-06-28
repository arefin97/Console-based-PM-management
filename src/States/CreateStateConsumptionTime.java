package States;


import PM.ConsumableMain;


public class CreateStateConsumptionTime implements InputState {
    private final ConsumableMain controller;

    public CreateStateConsumptionTime(ConsumableMain controller) {
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
        return "consumption time(hour): ";
    }

    @Override
    public void processInput(String input) {
        if (input.equals(""))
            controller.setConsumptionTimeInHour(0d);
        else
            controller.setConsumptionTimeInHour(Double.parseDouble(input));

        try {
            controller.createConsumable();
            controller.setCurrentState(controller.getHomeState());
        }
        catch (Exception e) {
            e.printStackTrace();
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
