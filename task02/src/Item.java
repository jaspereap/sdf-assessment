public class Item {
    String prod_id;
    String title;
    float price;
    float rating;

    public Item() {

    }

    public String getProd_id() {return prod_id;}
    public String getTitle() {return title;}
    public float getPrice() {return price;}
    public float getRating() {return rating;}

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    
}
