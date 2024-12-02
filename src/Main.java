import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RandomSentenceGenerator sentenceGenerator = new RandomSentenceGenerator();
        Menu menu = new Menu(); 
        ConversationManager conversationManager = new ConversationManager(scanner, sentenceGenerator, menu);

        while (true) {
            Order order = conversationManager.startConversation();
            if (order == null) {
                continue;
            }

            System.out.println("Thank you for your order!");
            System.out.println("Your order summary: ");
            System.out.println("Item: " + order.getItemType());
            System.out.println("Meat: " + order.getMeat());
            System.out.println("Toppings: ");
            for (Topping topping : order.getToppings()) {
                System.out.println("- " + topping.getName());
            }
            System.out.println("Total: $" + order.getTotalCost());

            System.out.println("Would you like to place another order? (yes or no)");
            String response = scanner.nextLine().toLowerCase();
            if (!response.equals("yes")) {
                System.out.println("Thanks for visiting! Have a great day!");
                break;
            }
        }

        scanner.close();
    }
}