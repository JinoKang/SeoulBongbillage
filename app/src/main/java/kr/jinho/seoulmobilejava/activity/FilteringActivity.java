package kr.jinho.seoulmobilejava.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.jinho.seoulmobilejava.R;
import kr.jinho.seoulmobilejava.init.Logger;

public class FilteringActivity extends BaseActivity {

    @BindView(R.id.list_location)
    GridLayout mListLocation;
    @BindView(R.id.list_field)
    GridLayout mListField;
    @BindView(R.id.list_volunteer)
    GridLayout mListVolunteer;
    @BindView(R.id.list_calendar)
    LinearLayout mListCalendar;

    @BindView(R.id.calendar_start)
    TextView mCalendarStart;
    @BindView(R.id.calendar_end)
    TextView mCalendarEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtering);
        ButterKnife.bind(this);

        init();
        Intent intent = getIntent();
        if (intent != null) {
            Logger.e(intent.getStringExtra("click"));
        }

    }

    private void init() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String getTime = sdf.format(date);

        mCalendarStart.setText(getTime);
    }

    @OnClick(R.id.list_location)
    public void listLocation() {
        Logger.e("test" + mListLocation.getChildCount());
    }

    @OnClick(R.id.search_location)
    public void searchLocation() {
        if (mListLocation.getVisibility() == View.GONE) mListLocation.setVisibility(View.VISIBLE);
        else mListLocation.setVisibility(View.GONE);

    }

    @OnClick(R.id.search_field)
    public void searchField() {
        if (mListField.getVisibility() == View.GONE) mListField.setVisibility(View.VISIBLE);
        else mListField.setVisibility(View.GONE);
    }

    @OnClick(R.id.search_volunteer)
    public void searchVolunteer() {
        if (mListVolunteer.getVisibility() == View.GONE) mListVolunteer.setVisibility(View.VISIBLE);
        else mListVolunteer.setVisibility(View.GONE);
    }

    @OnClick(R.id.search_calendar)
    public void searchCalendar() {
        if (mListCalendar.getVisibility() == View.GONE) mListCalendar.setVisibility(View.VISIBLE);
        else mListCalendar.setVisibility(View.GONE);
    }

}
