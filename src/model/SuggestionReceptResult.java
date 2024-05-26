package model;

import java.util.List;

public class SuggestionReceptResult extends Recept{
    SuggestionReceptResult(int id, String title, int likes, int usedIngredientCount, int missedIngredientCount, List<Ingredient> usedIngredients, List<Ingredient> missedIngredients, List<Ingredient> unusedIngredients) {
        super(id, title, likes, usedIngredientCount, missedIngredientCount, usedIngredients, missedIngredients, unusedIngredients);
    }
}
