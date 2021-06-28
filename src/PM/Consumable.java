package PM;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Consumable {
    private final String name;
    private Float rating;
    private Date startingDate, endingDate;
    private double consumptionTimeInHours = 0;
    int consumptionDays = 0;
    
    private List<Consumable> bookList = new ArrayList<>();
    private List<Consumable> seriesList = new ArrayList<>();
    private List<Consumable> movieList = new ArrayList<>();

    public Consumable(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws Exception {
        this.name = name;
        this.rating = rating;
        this.startingDate = startingDate;
        addConsumptionTimeInHours(consumptionTimeInHours);
        this.endingDate = endingDate;

    }

    public void setRating(Float rating) throws Exception {
        if (rating > 10 || rating < 0)
            throw new Exception();
        if (isEnded())
            throw new Exception();
        this.rating = rating;
    }

    public void setEndingDate(Date endingDate) throws Exception {
        if (endingDate == null)
            return;
        if (this.endingDate != null)
            throw new Exception();
        this.endingDate = endingDate;
    }

    public int getConsumptionDays() {
        return consumptionDays;
    }

    public void addConsumptionTimeInHours(double hour) throws Exception {
        if (isEnded())
            throw new Exception();
        if (hour < 0)
            throw new Exception();

        consumptionTimeInHours += hour;
        addToTotalConsumptionTimeInHours(hour);
    }

    public double getConsumptionTimeInHours() {
        return consumptionTimeInHours;
    }

    public String getName() {
        return name;
    }

    public Float getRating() {
        return rating;
    }

    public String getStartingDate() {
        String date = null;
        try {
            date = new SimpleDateFormat("yyyy-dd-mm").format(startingDate);
        } catch (NullPointerException e) {}
        return date;
    }

    public String getEndingDate() {
        String date = null;
        try {
            date = new SimpleDateFormat("yyyy-dd-mm").format(endingDate);
        } catch (NullPointerException e) {}
        return date;
    }

    public abstract void addToTotalConsumptionTimeInHours(double hour);
    public abstract void addConsumptionTimeInHoursWithDay(double hour, Date day) throws  Exception;


    private boolean isEnded() {
        if (endingDate == null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder finalString = new StringBuilder(name);
        if (rating != null) {
            finalString.append(", rating: ");
            finalString.append(rating);
        }
        if (startingDate != null) {
            finalString.append(", startingDate: ");
            finalString.append(getStartingDate());
        }
        if (endingDate != null) {
            finalString.append(", endingDate: ");
            finalString.append(getEndingDate());
        }
        if (getConsumptionTimeInHours() != 0) {
            finalString.append(", totalConsumptionTimeInHours: ");
            finalString.append(getConsumptionTimeInHours());
        }
        return finalString.toString();
    }

    

public List<Consumable> getBookList() {
    return bookList;
}

public List<Consumable> getSeriesList() {
    return seriesList;
}

public List<Consumable> getMovieList() {
    return movieList;
}

public void createBook(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws Exception {
    bookList.add(new Book(name, rating, startingDate, endingDate, consumptionTimeInHours));
}

public void createSeries(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws Exception {
    seriesList.add(new Series(name, rating, startingDate, endingDate, consumptionTimeInHours));
}

public void createMovie(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws Exception {
    movieList.add(new Movie(name, rating, startingDate, endingDate, consumptionTimeInHours));
}

public void deleteBook(int index) {
    bookList.remove(index);
}

public void deleteMovie(int index) {
    movieList.remove(index);
}

public void deleteSeries(int index) {
    seriesList.remove(index);
}

public int getBookConsumeDays() {
    return Book.consumptionMap.keySet().size();
}

public int getSeriesConsumeDays() {
    return Series.consumptionMap.keySet().size();
}

public int getMovieConsumeDays() {
    return Movie.consumptionMap.keySet().size();
}

public double getBookConsumeHour() {
    return Book.totalConsumptionInHour;
}

public double getMovieConsumeHour() {
    return Movie.totalConsumptionInHour;
}

public double getSeriesConsumeHour() {
    return Series.totalConsumptionInHour;
}

public double getOverallConsumeHour() {
    return Book.totalConsumptionInHour + Movie.totalConsumptionInHour + Series.totalConsumptionInHour;
}

public int getOverallConsumptionDays() {
    Set<Date> uniqueDays = new HashSet<>();
    uniqueDays.addAll(Book.consumptionMap.keySet());
    uniqueDays.addAll(Movie.consumptionMap.keySet());
    uniqueDays.addAll(Series.consumptionMap.keySet());
    return uniqueDays.size();
}

public float getAverageBookRating() {
    float sum = 0;
    int count = 0;
    for (Consumable book : bookList) {
        if (book.getRating() == null)
            continue;
        sum += book.getRating();
        count++;
    }
    if (sum == 0)
        return 0;
    return sum / (float) count;
}

public float getAverageMovieRating() {
    float sum = 0;
    int count = 0;
    for (Consumable movie : movieList) {
        if (movie.getRating() == null)
            continue;
        sum += movie.getRating();
        count++;
    }
    if (sum == 0)
        return 0;
    return sum / (float) count;
}

public float getAverageSeriesRating() {
    float sum = 0;
    int count = 0;
    for (Consumable series : seriesList) {
        if (series.getRating() == null)
            continue;
        sum += series.getRating();
        count++;
    }
    if (sum == 0)
        return 0;
    return sum / (float) count;
}

public float getAverageConsumableRating() {
    return (getAverageBookRating() + getAverageSeriesRating() + getAverageMovieRating()) / 3f;
}

public int getBookCount() {
    return bookList.size();
}

public int getMovieCount() {
    return movieList.size();
}

public int getSeriesCount() {
    return seriesList.size();
}

public int getConsumableCount() {
    return getBookCount() + getMovieCount() + getSeriesCount();
}

private Date getDateFromString(String date) throws ParseException {
    return new SimpleDateFormat("yyyy-mm-dd").parse(date);
}

}
