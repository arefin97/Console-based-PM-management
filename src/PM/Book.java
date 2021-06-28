package PM;


import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Book extends Consumable {
    static double totalConsumptionInHour = 0;
    static Map<Date, Double> consumptionMap = new HashMap<>();

    public Book(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws ParseException,Exception {
        super(name, rating, startingDate, endingDate, consumptionTimeInHours);
    }

    @Override
    public void addConsumptionTimeInHoursWithDay(double hour, Date day) throws Exception {
        addConsumptionTimeInHours(hour);
        if (day == null)
            return;

        Double prevTime = consumptionMap.get(day);
        if (prevTime == null) {
            consumptionDays++;
            consumptionMap.put(day, prevTime);
        }
        else
            consumptionMap.put(day, prevTime + hour);
    }

    @Override
    public void addToTotalConsumptionTimeInHours(double hour) {
        totalConsumptionInHour += hour;
    }

    @Override
    public String toString() {
        return "Book: " + super.toString();
    }
}
