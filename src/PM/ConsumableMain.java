package PM;


import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.*;

import States.*;

public class ConsumableMain {
    private final Output printer;
    private final ConsumableStructure model;
    private InputState currentState;
    private final InputState homeState,creatingState, createStateName, createStateRating, createStateStartingDate, createStateEndingDate, createStateConsumptionTime,editState, editListState, editParameterState, editStateRating, editStateTime, editStateEndingDate, editStateTimeDate,deleteState, deleteListState,viewingState, viewingListState, viewingConsumableState,overallInfoState;
 

    private String name;
    private Date startingDate, endingDate;
    private Float rating;
    private Double consumptionTimeInHour;

    //assign index
    private static final int BOOK = 1, MOVIE = 2, SERIES = 3;
    private int currentConsumableTypeIndex = 1;
    private Consumable currentConsumable;


    public ConsumableMain(ConsumableStructure model, Output printer) {
        this.model = model;
        this.printer = printer;
        homeState = new HomeState(this);
        creatingState = new CreatingState(this);
        createStateName = new CreateStateName(this);
        editStateRating = new EditStateRating(this);
        editStateTime = new EditStateTime(this);
        editStateTimeDate = new EditStateTimeDate(this);
        editStateEndingDate = new EditStateEndingDate(this);
        deleteState = new DeleteState(this);
        deleteListState = new DeleteListState(this);
        viewingState = new ViewingState(this);
        viewingListState = new ViewingListState(this);
        viewingConsumableState = new ViewingConsumableState(this);
        overallInfoState = new OverallInfoState(this);
        createStateRating = new CreateStateRating(this);
        createStateStartingDate = new CreateStateStartingDate(this);
        createStateEndingDate = new CreateStateEndingDate(this);
        createStateConsumptionTime = new CreateStateConsumptionTime(this);
        editState = new EditState(this);
        editListState = new EditListState(this);
        editParameterState = new EditParameterState(this);
        
        
        currentState = homeState;

        
    }

    public String getConsumableType() {
        if (currentConsumableTypeIndex == 1)
            return "Book";
        if (currentConsumableTypeIndex == 2)
            return "Movie";
        if (currentConsumableTypeIndex == 3)
            return "Series";
        return "error";
    }

    public Output getPrinter() {
        return printer;
    }

    public ConsumableStructure getModel() {
        return model;
    }

    public Consumable getCurrentConsumable() {
        return currentConsumable;
    }

    public List<Consumable> getConsumableList() {
        if (currentConsumableTypeIndex == BOOK)
            return model.getBookList();
        if (currentConsumableTypeIndex == MOVIE)
            return model.getMovieList();
        return model.getSeriesList();
    }

    public InputState getHomeState() {
        return homeState;
    }

    public InputState getCreatingState() {
        return creatingState;
    }

    public InputState getCreateStateName() {
        return createStateName;
    }

    public InputState getCreateStateRating() {
        return createStateRating;
    }

    public InputState getCreateStateStartingDate() {
        return createStateStartingDate;
    }

    public InputState getCreateStateEndingDate() {
        return createStateEndingDate;
    }

    public InputState getCreateStateConsumptionTime() {
        return createStateConsumptionTime;
    }

    public InputState getEditState() {
        return editState;
    }

    public InputState getEditListState() {
        return editListState;
    }

    public InputState getEditParameterState() {
        return editParameterState;
    }

    public InputState getEditStateRating() {
        return editStateRating;
    }

    public InputState getEditStateTime() {
        return editStateTime;
    }

    public InputState getEditStateEndingDate() {
        return editStateEndingDate;
    }

    public InputState getEditStateTimeDate() {
        return editStateTimeDate;
    }

    public InputState getDeleteState() {
        return deleteState;
    }

    public InputState getDeleteListState() {
        return deleteListState;
    }

    public InputState getViewingState() {
        return viewingState;
    }

    public InputState getViewingListState() {
        return viewingListState;
    }

    public InputState getViewingConsumableState() {
        return viewingConsumableState;
    }

    public InputState getOverallInfoState() {
        return overallInfoState;
    }

    public void setCurrentState(InputState currentState) {
        this.currentState = currentState;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setConsumptionTimeInHour(Double consumptionTimeInHour) {
        this.consumptionTimeInHour = consumptionTimeInHour;
    }

    public void setCurrentConsumableTypeIndex(int currentConsumableTypeIndex) {
        this.currentConsumableTypeIndex = currentConsumableTypeIndex;
    }

    public void setCurrentConsumable(int index) {
        if (currentConsumableTypeIndex == MOVIE) {
            currentConsumable = model.getMovieList().get(index);
        }
        else if (currentConsumableTypeIndex == BOOK) {
            currentConsumable = model.getBookList().get(index);
        }
        else if (currentConsumableTypeIndex == SERIES) {
            currentConsumable = model.getSeriesList().get(index);
        }
    }



    public void setConsumableRating(Float rating) throws Exception {
        currentConsumable.setRating(rating);
        printer.displayTextWithNewLine("edited successfully");
    }

    public void setConsumableEndingDate(Date date) throws Exception {
        currentConsumable.setEndingDate(date);
        printer.displayTextWithNewLine("edited successfully");
    }

    public void addConsumableTimeInHour(Date date) throws Exception{
        if (consumptionTimeInHour == null)
            return;
        currentConsumable.addConsumptionTimeInHoursWithDay(consumptionTimeInHour, date);
        printer.displayTextWithNewLine("edited successfully");
    }



    public void createConsumable() throws Exception {
        String consumableType = "";
        if (currentConsumableTypeIndex == BOOK) {
            model.createBook(name, rating, startingDate, endingDate, consumptionTimeInHour);
            consumableType = "Book";
        }
        else if (currentConsumableTypeIndex == MOVIE) {
            model.createMovie(name, rating, startingDate, endingDate, consumptionTimeInHour);
            consumableType = "Movie";
        }
        else if (currentConsumableTypeIndex == SERIES) {
            model.createSeries(name, rating, startingDate, endingDate, consumptionTimeInHour);
            consumableType = "Series";
        }
        printer.displayNewLine();
        printer.displayTextWithNewLine(consumableType + " created successfully");
        printer.displayNewLine();
    }

    public void deleteConsumable(int index) {
        String consumableType = "";
        if (currentConsumableTypeIndex == BOOK) {
            model.deleteBook(index);
            consumableType = "Book";
        }
        else if (currentConsumableTypeIndex == MOVIE) {
            model.deleteMovie(index);
            consumableType = "Movie";
        }
        else if (currentConsumableTypeIndex == SERIES) {
            model.deleteSeries(index);
            consumableType = "Series";
        }
        printer.displayNewLine();
        printer.displayTextWithNewLine(consumableType + " deleted successfully");
        printer.displayNewLine();
    }

    public static void main(String[] args) {
        ConsumableStructure model = new ConsumableStructure();
        Output printer = new Output();
        ConsumableMain controller = new ConsumableMain(model, printer);
        controller.start();
    }


    public void start() {
        System.out.println();
        printer.printInstructions();
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            if (input.equals("exit"))
                break;

            String headerText = currentState.getHeaderInfo();
            String infoText = currentState.getStateInfo();
            String inputText = currentState.getInputText();

            if (!headerText.equals("")) {
                printer.displayTextWithNewLine(headerText);
                printer.displayHorizontalLine();
            }
            if (!infoText.equals("")) {
                printer.displayTextWithNewLine(infoText);
                printer.displayHorizontalLine();
            }
            if (!inputText.equals("")) {
                printer.displayText(inputText);
            }

            input = scanner.nextLine();
            if (currentState.shouldAddGap())
                printer.addGap();

            if (input.equals("home")) {
                printer.displayNewLine();
                currentState = homeState;
                continue;
            }

            if (input.equals("back")) {
                printer.displayNewLine();
                currentState.goBack();
                continue;
            }

            currentState.processInput(input);
        }
    }
}
