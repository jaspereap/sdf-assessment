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
        // System.out.println("printing from select items");
        for (int i = sortedItemList.size() - 1; i >= 0; i--) {
            float itemRating = sortedItemList.get(i).getRating();
            float itemPrice = sortedItemList.get(i).getPrice();
            // System.out.println("\tBudget: " + budget);
            // System.out.println("\tItem rating: " + itemRating);
            // System.out.println("\tItem price: " + itemPrice);

            if (itemPrice > budget | (itemPrice + totalCost) > budget) {
                // System.out.println("===Item out of budget===");
                continue;
            }
            totalCost += itemPrice;
            // System.out.println("\tTotal cost: " + totalCost);
            // System.out.println("Adding item to cart: " + sortedItemList.get(i).getTitle());
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

    public void printItemList(List<Item> list) {
        System.out.println("Budget: " + this.budget);
        System.out.println("Current item list: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getTitle());
            System.out.println("\tRating: "+list.get(i).getRating());
            System.out.println("\tPrice: "+list.get(i).getPrice());
        }
    }

    public float getSpent() {
        return spent;
    }

}
