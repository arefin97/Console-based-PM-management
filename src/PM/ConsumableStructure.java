package PM;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConsumableStructure {
    private List<Consumable> bookList = new ArrayList<>();
    private List<Consumable> seriesList = new ArrayList<>();
    private List<Consumable> movieList = new ArrayList<>();

    public ConsumableStructure() {
        try {
            bookList.add(new Book("book1", 5.4f, getDateFromString("2018-3-6"), null, 15));
            bookList.add(new Book("book2", 3.5f, getDateFromString("2018-2-6"), null, 21));
           
            
            for (Consumable book : bookList) {
                Random rand = new Random();
                int randomDays = rand.nextInt(5) + 1;
                for (int i = 0; i < randomDays; i++) {
                    String day = String.valueOf(rand.nextInt(25) + 1);
                    Date randomDate = getDateFromString("2019-1-" + day);
                    int randomWatchHour = rand.nextInt(20) + 1;
                    book.addConsumptionTimeInHoursWithDay(randomWatchHour, randomDate);
                }
                String day = String.valueOf(rand.nextInt(25) + 1);
                Date randomDate = getDateFromString("2020-3-" + day);
                book.setEndingDate(randomDate);
            }
            movieList.add(new Movie("movie1", 4.5f, getDateFromString("2018-11-26"), null, 21));
            movieList.add(new Movie("movie2", 3.3f, getDateFromString("2018-3-16"), null, 21));

            for (Consumable movie : movieList) {
                Random rand = new Random();
                int randomDays = rand.nextInt(5) + 1;
                for (int i = 0; i < randomDays; i++) {
                    String day = String.valueOf(rand.nextInt(25) + 1);
                    Date randomDate = getDateFromString("2019-1-" + day);
                    int randomWatchHour = rand.nextInt(20) + 1;
                    movie.addConsumptionTimeInHoursWithDay(randomWatchHour, randomDate);
                }

                String day = String.valueOf(rand.nextInt(25) + 1);
                Date randomDate = getDateFromString("2020-3-" + day);
                movie.setEndingDate(randomDate);
            }

            seriesList.add(new Series("series1", 8f, getDateFromString("2018-6-4"), null, 21));
            seriesList.add(new Series("series2", 3f, getDateFromString("2018-2-3"), null, 21));

            for (Consumable series : seriesList) {
                Random rand = new Random();
                int randomDays = rand.nextInt(5) + 1;
                for (int i = 0; i < randomDays; i++) {
                    String day = String.valueOf(rand.nextInt(25) + 1);
                    Date randomDate = getDateFromString("2019-1-" + day);
                    int randomWatchHour = rand.nextInt(20) + 1;
                    series.addConsumptionTimeInHoursWithDay(randomWatchHour, randomDate);
                }

                String day = String.valueOf(rand.nextInt(25) + 1);
                Date randomDate = getDateFromString("2020-3-" + day);
                series.setEndingDate(randomDate);
            }

        } catch (Exception e) {}


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

    public void createBook(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws ParseException,Exception{
        bookList.add(new Book(name, rating, startingDate, endingDate, consumptionTimeInHours));
    }

    public void createSeries(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws ParseException,Exception {
        seriesList.add(new Series(name, rating, startingDate, endingDate, consumptionTimeInHours));
    }

    public void createMovie(String name, Float rating, Date startingDate, Date endingDate, double consumptionTimeInHours) throws ParseException,Exception {
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
