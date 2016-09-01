package hr.heureka.memento.tab.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.heureka.memento.R;
import hr.heureka.memento.adapters.ActiveTasksRecycleViewAdapter;
import hr.heureka.memento.entities.DbTask;
import hr.heureka.memento.helpers.DataFragment;


/**
 * Created by ivan on 4.7.2016..
 */
public class CompleteTasksFragment extends Fragment implements DataFragment {

    @Bind(R.id.rv_completed_tasks)
    RecyclerView recycleView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_complete_tasks, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recycleView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recycleView.setLayoutManager(llm);

        recycleView.setAdapter(new ActiveTasksRecycleViewAdapter(DbTask.getAll(1), getContext()));

    }

    @Override
    public void reloadData() {
        recycleView.setAdapter(new ActiveTasksRecycleViewAdapter(DbTask.getAll(1), getContext()));

    }
}
