package com.example.prive.student_portal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class StoreInfoAdapter extends RecyclerView.Adapter<StoreInfoAdapter.ViewHolder> {

    private List<StoreInfo> infoList;
    private Context context;

    final private PortalClickListener portalClickListener;

    public interface PortalClickListener {
        void portalOnClick(int i);
    }

    public StoreInfoAdapter(List<StoreInfo> infoList, PortalClickListener portalClickListener) {
        this.infoList = infoList;
        this.portalClickListener = portalClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_info_holder, parent, false);

        // Return a new holder instance

        StoreInfoAdapter.ViewHolder infoViewHolder = new StoreInfoAdapter.ViewHolder(view);
        return infoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreInfo storeInfo = infoList.get(position);
        holder.title.setText(storeInfo.getTitle());
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.TitleText);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            portalClickListener.portalOnClick(clickedPosition);
        }
    }

}
