import java.util.List;
import java.util.Scanner;

public class ConversationManager {
    private RandomSentenceGenerator sentenceGenerator;
    private Scanner scanner;
    private Menu menu;

    public ConversationManager(Scanner scanner, RandomSentenceGenerator sentenceGenerator, Menu menu) {
        this.sentenceGenerator = sentenceGenerator;
        this.scanner = scanner;
        this.menu = menu;
    }

    public Order startConversation() {
        System.out.println(sentenceGenerator.getRandomSentence("greetings"));
        String userInput = scanner.nextLine().toLowerCase();

        if (!userInput.contains("burrito") 
            && !userInput.contains("bowl") 
            && !userInput.contains("tacos") 
            && !userInput.contains("quesadilla")
            && !userInput.contains("nachos") 
            && !userInput.contains("salad")) {
            System.out.println(sentenceGenerator.getRandomSentence("apologies"));
            return null;
        }

        String itemType = getItemType(userInput);
        Order order = new Order(itemType);
        order.setItempcost(itemType);
        String meat = getMeat();
        order.setMeat(meat);

        // Add toppings if the user wants them
        System.out.println(sentenceGenerator.getRandomSentence("topping_prompts"));
        String toppingsResponse = scanner.nextLine().toLowerCase();

        if (toppingsResponse.contains("yes")) {
            addToppings(order);
        }

        // If the item is tacos, get the quantity
        if (itemType.equals("tacos")) {
            int quantity = getTacoQuantity();
            order.setTacoQuantity(quantity);
        }

        // Calculate the total
        order.calculateTotal();
        System.out.println("Alright, your total for the " + itemType + " comes to $" + order.getTotalCost());
        return order;
    }

    private String getItemType(String userInput) {
        if (userInput.contains("burrito")) {
            return "burrito";
        } else if (userInput.contains("bowl")) {
            return "bowl";
        } else if (userInput.contains("tacos")) {
            return "tacos";
        }
        return "";
    }

    private String getMeat() {
        String meat = "";
        while (true) {
            System.out.println(sentenceGenerator.getRandomSentence("meat_prompts"));
            meat = scanner.nextLine().toLowerCase();
            if (Menu.MEAT_PRICES.containsKey(meat)) {
                break;
            } else {
                System.out.println(sentenceGenerator.getRandomSentence("invalid_meat_responses"));
            }
        }
        return meat;
    }

    private void addToppings(Order order) {
        boolean addingToppings = true;
        while (addingToppings) {
            List<Topping> availableToppings = Menu.getAvailableToppings();
            System.out.println("Here are some toppings you can choose from:");
            for (int i = 0; i < availableToppings.size(); i++) {
                Topping topping = availableToppings.get(i);
                System.out.println((i + 1) + ". " + topping.getName() + " - $" + topping.getPrice());
            }

            System.out.println("Would you like to add a topping? (Yes, No, or press Enter to skip)");

            String toppingChoice = scanner.nextLine().toLowerCase();
            if (toppingChoice.isEmpty() || toppingChoice.equals("no")) {
                addingToppings = false;  // Stop asking for toppings if the user presses Enter or says "No"
            } else if (toppingChoice.equals("yes")) {
                System.out.println("Please enter the number of the topping you'd like to add (or press Enter to finish):");
                String toppingSelection = scanner.nextLine().toLowerCase();

                try {
                    int choice = Integer.parseInt(toppingSelection) - 1;
                    if (choice >= 0 && choice < availableToppings.size()) {
                        Topping selectedTopping = availableToppings.get(choice);
                        order.addTopping(selectedTopping);
                        System.out.println("Added " + selectedTopping.getName() + " to your order.");
                    } else {
                        System.out.println("Sorry, that's not a valid topping choice. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number for the topping.");
                }
            } else {
                System.out.println("Sorry, I didn't understand that. Please say 'yes', 'no', or press Enter to skip.");
            }
        }
    }


    private int getTacoQuantity() {
        int quantity = 0;
        while (true) {
            System.out.println(sentenceGenerator.getRandomSentence("taco_quantity_prompts"));
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                scanner.nextLine();
                if (quantity > 0) {
                    break;
                } else {
                    System.out.println(sentenceGenerator.getRandomSentence("invalid_quantity_responses"));
                }
            } else {
                System.out.println(sentenceGenerator.getRandomSentence("invalid_quantity_responses"));
                scanner.nextLine();
            }
        }
        return quantity;
    }
}
