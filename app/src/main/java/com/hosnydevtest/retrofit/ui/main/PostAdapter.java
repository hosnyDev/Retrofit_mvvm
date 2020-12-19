package com.hosnydevtest.retrofit.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hosnydevtest.retrofit.R;
import com.hosnydevtest.retrofit.model.PostModel;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<PostModel> list;

    public PostAdapter(List<PostModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.format_posts, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.setPostID(String.valueOf(list.get(position).getId()));
        holder.setUserID(String.valueOf(list.get(position).getUserId()));
        holder.setPostTitle(list.get(position).getTitle());
        holder.setPostBody(list.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView userID, postID, postTitle, postBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userID = itemView.findViewById(R.id.userID);
            postID = itemView.findViewById(R.id.ID);
            postTitle = itemView.findViewById(R.id.title);
            postBody = itemView.findViewById(R.id.body);

        }

        void setUserID(String user_id) {
            userID.setText(user_id);
        }

        void setPostID(String post_id) {
            postID.setText(post_id);
        }

        void setPostTitle(String post_title) {
            postTitle.setText(post_title);
        }

        void setPostBody(String body) {
            postBody.setText(body);
        }

    }

}
