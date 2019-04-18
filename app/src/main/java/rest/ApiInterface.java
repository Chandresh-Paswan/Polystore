package rest;

import com.example.android.polystore.model.Result;

import model.MoviesResponse;
import model.Registration;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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

    //The register call
    @FormUrlEncoded
    @POST("api/register")
    Call<Result> createUser(@Field("email") String email, @Field("password") String password, @Field("login") String store_name, @Field("lastModifiedBy") String register_date,
                            @Field("firstName") String user_name, @Field("role") String confirm_password, @Field("createdDate") String first_name, @Field("lastName") String last_name, @Field("dateOfBirth") String date_birth, @Field("phoneNo") String mobile_number,
                            @Field("area") String area, @Field("landmark") String landmark, @Field("address") String address, @Field("country") String country,
                            @Field("login") String state, @Field("stateName")  String city, @Field("cityName") String store_reg_name, @Field("createdDate") String store_reg_date);
}
