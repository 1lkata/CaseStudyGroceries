import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        ArrayList<String> groceryItems = new ArrayList<>();
        System.out.println("Enter grocery items (type 'done' to finish):");
        while (true) {
            System.out.print("Enter: ");
            String groceryItem = scanner.nextLine();
            if (groceryItem.equals("done")) {
                break;
            } else {
                groceryItems.add(groceryItem);
            }
        }
        writeToFile(groceryItems, fileName);
    }

    public static void writeToFile(ArrayList<String> items, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName + ".txt"))) {
            for (int i = 0; i < items.size(); i++) {
                writer.println((i + 1) + ". " + items.get(i));//ChatGPT told me how to add the index
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}