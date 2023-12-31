import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseDecision {
    List<Item> itemList;
    List<Item> sortedItemList;
    List<Item> cart;
    float budget;
    float spent;
    
    public PurchaseDecision(List<Item> itemList, float budget) {
        this.itemList = itemList;
        this.budget = budget;
        sortItemList();
    }

    public List<Item> selectItems() {
        cart = new LinkedList<>();
        float totalCost = 0;
        for (int i = sortedItemList.size() - 1; i >= 0; i--) {
            float itemPrice = sortedItemList.get(i).getPrice();

            if (itemPrice > budget | (itemPrice + totalCost) > budget) {
                // System.out.println("===Item out of budget===");
                continue;
            }
            totalCost += itemPrice;
            cart.add(sortedItemList.get(i));
        }
        spent = totalCost;
        return this.cart;

    }

    public void sortItemList() {
        sortedItemList = itemList
        .stream()
        .sorted(Comparator.comparing(Item::getRating)
                            .thenComparing(Item::getPrice))
        .collect(Collectors.toList());
    }

    public float getSpent() {
        return spent;
    }

}
