package rest;

import model.MoviesResponse;
import model.Registration;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by chandresh on 24/11/17.
 */

public interface ApiInterface {
    @GET("movie/top_rated")
    Call<MoviesResponse> getTotalResults(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MoviesResponse> getResults(@Query("api_key") String apiKey);

    @POST("api/register")
    Call<Registration> registration(@Body Registration reg);

}
