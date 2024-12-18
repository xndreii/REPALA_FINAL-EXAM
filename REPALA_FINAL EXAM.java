import java.util.Stack;

public class Main {  // Change to "Main" because the online compiler might expect this

    // Creature class to hold the name and power level of each creature
    static class Creature {
        String name;
        int powerLevel;

        // Constructor to initialize the creature's name and power level
        Creature(String name, int powerLevel) {
            this.name = name;
            this.powerLevel = powerLevel;
        }

        // Method to display the creature's name and power level
        void display() {
            System.out.println(name + " - " + powerLevel);
        }
    }

    public static void main(String[] args) {
        // Initialize an array of creatures with names and power levels
        Creature[] creatures = {
            new Creature("Dragon", 95),
            new Creature("Griffin", 88),
            new Creature("Unicorn", 78),
            new Creature("Phoenix", 92),
            new Creature("Centaur", 85)
        };

        // 1. Bubble Sort (Descending order based on power level)
        bubbleSort(creatures);
        System.out.println("**Bubble Sort: Descending Order by Power Level**");
        printCreatures(creatures);

        // 2. Selection Sort (Ascending order based on power level)
        selectionSort(creatures);
        System.out.println("\n***Selection Sort: Ascending Order by Power Level***");
        printCreatures(creatures);

        // 3. Stack Implementation (Push and Pop in descending order of power level)
        System.out.println("\n***Stack Implementation: Popping Creatures***");
        stackSortAndDisplay(creatures);
    }

    // Bubble Sort: Sort creatures based on their power level in descending order
    public static void bubbleSort(Creature[] creatures) {
        for (int i = 0; i < creatures.length - 1; i++) {
            for (int j = 0; j < creatures.length - 1 - i; j++) {
                if (creatures[j].powerLevel < creatures[j + 1].powerLevel) {
                    // Swap creatures if their power levels are in the wrong order
                    Creature temp = creatures[j];
                    creatures[j] = creatures[j + 1];
                    creatures[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort: Sort creatures based on their power level in ascending order
    public static void selectionSort(Creature[] creatures) {
        for (int i = 0; i < creatures.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < creatures.length; j++) {
                if (creatures[j].powerLevel < creatures[minIndex].powerLevel) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            Creature temp = creatures[i];
            creatures[i] = creatures[minIndex];
            creatures[minIndex] = temp;
        }
    }

    // Print the creatures' names and power levels
    public static void printCreatures(Creature[] creatures) {
        for (Creature c : creatures) {
            c.display();
        }
    }

    // Stack: Push creatures onto the stack and pop them to display in descending order
    public static void stackSortAndDisplay(Creature[] creatures) {
        // Use Bubble Sort to arrange creatures in descending order by power level
        bubbleSort(creatures);

        // Create a Stack and push all creatures onto it
        Stack<Creature> stack = new Stack<>();
        for (Creature c : creatures) {
            stack.push(c);
        }

        // Pop and display creatures from the stack (in descending order)
        while (!stack.isEmpty()) {
            System.out.print("Popped: ");
            stack.pop().display();
        }
    }
}