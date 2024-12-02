import java.util.*;

public class Order {
    private String itemType;
    private String meat;
    private List<Topping> toppings;
    private int tacoQuantity;
    private double totalCost;

    public Order(String itemType) {
        this.itemType = itemType;
        this.toppings = new ArrayList<>();
        this.totalCost = 0.0;
        this.tacoQuantity = 1;
    }

    public void setItempcost(String mealType) {
        this.totalCost += Menu.getMealPrice(mealType);
    }
    
    public String getItemType() {
        return itemType;
    }

    public void setMeat(String meat) {
        this.meat = meat;
        this.totalCost += Menu.getMeatPrice(meat);
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
        this.totalCost += topping.getPrice();
    }

    public void setTacoQuantity(int quantity) {
        this.tacoQuantity = quantity;
    }

    public void calculateTotal() {
        this.totalCost *= tacoQuantity;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getMeat() {
        return meat;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public int getTacoQuantity() {
        return tacoQuantity;
    }
}