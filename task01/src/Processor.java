import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Processor {
    
    HashMap<String, Category> mapOfCategories = new HashMap<>();
    HashMap<String, Category> cleanedMap = new HashMap<>();

    public void parse(String line) {
        line = line.trim().toUpperCase();
        // System.out.println("Current line: " + line);
        String[] fields = line.split(",");

        for (int i = 0; i < fields.length; i++) {
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
    }
    
    public void clean() {
        // HashMap<String, Category> cleanedMap = new HashMap<>();
        
        for (String categoryName : mapOfCategories.keySet()) {
            Category currentCategory = mapOfCategories.get(categoryName);
            LinkedList<App> appList = currentCategory.getAppList();
            cleanedMap.put(categoryName, new Category());

            for (App app : appList) {
                // System.out.println(a.getRating());
                if (!"NAN".equals(app.getRating())) {
                    cleanedMap.get(categoryName).addToList(app);
                    cleanedMap.get(categoryName).addInvalidCount();
                }
            }
        }

        System.out.println(cleanedMap);
    }


}
