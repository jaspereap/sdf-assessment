import java.util.LinkedList;
import java.util.List;

public class Response {
    String request_id;
    String name;
    String email;
    String items;
    float spent;
    float remaining;
    float budget;
    String response = "";

    public Response(String request_id, String name, String email, List<Item> rawItems, float spent, float budget) {
        this.request_id = request_id;
        this.name = name;
        this.email = email;
        this.spent = spent;
        processItems(rawItems);
        this.remaining = budget - spent;
        this.budget = budget;
    }

    public void processItems(List<Item> rawItems) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rawItems.size(); i++) {
            sb.append(rawItems.get(i).getProd_id()).append(",");
        }
        // separate values with comma
        items = sb.toString();
        items = items.substring(0,items.length()-1);
    }

    public String getResponse() {
        System.out.println("Generating response for server....");
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.REQUEST_ID + ": ").append(this.request_id).append("\n");
        sb.append(Constants.R_NAME + ": ").append(name).append("\n");
        sb.append(Constants.R_EMAIL + ": ").append(email).append("\n");
        sb.append(Constants.R_ITEMS + ": ").append(items).append("\n");
        sb.append(Constants.R_SPENT + ": ").append(spent).append("\n");
        sb.append(Constants.R_REMAINING + ": ").append(remaining).append("\n");
        sb.append(Constants.R_END).append("\n");

        // System.out.println(sb.toString());
        response = sb.toString();
        return response;
    }

    public void printResponse() {
        System.out.println("Request id: " + request_id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Budget: " + budget);
        System.out.println("Spent: " + spent);
        System.out.println("Remaining: " + remaining);
    }
}
