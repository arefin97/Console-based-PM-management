package States;

public interface InputState {
    String getHeaderInfo();
    String getStateInfo();
    String getInputText();
    void processInput(String input);
    void goBack();
    boolean shouldAddGap();
}
