import java.util.LinkedList;
import java.util.List;

public class RequestHandler {
    List<Item> itemList = new LinkedList<>();
    String request_id;
    int item_count;
    float budget;
    
    public boolean endRequest() {
        boolean end = false;

        int curr_count;
        if (itemList.isEmpty()) {
            curr_count = 0;
        } else {
            curr_count = itemList.size();
        }

        if (curr_count == item_count) {
            end = true;
        }
        return end;
    }
    public void addItem(Item item) {
        itemList.add(item);
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public void setItem_count(int item_count) {
        this.item_count = item_count;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public String getRequest_id() {
        return request_id;
    }

    public int getItem_count() {
        return item_count;
    }

    public float getBudget() {
        return budget;
    }

    
}
