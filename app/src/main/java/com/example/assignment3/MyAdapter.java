package com.example.assignment3;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private RealmResults<MyPerson> mPersonRealmResults;
    private Context mContext;
    private String[] colors={"#00009C","#009900","#CCCC00","#FF0000"};
    public MyAdapter(RealmResults<MyPerson> persons, Context context) {
        mPersonRealmResults = persons;
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyPerson person = mPersonRealmResults.get(position);
        holder.name.setText(person.getName());
        holder.dept.setText(person.getDept());
        holder.phone.setText(person.getPhone());
        holder.roll.setText(person.getRoll() + "");
        holder.gender.setText(person.getGender());
        holder.item.setBackgroundColor(Color.parseColor(colors[position%4]));

    }

    @Override
    public int getItemCount() {
        return mPersonRealmResults.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView dept;
        private TextView phone;
        private TextView roll;
        private TextView gender;
        private RelativeLayout item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_tv);
            dept = itemView.findViewById(R.id.dept_tv);
            phone = itemView.findViewById(R.id.phone_tv);
            roll = itemView.findViewById(R.id.roll_tv);
            gender = itemView.findViewById(R.id.gender_tv);
            item=itemView.findViewById(R.id.category_image);

        }
    }
}
