import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

class Node {
    String description;
    Map<String, Node> choices;

    public Node(String description) {
        this.description = description;
        this.choices = new HashMap<>();
    }

    public void addChoice(String choiceDescription, Node nextNode) {
        choices.put(choiceDescription, nextNode);
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Node> getChoices() {
        return choices;
    }
}