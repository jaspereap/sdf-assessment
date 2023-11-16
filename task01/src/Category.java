import java.util.ArrayList;
import java.util.LinkedList;

public class Category {
    LinkedList<App> appList = new LinkedList<>();
    public int invalidCount = 0;
    
    public void addToList(App app) {
        // System.out.println("Adding " + app.getName() + " to app list");
        appList.add(app);
    }

    public float getAverageRating() {
        float avgRating = 0;
        float sumRating = 0;
        for (App app : appList) {
            sumRating += Float.parseFloat(app.getRating());
        }
        avgRating = sumRating / appList.size();
        return avgRating;
    }

    public ArrayList<String> getHighestRating() {
        ArrayList<String> highestRating = new ArrayList<>();
        App highestApp = null;
        float rating = 0;
        for (App app : appList) {
            if (Float.parseFloat(app.getRating()) > rating) {
                rating = Float.parseFloat(app.getRating());
                highestApp = app;
            }
        }
        highestRating.add(highestApp.getName());
        highestRating.add(highestApp.getRating());
        return highestRating;
    }

    public int getCount() {
        return appList.size();
    }

    public int getDiscarded() {
        return invalidCount;
    }
    public ArrayList<String> getLowestRating() {
        ArrayList<String> lowestRating = new ArrayList<>();
        App lowestApp = null;
        float rating = 100;
        for (App app : appList) {
            if (Float.parseFloat(app.getRating()) < rating) {
                rating = Float.parseFloat(app.getRating());
                lowestApp = app;
            }
        }
        lowestRating.add(lowestApp.getName());
        lowestRating.add(lowestApp.getRating());
        return lowestRating;
    }

    public LinkedList<App> getAppList() {
        return appList;
    }

    public void addInvalidCount() {
        invalidCount++;
    }

    public void getInfo() {
        System.out.println("Invalid count: " + invalidCount);
        for (App a : appList) {
            String name = a.getName();
            System.out.println(name);
        }
    }
    
}
