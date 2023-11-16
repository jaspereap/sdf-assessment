import java.util.List;

public class Response {
    String request_id;
    String name;
    String email;
    List<String> items;
    float spent;
    float remaining;

    public Response(String request_id, String name, String email, List<Item> rawItems, float spent, float budget) {
        this.request_id = request_id;
        this.name = name;
        this.email = email;
        this.spent = spent;
        processItems(rawItems);
        this.remaining = budget - spent;
    }

    public void processItems(List<Item> rawItems) {
        for (int i = 0; i < rawItems.size(); i++) {
            items.add(rawItems.get(i).getProd_id());
        }
    }
}
