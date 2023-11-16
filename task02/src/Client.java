import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        int argsLength = args.length;
        int port = 0;
        String server = "";
        switch (argsLength) {
            case 0: server = "localhost"; port = 3000; break;
            case 1: server = "localhost"; port = Integer.parseInt(args[0]); break;
            case 2: server = args[0]; port = Integer.parseInt(args[1]); break;
        }

        try (Socket socket = new Socket(server, port)) {
            System.out.println("Connected to server");
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            Request request = new Request();
            Item item = new Item();

            boolean close = false;
            String line;
            while (!close) {
                line = br.readLine().trim();
                // System.out.println("Line from server: "+line);
                // process line
                String[] tokens = line.split(":");
                for (int i = 0; i < tokens.length; i++) {
                    tokens[i] = tokens[i].trim();
                }
                String directive = tokens[0];
                switch (directive) {
                    case Constants.REQUEST_ID: request.setRequest_id(tokens[1]); break;
                    case Constants.ITEM_COUNT: request.setItem_count(Integer.parseInt(tokens[1])); break;
                    case Constants.BUDGET: request.setBudget(Float.parseFloat(tokens[1])); break;
                    case Constants.PROD_LIST: break;
                    case Constants.PROD_START: item = new Item(); break;
                    case Constants.PROD_ID: item.setProd_id(tokens[1]); break;
                    case Constants.TITLE: item.setTitle(tokens[1]); break;
                    case Constants.PRICE: item.setPrice(Float.parseFloat(tokens[1])); break;
                    case Constants.RATING: item.setRating(Float.parseFloat(tokens[1])); break;
                    case Constants.PROD_END: {
                        request.addItem(item);
                        // check if item count matches item_count
                        if (request.endRequest()) {
                            close = true;
                            // System.out.println("=======Ending request==========");
                        }
                        break;
                    }
                    default: System.out.println("Line cannot be read, ignore: " + directive); break;
                }
            }

            System.out.println("Completed parsing information from server.");
            PurchaseDecision purchaseDecision = new PurchaseDecision(request.getItemList(), request.getBudget());
            List<Item> cart = purchaseDecision.selectItems();

            Response responseToServer = new Response(
                request.getRequest_id(),
                Constants.NAME_DATA,
                Constants.EMAIL_DATA,
                cart,
                purchaseDecision.getSpent(),
                request.getBudget()
            );

            String response = responseToServer.getResponse();

            System.out.println("Sending response to server..");
            bw.write(response);
            bw.flush();

            line = br.readLine();
            System.out.println(line);

            // Close connections
            bw.close();
            osw.close();
            os.close();
            br.close();
            isr.close();
            is.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}