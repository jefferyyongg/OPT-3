package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Recept;
import model.ReceptQueryResult;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonLoader {

    //ReceptenBoek JSON Handling

    public List<Recept> loadRecipes() {
        List<Recept> recept;
        List<Recept> recepten = new ArrayList<>();
        try (FileReader reader = new FileReader("/Users/jefferyyong/IdeaProjects/OPT-3/src/ReceptenBoek.json")) {
            Gson gson = new Gson();
            Type recipeListType = new TypeToken<List<Recept>>(){}.getType();
            recept = gson.fromJson(reader, recipeListType);
            if (recept == null) {
                recept = new ArrayList<>();
            }
            for(Recept r : recept){
                recepten.add(r);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recepten;
    }

    public void addRecipe(ReceptQueryResult recept) {
        List<Recept> recepten = loadRecipes();
        recepten.add(recept);

        refreshReceptJson(recepten, "/Users/jefferyyong/IdeaProjects/OPT-3/src/ReceptenBoek.json");
        System.out.println("Recept Toegevoegd");
    }

    public void removeRecipe(int receptID){
        List<Recept> recepten = loadRecipes();
        recepten.remove(receptID);

        refreshReceptJson(recepten, "/Users/jefferyyong/IdeaProjects/OPT-3/src/ReceptenBoek.json");
        System.out.println("Recept Verwijderd");
    }

    public void refreshReceptJson(List<Recept> recepten, String file){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(recepten);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Fridge JSON Handling

    public List<String> loadFridge() {
        List<String> ingredients = new ArrayList<>();
        try (FileReader reader = new FileReader("/Users/jefferyyong/IdeaProjects/OPT-3/src/Fridge.json")) {
            Gson gson = new Gson();
            Type recipeListType = new TypeToken<List<String>>(){}.getType();
            ingredients = gson.fromJson(reader, recipeListType);
            if (ingredients == null) {
                ingredients = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    public void addIngredient(String ingredient) {
        List<String> fridge = loadFridge();
        fridge.add(ingredient);

        refreshFridgeJson(fridge, "/Users/jefferyyong/IdeaProjects/OPT-3/src/Fridge.json");
        System.out.println("Ingredient Toegevoegd");
    }

    public void removeIngredient(int ingredientID){
        List<String> fridge = loadFridge();
        fridge.remove(ingredientID);

        refreshFridgeJson(fridge, "/Users/jefferyyong/IdeaProjects/OPT-3/src/Fridge.json");
        System.out.println("Ingredient Verwijderd");
    }

    public void refreshFridgeJson(List<String> fridge, String file){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(fridge);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
