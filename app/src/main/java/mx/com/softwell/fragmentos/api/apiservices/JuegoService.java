package mx.com.softwell.fragmentos.api.apiservices;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JuegoService {
    @GET("juegos/top")
    Call<JsonObject> getTop();
    @GET("juegos/freetoplay")
    Call<JsonObject> getFreeToPlay();
    @GET("juegos/rank")
    Call<JsonObject> getRank();
    @GET("juegos/oldSchool")
    Call<JsonObject> getOldSchool();
}