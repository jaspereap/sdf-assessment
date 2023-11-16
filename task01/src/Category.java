import java.util.LinkedList;

public class Category {
    LinkedList<App> appList = new LinkedList<>();
    public int invalidCount = 0;
    
    public void addToList(App app) {
        appList.add(app);
    }

    public void getAverageRating() {

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
