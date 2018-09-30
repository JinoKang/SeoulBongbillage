package kr.jinho.seoulmobilejava;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SeoulMobileUtils {

    public static SeoulMobileApi seoulMobileApi;

    public static SeoulMobileApi getSeoulMobileApi() {
        if (seoulMobileApi == null) {
            seoulMobileApi = new Retrofit.Builder()
                    .baseUrl(SeoulMobileApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(SeoulMobileApi.class);
        }
        return seoulMobileApi;
    }

}