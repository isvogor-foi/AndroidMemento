package hr.heureka.memento.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.List;

import hr.heureka.memento.R;
import hr.heureka.memento.database.Task;
import hr.heureka.memento.viewholders.TaskViewHolder;

/**
 * Created by ivan on 5.7.2016..
 */
public class ActiveTasksRecycleViewAdapter  extends RecyclerView.Adapter<TaskViewHolder>{


    List<Task> taskItems;
    Context context;

    public ActiveTasksRecycleViewAdapter(List<Task> taskItems, Context context){
        super();
        this.context = context;
        this.taskItems = taskItems;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.task_item, viewGroup, false);
        return new TaskViewHolder(v, this, taskItems);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder viewHolder, int i) {
        viewHolder.taskTitle.setText(taskItems.get(i).getName());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MMM.yyyy, HH:mm", context.getResources().getConfiguration().locale);

        viewHolder.taskDate.setText(sdf.format(taskItems.get(i).getDueDate().getTime()));
        //Task.getCategory(taskItems.get(i).getId()).getColor();
        viewHolder.linearLayout.setBackgroundColor(Color.parseColor(taskItems.get(i).getCategory().getColor()));
        //Category
        //Category color = SQLite.select().from(Category.class).where(Task_Table.id.is(taskItems.get(i).getId())).querySingle();

        //List<Task> tasks = SQLite.select().from(Task.class).queryList();
        //for(Task task : tasks){
        //    System.out.println("Task: " + task.getCategory().getName());
        //}
    }

    @Override
    public int getItemCount() {
        return taskItems.size();
    }

}