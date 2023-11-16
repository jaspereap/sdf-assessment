import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                processor.parse(line);
            }
            processor.clean();

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
