import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class ReceptenBoek {
    JsonLoader jsonLoader = new JsonLoader();

    public void load(Scanner scanner) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("\nReceptenBoek Menu:\n1. Toon ReceptenBoek\n2. Add Recept\n3. Remove Recept");
        String receptenBoekKeuze = scanner.nextLine();

        switch(receptenBoekKeuze){
            case "1":
                for(Recept r : jsonLoader.loadRecipe()){
                    r.getTitle();
                }
                break;
            case "2":
                System.out.println("=== Recept Zoeken ===");
                System.out.println("Zoekterm?: \n");
                String input = scanner.nextLine();
                ReceptApiService receptApiService = new QueryReceptService();
                HttpResponse<String> response = receptApiService.handleHttpRequest(input);
                jsonLoader.addRecipe(receptApiService.processHttpResponse(response));
                System.out.printf("Recept Toegevoegd!");
                break;
        }
    }
}
