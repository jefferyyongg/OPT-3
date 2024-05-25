import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class JsonLoader {
    private ArrayList<Recept> receptenBoek;

    public JsonLoader() {
        this.receptenBoek = new ArrayList<>();
    }

    public ArrayList<Recept> loadRecipe() {
        try (FileReader reader = new FileReader("/Users/jefferyyong/IdeaProjects/OPT-3/src/ReceptenBoek.json")) {
            Gson gson = new Gson();
            Type receptListType = new TypeToken<ArrayList<Recept>>(){}.getType();
            receptenBoek = gson.fromJson(reader, receptListType);
            if (receptenBoek == null) {
                receptenBoek = new ArrayList<>();  // Ensure receptenBoek is initialized
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receptenBoek;
    }

    public void addRecipe(Recept recept){
        ArrayList<Recept> receptenBoek = loadRecipe();
        receptenBoek.add(recept);

        Gson gson = new Gson();
        String json = gson.toJson(receptenBoek);

        try (FileWriter writer = new FileWriter("/Users/jefferyyong/IdeaProjects/OPT-3/src/ReceptenBoek.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
