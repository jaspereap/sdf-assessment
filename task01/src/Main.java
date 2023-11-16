import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Requires CSV file name as parameter");
            return;
        }
        String filename = "task01/" + args[0];
        Processor processor = new Processor();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            
            String line = br.readLine(); // skip header line
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                processor.parse(line);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        // remove invalid ratings
        HashMap<String, Category> cleanedMap = processor.clean();

        // print each category
        for (String CATEGORY : cleanedMap.keySet()) {
            Category currentCategory = cleanedMap.get(CATEGORY);
            System.out.println("Category: " + CATEGORY);
            System.out.println("  Highest: " + currentCategory.getHighestRating().get(0) + ", "+ currentCategory.getHighestRating().get(1));
            System.out.println("  Lowest: " + currentCategory.getLowestRating().get(0) + ", "+ currentCategory.getLowestRating().get(1));
            System.out.println("  Average: " + currentCategory.getAverageRating());
            System.out.println("  Count: " + currentCategory.getCount());
            System.out.println("  Discarded: " + currentCategory.getDiscarded());
        }
        System.out.println("Total lines in file: " + processor.lineCount);

    }
}
