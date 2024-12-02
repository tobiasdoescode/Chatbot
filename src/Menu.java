import java.util.*;

public class Menu {
    // Static Map for storing meat prices
    public static final Map<String, Double> MEAT_PRICES = new HashMap<>();
    public static final List<Topping> AVAILABLE_TOPPINGS = new ArrayList<>();
    public static final Map<String, Double> MEAL_PRICES = new HashMap<>();
    static {

        MEAL_PRICES.put("burrito", 5.99);
        MEAL_PRICES.put("bowl", 4.99);
        MEAL_PRICES.put("tacos", 3.99);
        MEAL_PRICES.put("quesadilla", 4.99);
        MEAL_PRICES.put("nachos", 5.99);
        MEAL_PRICES.put("salad", 3.99);
        // Initialize meat prices
        MEAT_PRICES.put("chicken", 8.99);
        MEAT_PRICES.put("steak", 9.99);
        MEAT_PRICES.put("carnitas", 9.49);
        MEAT_PRICES.put("chorizo", 9.99);
        MEAT_PRICES.put("veggie", 8.49);

        // Initialize toppings with names and prices
        AVAILABLE_TOPPINGS.add(new Topping("Guacamole", 1.99));
        AVAILABLE_TOPPINGS.add(new Topping("Sour Cream", 0.99));
        AVAILABLE_TOPPINGS.add(new Topping("Salsa", 0.50));
        AVAILABLE_TOPPINGS.add(new Topping("Cheese", 0.50));
        AVAILABLE_TOPPINGS.add(new Topping("Pico de Gallo", 0.50));
    }
    public static double getMealPrice(String mealType){
        return MEAL_PRICES.getOrDefault(mealType, 0.0);
    }
    // Static method to get the price of meat
    public static double getMeatPrice(String meat) {
        return MEAT_PRICES.getOrDefault(meat, 0.0);
    }

    // Method to get all available toppings
    public static List<Topping> getAvailableToppings() {
        return AVAILABLE_TOPPINGS;
    }
}
