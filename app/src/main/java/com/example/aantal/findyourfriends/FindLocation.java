package com.example.aantal.findyourfriends;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class FindLocation extends ListActivity {

    static final String[] FRIENDS = new String[]{"Bori", "Bogyo",
            "Baboca", "Quit!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_location);

        setListAdapter(new ArrayAdapter<>(this, R.layout.activity_find_location, FRIENDS));
        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (((((TextView) view).getText())).equals("Bori")) {
                    Intent i = new Intent(FindLocation.this, MapsActivity.class);
                    i.putExtra("name", "Bori");
                    startActivity(i);
                } else if (((((TextView) view).getText()))
                        .equals("Bogyo")) {
                    Intent i = new Intent(FindLocation.this, MapsActivity.class);
                    i.putExtra("name", "Bogyo");
                    startActivity(i);
                } else if (((((TextView) view).getText()))
                        .equals("Baboca")) {
                    Intent i = new Intent(FindLocation.this, MapsActivity.class);
                    i.putExtra("name", "Baboca");
                    startActivity(i);
                } else if (((((TextView) view).getText())).equals("Quit!")) {
                    finish();
                }
            }
        });
    }

}