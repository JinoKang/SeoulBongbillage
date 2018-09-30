package kr.jinho.seoulmobilejava.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.jinho.seoulmobilejava.R;
import kr.jinho.seoulmobilejava.data.RecruitItem;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private ArrayList<RecruitItem> mItems;
    Context mContext;

    public RecyclerViewAdapter(ArrayList itemList) {
        mItems = itemList;
    }

    // 필수 오버라이드 : View 생성, ViewHolder 호출
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recruit_item, parent, false);
        mContext = parent.getContext();
        RecyclerViewHolder holder = new RecyclerViewHolder(v);
        return holder;
    }

    // 필수 오버라이드 : 재활용되는 View 가 호출, Adapter 가 해당 position 에 해당하는 데이터를 결합
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        // 해당 position 에 해당하는 데이터 결합
        holder.mItemTitle.setText(mItems.get(position).getTitle());
        holder.mItemLocation.setText(mItems.get(position).getLocation());
        holder.mItemDate.setText(mItems.get(position).getDate());
        holder.mItemState.setTag(mItems.get(position).getState());

        // 이벤트처리 : 생성된 List 중 선택된 목록번호를 Toast로 출력
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, String.format("%d 선택", position + 1), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 필수 오버라이드 : 데이터 갯수 반환
    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_title)
        TextView mItemTitle;
        @BindView(R.id.item_location)
        TextView mItemLocation;
        @BindView(R.id.item_date)
        TextView mItemDate;
        @BindView(R.id.item_state)
        Button mItemState;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
