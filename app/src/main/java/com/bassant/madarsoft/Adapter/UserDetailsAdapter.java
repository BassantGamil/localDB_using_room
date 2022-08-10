package com.bassant.madarsoft.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bassant.madarsoft.Model.UserModel;
import com.bassant.madarsoft.R;

import java.util.List;

public class UserDetailsAdapter extends RecyclerView.Adapter<UserDetailsAdapter.ViewHolder> {
    Context context;
    List<UserModel> userModelList;

    public UserDetailsAdapter(Context context, List<UserModel> userModelList) {
        this.context = context;
        this.userModelList = userModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user_details, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.nameTxt.setText(userModelList.get(position).getName());
            holder.jobTitleTxt.setText(userModelList.get(position).getJobTitle());
            holder.ageTxt.setText(userModelList.get(position).getAge());
            holder.genderTxt.setText(userModelList.get(position).getGender());

    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTxt, ageTxt, jobTitleTxt, genderTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.show_name_text_view);
            ageTxt = itemView.findViewById(R.id.show_age_text_view);
            jobTitleTxt = itemView.findViewById(R.id.show_job_title_text_view);
            genderTxt = itemView.findViewById(R.id.show_gender_text_view);
        }
    }
}
