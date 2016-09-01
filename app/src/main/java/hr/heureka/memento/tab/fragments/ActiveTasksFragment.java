package hr.heureka.memento.tab.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.heureka.memento.R;
import hr.heureka.memento.adapters.ActiveTasksRecycleViewAdapter;
import hr.heureka.memento.entities.DbTask;
import hr.heureka.memento.helpers.DialogHelper;
import hr.heureka.memento.helpers.MockDataLoader;

/**
 * Created by ivan on 4.7.2016..
 */
public class ActiveTasksFragment extends Fragment {

    @Bind(R.id.rv_active_tasks)
    RecyclerView recycleView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_active_tasks, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // prikazadi RecyclerView uvijek iste veličine, bez obzira na broj elemenata koje prikazuje
        recycleView.setHasFixedSize(true);

        // trenutnom ReyclerView-u pridružiti objekt za pozicioniranje pogleda (LayoutManager)
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recycleView.setLayoutManager(llm);

        // postavljanje adaptera
        recycleView.setAdapter(new ActiveTasksRecycleViewAdapter(MockDataLoader.getDemoData(),getContext()));
    }

    @OnClick(R.id.fab)
    public void onFabClicked(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        View dialogView = getActivity().getLayoutInflater().inflate(R.layout.task_dialog, null);

        dialog.setView(dialogView);

        final DialogHelper dialogHelper = new DialogHelper(getContext(), dialogView);

        dialog.setTitle(getString(R.string.dialog_title));
        dialog.show();

    }

}


