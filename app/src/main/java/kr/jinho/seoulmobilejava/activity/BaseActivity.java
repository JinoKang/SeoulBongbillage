package kr.jinho.seoulmobilejava.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import kr.jinho.seoulmobilejava.SeoulMobileApi;
import kr.jinho.seoulmobilejava.SeoulMobileUtils;

public class BaseActivity extends AppCompatActivity{

    public final String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public SeoulMobileApi api(){
        return SeoulMobileUtils.getSeoulMobileApi();
    }
}
