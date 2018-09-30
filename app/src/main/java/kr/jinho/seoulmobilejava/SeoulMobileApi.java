package kr.jinho.seoulmobilejava;

import kr.jinho.seoulmobilejava.data.SeoulGuData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SeoulMobileApi {

    String BASE_URL = "http://openapi.1365.go.kr/openapi/service/rest/";

    @GET("CodeInquiryService/getAreaCodeInquiryList?ServiceKey=" + R.string.gu_data_key + "=서울&numOfRows=25&_type=json")
    Call<SeoulGuData> getGu();

}
