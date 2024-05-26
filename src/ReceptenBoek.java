import model.Recept;
import util.JsonLoader;
import util.QueryReceptService;
import util.ReceptApiService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class ReceptenBoek {

    JsonLoader jsonLoader = new JsonLoader();

    public void load(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("\nReceptenBoek Menu:\n1. Toon ReceptenBoek\n2. Add Recept\n3. Remove Recept");
        String receptenBoekKeuze = scanner.nextLine();

        switch(receptenBoekKeuze){
            case "1":
                for(Recept r : jsonLoader.loadRecipes()){
                    System.out.println(r.getTitle());
                }
                break;
            case "2":
                System.out.println("=== Recept Zoeken ===");
                System.out.println("Zoekterm?: \n");
                String input = scanner.nextLine();
                ReceptApiService receptApiService = new QueryReceptService();
                ((QueryReceptService) receptApiService).responseToJson(input);
                break;
            case "3":
                System.out.println("=== Recept verwijderen ===");
                for(int i = 0; i < jsonLoader.loadRecipes().size(); i++){
                    System.out.println(i + ". " + jsonLoader.loadRecipes().get(i).getTitle());
                }
                String vwInput = scanner.nextLine();
                jsonLoader.removeRecipe(Integer.parseInt(vwInput));
                break;
            default:
                System.out.println("ongeldige invoer.");
        }
    }
}
