package hr.heureka.memento.tab.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import hr.heureka.memento.R;

/**
 * Created by ivan on 4.7.2016..
 */
public class ActiveTasksFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_active_tasks, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

}


