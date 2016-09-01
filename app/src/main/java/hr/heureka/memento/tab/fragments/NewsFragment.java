package hr.heureka.memento.tab.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.heureka.memento.R;
import hr.heureka.memento.adapters.NewsRecyclerViewAdapter;
import hr.heureka.memento.entities.WsNewsItem;
import hr.heureka.memento.webservice.WsDataLoader;

/**
 * Created by ivan on 4.7.2016..
 */
public class NewsFragment extends Fragment {

    @Bind(R.id.rv_news_items)
    RecyclerView recyclerView;
    WsDataLoader dl;
    ProgressDialog progress;


    //WsDataLoader klasi prosljedi
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, rootView);
        dl = new WsDataLoader();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());

        ArrayList<WsNewsItem> items = new ArrayList<>();
        recyclerView.setLayoutManager(llm);

        if (dl.getFetchedNewsArray() != null) {
            recyclerView.setAdapter(new NewsRecyclerViewAdapter(dl.getFetchedNewsArray(), getContext()));
        }
    }

    // nakon pritiska FAB-a podigni dialog za učitavanje s porukom
    // instanci WsDataLoader-a prosljedi referencu na sebe (za pristup metodi showLoadedData)
    @OnClick(R.id.button)
    public void clicked(View v) {
        dl.loadDataFromWebService(this);
        progress = ProgressDialog.show(getActivity(), getString(R.string.loading), getString(R.string.loading_message), true);
    }

    // postavi podatke (poziva se iz WsDataLoaderKlase)
    public void showLoadedData(ArrayList<WsNewsItem> newsItems) {
        recyclerView.setAdapter(new NewsRecyclerViewAdapter(newsItems, getContext()));
        progress.dismiss();

    }
}
