package tweakup.ru.retrofitrestapimvvm.requests.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import tweakup.ru.retrofitrestapimvvm.models.Recipe;

public class RecipeResponse {
    @SerializedName("")
    @Expose()
    private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return "RecipeResponse{" +
                "recipe=" + recipe +
                '}';
    }
}
