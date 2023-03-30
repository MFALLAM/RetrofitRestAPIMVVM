package tweakup.ru.retrofitrestapimvvm.requests;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import tweakup.ru.retrofitrestapimvvm.requests.responses.RecipeResponse;
import tweakup.ru.retrofitrestapimvvm.requests.responses.RecipeSearchResponse;
import tweakup.ru.retrofitrestapimvvm.util.Constants;

public interface RecipeApi {
    // search query
    @Headers({Constants.API_KEY})
    @GET("api/recipe/search/")
    Call<RecipeSearchResponse> searchRecipe(
            @Query("query") String query,
            @Query("page") String page
    );

    // get
    @Headers({Constants.API_KEY})
    @GET("api/recipe/get/")
    Call<RecipeResponse> getRecipe(
            @Query("id") String id
    );
}
