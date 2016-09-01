package hr.heureka.memento.webservice;

import java.util.ArrayList;

import hr.heureka.memento.entities.WsNewsItem;

/**
 * Created by ivan on 11.7.2016..
 */
public class WsResponse {
    public int count;
    public ArrayList<WsNewsItem> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<WsNewsItem> getResults() {
        return results;
    }

    public void setResults(ArrayList<WsNewsItem> results) {
        this.results = results;
    }
}
