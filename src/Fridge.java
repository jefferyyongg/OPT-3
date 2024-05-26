import util.JsonLoader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Fridge {

    JsonLoader jsonLoader = new JsonLoader();

    public void load(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("\nFridge Menu:\n1. Toon Fridge\n2. Add Ingredient\n3. Remove Ingredient\n4. Toon Recept Suggesties");
        String fridgeKeuze = scanner.nextLine();

        switch(fridgeKeuze){
            case "1":
                System.out.println("=== Fridge ===");
                for(String s : jsonLoader.loadFridge()){
                    System.out.println(s);
                }
                break;
            case "2":
                System.out.println("=== Add Ingredient ===");
                String inputAddIngredient = scanner.nextLine();
                jsonLoader.addIngredient(inputAddIngredient);
                break;
            case "3":
                System.out.println("=== Remove Ingredient ===");
                for(int i = 0; i < jsonLoader.loadFridge().size(); i++){
                    System.out.println(i + ". " + jsonLoader.loadFridge().get(i));

                }
                String inputRemoveIngredient= scanner.nextLine();
                jsonLoader.removeIngredient(Integer.valueOf(inputRemoveIngredient));
                break;
            case "4":
                break;
            default:
                System.out.println("ongeldige invoer.");
        }
    }
}
