package tweakup.ru.retrofitrestapimvvm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tweakup.ru.retrofitrestapimvvm.models.Recipe;
import tweakup.ru.retrofitrestapimvvm.requests.RecipeApi;
import tweakup.ru.retrofitrestapimvvm.requests.ServiceGenerator;
import tweakup.ru.retrofitrestapimvvm.requests.responses.RecipeResponse;
import tweakup.ru.retrofitrestapimvvm.requests.responses.RecipeSearchResponse;

public class RecipeListActivity extends BaseActivity {

    private static final String TAG = "RecipeListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testRetrofitRequest();
            }
        });
    }

    private void testRetrofitRequest() {
        // 1. get a recipe api object
        RecipeApi recipeApi = ServiceGenerator.getRecipeApi();

        // 2. make the request
        Call<RecipeSearchResponse> responseCall = recipeApi.searchRecipe("meat", "2");

        // 3. enqueueing that request
        responseCall.enqueue(new Callback<RecipeSearchResponse>() {
            @Override
            public void onResponse(Call<RecipeSearchResponse> call, Response<RecipeSearchResponse> response) {
                Log.d(TAG, "onResponse: server response " + response);
                if (response.code() == 200) {
                    Toast.makeText(RecipeListActivity.this, "Code" + response.code(), Toast.LENGTH_SHORT).show();
                    List<Recipe> recipes = new ArrayList<>(response.body().getRecipes());
                    for (Recipe recipe : recipes) {
                        Log.d(TAG, "Response result title: " + recipe.getTitle());
                    }
                } else {

                }
            }

            @Override
            public void onFailure(Call<RecipeSearchResponse> call, Throwable t) {
                Log.d(TAG, "API Failed.... " + t.getMessage());
            }
        });
    }

    private void testRetrofitSingleRequest() {
        RecipeApi recipeApi = ServiceGenerator.getRecipeApi();

        Call<RecipeResponse> responseCall = recipeApi.getRecipe("9");

        responseCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                Recipe recipe = response.body().getRecipe();
                Log.d(TAG, "onResponse: " + recipe.toString());
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                Log.d(TAG, "API Failed.... " + t.getMessage());
            }
        });
    }
}