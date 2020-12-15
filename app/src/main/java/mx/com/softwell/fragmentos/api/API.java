package mx.com.softwell.fragmentos.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    public static final String BASE_URL = "https://us-central1-softwell-vm.cloudfunctions.net/api/";
    private static Retrofit retrofit = null;

    public static Retrofit getApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
