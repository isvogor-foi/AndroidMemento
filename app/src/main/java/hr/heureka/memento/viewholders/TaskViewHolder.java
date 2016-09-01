package hr.heureka.memento.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.heureka.memento.R;
import hr.heureka.memento.adapters.ActiveTasksRecycleViewAdapter;
import hr.heureka.memento.entities.DbTask;

/**
 * Created by ivan on 1.9.2016..
 */
public class TaskViewHolder extends RecyclerView.ViewHolder{
    public ActiveTasksRecycleViewAdapter adapter;

    // povezivanje sa grafičkim elementima
    @Bind(R.id.tv_rv_name)
    public TextView taskTitle;

    @Bind(R.id.tv_rv_deadline)
    public TextView taskDate;

    @Bind(R.id.lv_category)
    public LinearLayout linearLayout;

    private Context context;
    private List<DbTask> mItems;

    // konstruktor prima parametar trenutnog pogleda, adapter i elemente liste koje će prikazati
    public TaskViewHolder(final View itemView, ActiveTasksRecycleViewAdapter adapter, List<DbTask> mItems) {
        super(itemView);

        ButterKnife.bind(this, itemView);
        this.context = itemView.getContext();

        this.adapter = adapter;
        this.mItems = mItems;
    }
}
