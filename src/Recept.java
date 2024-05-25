import java.util.List;

public class Recept {
    private int id;
    private String title;
    private String vegetarian;
    private String vegan;
    private String healthScore;
    private int likes;
    private int usedIngredientCount;
    private int missedIngredientCount;
    private List<Ingredient> missedIngredients;
    private List<Ingredient> usedIngredients;
    private List<Ingredient> unusedIngredients;

    Recept(int id, String title) {
        this.id = id;
        this.title = title;
    }

    Recept(int id, String title, int likes, int usedIngredientCount, int missedIngredientCount, List<Ingredient> usedIngredients, List<Ingredient> missedIngredients, List<Ingredient> unusedIngredients) {
        this.id = id;
        this.title = title;
        this.likes = likes;
        this.usedIngredientCount = usedIngredientCount;
        this.missedIngredientCount = missedIngredientCount;
        this.usedIngredients = usedIngredients;
        this.missedIngredients = missedIngredients;
        this.unusedIngredients = unusedIngredients;
    }

    private List<Ingredient> ingredienten;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(String vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getVegan() {
        return vegan;
    }

    public void setVegan(String vegan) {
        this.vegan = vegan;
    }

    public String getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(String healthScore) {
        this.healthScore = healthScore;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getUsedIngredientCount() {
        return usedIngredientCount;
    }

    public void setUsedIngredientCount(int usedIngredientCount) {
        this.usedIngredientCount = usedIngredientCount;
    }

    public int getMissedIngredientCount() {
        return missedIngredientCount;
    }

    public void setMissedIngredientCount(int missedIngredientCount) {
        this.missedIngredientCount = missedIngredientCount;
    }

    public List<Ingredient> getMissedIngredients() {
        return missedIngredients;
    }

    public void setMissedIngredients(List<Ingredient> missedIngredients) {
        this.missedIngredients = missedIngredients;
    }

    public List<Ingredient> getUsedIngredients() {
        return usedIngredients;
    }

    public void setUsedIngredients(List<Ingredient> usedIngredients) {
        this.usedIngredients = usedIngredients;
    }

    public List<Ingredient> getUnusedIngredients() {
        return unusedIngredients;
    }

    public void setUnusedIngredients(List<Ingredient> unusedIngredients) {
        this.unusedIngredients = unusedIngredients;
    }

    public List<Ingredient> getIngredienten() {
        return ingredienten;
    }

    public void setIngredienten(List<Ingredient> ingredienten) {
        this.ingredienten = ingredienten;
    }
}
