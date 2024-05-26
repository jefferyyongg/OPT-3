import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void menuKeuze(){
        System.out.println("\nMenu:\n1. \uD83C\uDF5DRecept Opties\n2. ❄\uFE0FFridge Opties");
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menuKeuze();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    ReceptenBoek receptenBoek = new ReceptenBoek();
                    receptenBoek.load(scanner);
                    break;
                case "2":
                    Fridge fridge = new Fridge();
                    fridge.load(scanner);
                    break;
                default:
                    System.out.println("ongeldige invoer.");
                    break;
            }
        }
    }
}