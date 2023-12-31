import java.util.HashMap;
import java.util.LinkedList;

public class Processor {
    
    HashMap<String, Category> mapOfCategories = new HashMap<>();
    HashMap<String, Category> cleanedMap = new HashMap<>();
    int lineCount = 0;

    public void parse(String line) {
        line = line.trim().toUpperCase();
        lineCount++;
        String[] fields = line.split(",");

        String category = fields[FieldConstants.CATEGORY];
        String name = fields[FieldConstants.NAME];
        String rating = fields[FieldConstants.RATING];
        App app = new App(name, category, rating);

        if (!mapOfCategories.containsKey(category)) {
            Category newCat = new Category();
            newCat.addToList(app);
            mapOfCategories.put(category, newCat);
        } else if (mapOfCategories.containsKey(category)) {
            mapOfCategories.get(category).addToList(app);
        }
    }
    
    // Remove NAN lines, accumulate count to Category
    public HashMap<String, Category> clean() {
        for (String categoryName : mapOfCategories.keySet()) {
            Category currentCategory = mapOfCategories.get(categoryName);
            LinkedList<App> appList = currentCategory.getAppList();
            cleanedMap.put(categoryName, new Category());

            for (App app : appList) {
                if (!"NAN".equals(app.getRating())) {
                    cleanedMap.get(categoryName).addToList(app);
                } else {
                    cleanedMap.get(categoryName).addInvalidCount();
                }
            }
        }
        return cleanedMap;
    }

    public HashMap<String, Category> getMapOfCategories() {
        return mapOfCategories;
    }

    

}
