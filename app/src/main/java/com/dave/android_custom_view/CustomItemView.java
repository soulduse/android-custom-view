package com.dave.android_custom_view;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by soul on 2017. 8. 30..
 */

public class CustomItemView extends LinearLayout {

    private TextView title;
    private RecyclerView recyclerView;
    private CustomAdapter mCustomAdapter;

    public CustomItemView(Context context) {
        this(context, null);
    }

    public CustomItemView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void setTitle(String s){
        title.setText(s);
    }

    public String getTitle(){
        return title.getText().toString();
    }

    private void initView(){
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = layoutInflater.inflate(R.layout.view_custom_item, this, false);
        addView(root);

        title = findViewById(R.id.tv_title);
        recyclerView = findViewById(R.id.recyclerview);
    }

    public void setDataAndView(List<Integer> itemList){
        mCustomAdapter = new CustomAdapter(itemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayout.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.right = 25;
            }
        });
        recyclerView.setAdapter(mCustomAdapter);
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

        private List<Integer> itemList;

        CustomAdapter(List<Integer> itemList){
            this.itemList = itemList;
        }

        @Override
        public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_item, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
            holder.tvNumber.setText(itemList.get(position)+" 번째");
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvNumber;

            public ViewHolder(View itemView) {
                super(itemView);
                tvNumber = (TextView)itemView.findViewById(R.id.tv_number);
            }
        }
    }
}
