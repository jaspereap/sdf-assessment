import java.util.List;

public class PurchaseDecision {
    List<Item> itemList;
    float budget;
    public PurchaseDecision(List<Item> itemList, float budget) {
        this.itemList = itemList;
        this.budget = budget;
        
        printItemList();
    }

    public void sortItemList() {
        
    }

    public void printItemList() {
        System.out.println("Budget: " + this.budget);
        System.out.println("Current item list: ");
        for (Item i : this.itemList) {
            System.out.println(i.getTitle());
        }
    }


}
