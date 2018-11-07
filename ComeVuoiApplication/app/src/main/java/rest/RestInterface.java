package rest;

import model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestInterface {

    @GET("/?")
    public Call<Movie> getMovie(@Query("t") String titles,
                                @Query("apikey") String apiKey);

}
