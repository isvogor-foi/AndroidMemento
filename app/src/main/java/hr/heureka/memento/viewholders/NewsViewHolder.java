package hr.heureka.memento.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.heureka.memento.R;

/**
 * Created by ivan on 11.7.2016..
 */
public class NewsViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.rv_ni_name)
    public TextView tvName;

    @Bind(R.id.rv_ni_date)
    public TextView tvDate;

    @Bind(R.id.rv_ni_image)
    public ImageView tvImage;

    public NewsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
