package com.example.tanseer.nestedrv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Supreme on 8/18/2017.
 */

public class PrimaryRecyclerViewFragment extends Fragment {

    private RecyclerView mPrimaryRecyclerView;
    private String[] mActionMovies;
    private ArrayList<MovieGenre> mMovieGenre = new ArrayList<MovieGenre>();
    private PrimaryAdapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mActionMovies = new String[] {"Mission: Impossible – Rogue Nation",
                "Mad Max: Fury Road", "Star Wars: The Force Awakens",
                "Avengers: Age of Ultron", "Ant- Man","Terminator Genisys",        "Furious 7",              "Blackhat", "The Man from U.N.C.L.E",
                "Jurassic World"
        };

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.primary_recycler_view, container, false);

        // Creating the primary recycler view adapter
        adapter = new PrimaryAdapter(mMovieGenre);

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getActivity(),
                LinearLayoutManager.VERTICAL,
                false
        );

        mPrimaryRecyclerView = (RecyclerView) view.findViewById(R.id.primary_recycler_view);
        mPrimaryRecyclerView.setLayoutManager(layoutManager);
        mPrimaryRecyclerView.setAdapter(adapter);
        prepareData();
        return view;
    }

    private void prepareData(){

        MovieGenre mMoviesGenre1 = new MovieGenre("Action");
        mMovieGenre.add(mMoviesGenre1);
        MovieGenre mMoviesGenre2 = new MovieGenre("Adventure");
        mMovieGenre.add(mMoviesGenre2);
        MovieGenre mMoviesGenre3 = new MovieGenre("Comedy");
        mMovieGenre.add(mMoviesGenre3);
        MovieGenre mMoviesGenre4 = new MovieGenre("Historical");
        mMovieGenre.add(mMoviesGenre4);
        adapter.notifyDataSetChanged();





    }






}
