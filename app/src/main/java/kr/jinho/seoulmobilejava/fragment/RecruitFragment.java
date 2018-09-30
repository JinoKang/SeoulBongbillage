package kr.jinho.seoulmobilejava.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.jinho.seoulmobilejava.R;
import kr.jinho.seoulmobilejava.adapter.RecyclerViewAdapter;
import kr.jinho.seoulmobilejava.data.RecruitItem;

public class RecruitFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    LinearLayoutManager linearLayoutManager;
    RecyclerViewAdapter recyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recruit, container, false);
        ButterKnife.bind(this, view);

        // ArrayList 에 Item 객체(데이터) 넣기

        // LinearLayout으로 설정
        mRecyclerView.setLayoutManager(linearLayoutManager);
        // Animation Defualt 설정
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // Decoration 설정
        // mRecyclerView.addItemDecoration(new RecyclerViewDecoration(this, RecyclerViewDecoration.VERTICAL_LIST));
        // Adapter 생성
        ArrayList arrayList = new ArrayList<RecruitItem>();
        recyclerViewAdapter = new RecyclerViewAdapter(arrayList);
        mRecyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }

}
