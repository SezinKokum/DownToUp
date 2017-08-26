package com.tatlicilar.downtoup;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v7.widget.SearchView;


import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        sv= (SearchView) findViewById(R.id.mSearch);
        RecyclerView rv= (RecyclerView) findViewById(R.id.myRecycler);
        //SET ITS PROPETRIES
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        //ADAPTER
        final MyAdapter adapter=new MyAdapter(this,getKisiler());
        rv.setAdapter(adapter);
        //SEARCH
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                adapter.getFilter().filter(query);
                return false;
            }
        });
    }
    //ADD PLAYERS TO ARRAYLIST
    private ArrayList<AramaKisiler> getKisiler()
    {
        ArrayList<AramaKisiler> kisiler=new ArrayList<>();
        AramaKisiler kisi=new AramaKisiler();
        kisi.setName("Ander Herera");
        kisi.setPos("Midfielder");
        kisi.setImg(R.drawable.shakira);
        kisiler.add(kisi);
        kisi=new AramaKisiler();
        kisi.setName("David De Geaa");
        kisi.setPos("Goalkeeper");
        kisi.setImg(R.drawable.shakira);
        kisiler.add(kisi);
        return kisiler;
    }
}