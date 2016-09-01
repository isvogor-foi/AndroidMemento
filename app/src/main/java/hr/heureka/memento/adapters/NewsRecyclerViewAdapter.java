package hr.heureka.memento.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import hr.heureka.memento.R;
import hr.heureka.memento.entities.WsNewsItem;
import hr.heureka.memento.viewholders.NewsViewHolder;

/**
 * Created by ivan on 11.7.2016..
 */
public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    ArrayList<WsNewsItem> newsItems;
    Context context;

    public NewsRecyclerViewAdapter(ArrayList<WsNewsItem> newsItems, Context context){
        this.newsItems = newsItems;
        this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MMM.yyyy, HH:mm", context.getResources().getConfiguration().locale);

        holder.tvName.setText(newsItems.get(position).getName());
        holder.tvDate.setText(sdf.format(newsItems.get(position).getDate().getTime()));

        // učitavanje slike sa weba
        Picasso.with(context).load(context.getResources().getString(R.string.image_ws)+ newsItems.get(position).getImage_path())
                .resize(64, 64)
                .centerCrop()
                .into(holder.tvImage);
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }
}
