package api.services;

import api.models.Card;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CardService {
    @POST("cards")
    Call<Card> createCard(@Query("idList") String name, @Body Card card);

   // @GET("card/id")
   // Call<Card>
}
