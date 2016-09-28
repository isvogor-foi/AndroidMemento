package hr.heureka.memento.viewholders;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.heureka.memento.R;
import hr.heureka.memento.adapters.ActiveTasksRecycleViewAdapter;
import hr.heureka.memento.database.Task;

/**
 * Created by ivan on 1.9.2016..
 */
public class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
    public ActiveTasksRecycleViewAdapter adapter;

    // povezivanje sa grafičkim elementima
    @Bind(R.id.tv_rv_name)
    public TextView taskTitle;

    @Bind(R.id.tv_rv_deadline)
    public TextView taskDate;

    @Bind(R.id.lv_category)
    public LinearLayout linearLayout;

    private Context context;
    private List<Task> mItems;

    // konstruktor prima parametar trenutnog pogleda, adapter i elemente liste koje će prikazati
    public TaskViewHolder(final View itemView, ActiveTasksRecycleViewAdapter adapter, List<Task> mItems) {
        super(itemView);

        ButterKnife.bind(this, itemView);
        this.context = itemView.getContext();

        // slušaj longClick događaj
        itemView.setOnLongClickListener(this);

        this.adapter = adapter;
        this.mItems = mItems;
    }

    @Override
    public boolean onLongClick(View view) {
        AlertDialog dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle(context.getString(R.string.dialog_title_long));
        dialog.setButton(AlertDialog.BUTTON_NEUTRAL, context.getString(R.string.delete), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                // dohvati element i obriši ga iz baze podataka
                mItems.get(getAdapterPosition()).delete();
                // dohvati element liste i obriši ga iz liste
                mItems.remove(getAdapterPosition());
                // dojavi listi da je došlo do promjena kako bi se ažurirala
                adapter.notifyDataSetChanged();

                dialog.dismiss();
            }
        });
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, context.getString(R.string.completed), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Task selectedTask = mItems.get(getAdapterPosition());

                // ako trenutni zadatak nije završen, postavi mu svojstvo završenost
                if(selectedTask.getCompleted() == 0) {
                    selectedTask.setCompleted(1);
                    selectedTask.save();
                    // nakon pohrane u bazi podataka, pomakni ga na drugi tab (završenih)
                    mItems.remove(getAdapterPosition());
                    adapter.notifyDataSetChanged();
                }

                dialog.dismiss();
            }
        });
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, context.getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        dialog.show();

        return false;
    }
}
