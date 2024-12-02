import java.util.*;

public class RandomSentenceGenerator {
    private Map<String, List<String>> sentenceGroups;

    public RandomSentenceGenerator() {
        sentenceGroups = new HashMap<>();

        sentenceGroups.put("greetings", Arrays.asList(
            "Hey, how’s it going? What can I get for you today?",
            "Hi there! What are you in the mood for?",
            "Hello! What can I make for you today?",
            "What’s up? What would you like to eat?",
            "Hey! Ready to order something delicious?"
        ));

        sentenceGroups.put("apologies", Arrays.asList(
            "I’m sorry, I didn’t understand that. Could you please rephrase",
            "My mistake, I didn’t catch that. Could you say that again?",
            "Sorry, I didn’t quite catch that. Could you say that again?",
            "I couldn't undertand that. Could you say that again?"
        ));

        sentenceGroups.put("meat_prompts", Arrays.asList(
            "What kind of meat are you feeling today?",
            "Which meat do you want? We've got chicken, steak, carnitas, chorizo, or veggie.",
            "Tell me, what type of meat are you in the mood for?",
            "What protein are you thinking about for your dish?",
            "Which one sounds better to you: chicken, steak, carnitas, chorizo, or veggie?"
        ));

        sentenceGroups.put("invalid_meat_responses", Arrays.asList(
            "Sorry, we don’t have that. How about chicken, steak, carnitas, chorizo, or veggie?",
            "Hmm, we don’t serve that. Maybe try chicken, steak, carnitas, chorizo, or veggie?",
            "Oops, that’s not on the menu. What about chicken, steak, carnitas, chorizo, or veggie?",
            "Sorry about that! Can you pick from chicken, steak, carnitas, chorizo, or veggie?",
            "Not sure what that is! How about you choose from chicken, steak, carnitas, chorizo, or veggie?"
        ));

        sentenceGroups.put("topping_prompts", Arrays.asList(
            "Do you want to add any toppings to that? (Yes or no)",
            "Feeling like some toppings today? (Yes or no)",
            "Any toppings you'd like to add to your order?",
            "Want to add some extra flavor with toppings? (Yes or no)",
            "Top it off with some extras? (Yes or no)"
        ));

        sentenceGroups.put("invalid_topping_responses", Arrays.asList(
            "I didn't quite catch that. Just say 'yes' or 'no' if you'd like toppings!",
            "Can you confirm? Do you want toppings? Please say 'yes' or 'no'.",
            "Not sure what you mean! Do you want toppings? Yes or no?",
            "Sorry, I missed that! Toppings, yes or no?",
            "I need a simple 'yes' or 'no' for toppings."
        ));

        sentenceGroups.put("taco_quantity_prompts", Arrays.asList(
            "How many tacos are you thinking about getting today?",
            "How many tacos do you want to order?",
            "Let me know how many tacos you’re craving!",
            "How many tacos should I put down for you?",
            "How many tacos are we looking at today?"
        ));

        sentenceGroups.put("invalid_quantity_responses", Arrays.asList(
            "Hmm, that’s not a valid number. Could you try again?",
            "Sorry, I didn't get that. Can you give me a number for how many tacos?",
            "Oops, looks like that’s not a number. How many tacos would you like?",
            "Can you please enter a valid number? How many tacos are you ordering?",
            "I need a number greater than 0. How many tacos should I get for you?"
        ));
    }

    public String getRandomSentence(String groupName) {
        List<String> sentences = sentenceGroups.get(groupName);
        if (sentences == null || sentences.isEmpty()) {
            return "No sentences available.";
        }
        Random random = new Random();
        return sentences.get(random.nextInt(sentences.size()));
    }
}
