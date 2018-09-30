package kr.jinho.seoulmobilejava.activity;


import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.jinho.seoulmobilejava.R;
import kr.jinho.seoulmobilejava.data.SeoulGuData;
import kr.jinho.seoulmobilejava.init.Logger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    public void init() {
        api().getGu().enqueue(new Callback<SeoulGuData>() {
            @Override
            public void onResponse(Call<SeoulGuData> call, Response<SeoulGuData> response) {
                if (response.isSuccessful()) {
                }
            }

            @Override
            public void onFailure(Call<SeoulGuData> call, Throwable t) {

            }
        });
    }

    @OnClick(R.id.service_text)
    public void serviceText() {
        Intent intent = new Intent(this, FilteringActivity.class);
        intent.putExtra("click", "service");
        startActivity(intent);
    }

    @OnClick(R.id.service_location)
    public void serviceLocation() {
        Logger.d("serviceLocation");
    }

    @OnClick(R.id.service_volunteer)
    public void serviceVolunteer() {

    }

    @OnClick(R.id.service_clipboard)
    public void serviceClipboard() {

    }

    @OnClick(R.id.service_my_page)
    public void serviceMyPage() {

    }


}