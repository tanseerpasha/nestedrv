package com.example.tanseer.nestedrv;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Supreme on 8/18/2017.
 */

public class PrimaryAdapter extends RecyclerView.Adapter<PrimaryAdapter.PrimaryViewHolder> {

    private ArrayList<MovieGenre> mMovieGenre;
    private Context context;
    private String[] mActionMovies;
    private SecondaryAdapter adapter;
    private RecyclerView mSecondaryRecyclerView;

    public PrimaryAdapter(ArrayList<MovieGenre> movieGenre) {
        mMovieGenre = movieGenre;

    }

    public class PrimaryViewHolder extends RecyclerView.ViewHolder {
        private TextView mPrimaryMovieGenre, mPrimaryMore;


        private PrimaryViewHolder(View itemView) {
            super(itemView);
            mPrimaryMovieGenre = (TextView) itemView.findViewById(R.id.primary_movie_genre);
            mPrimaryMore = (TextView) itemView.findViewById(R.id.primary_movie_genre1);
            mSecondaryRecyclerView = (RecyclerView) itemView.findViewById(R.id.secondary_recycler_view);
        }

        // This get called in PrimaryAdapter onBindViewHolder method
        private void bindViews(Context context,MovieGenre genre, int position) {
            mPrimaryMovieGenre.setText(genre.getMovieGenre());

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                    context,
                    LinearLayoutManager.HORIZONTAL,
                    false
            );

            mSecondaryRecyclerView.setLayoutManager(linearLayoutManager);
            mSecondaryRecyclerView.setAdapter(getSecondaryAdapter(position));
        }
    }

    @Override
    public PrimaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.primary_recycler_view_item, parent, false);
        view.setFocusable(true);
        return new PrimaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PrimaryViewHolder holder, final int position) {
        MovieGenre genre = mMovieGenre.get(position);
        holder.bindViews(context, genre, position);

        holder.mPrimaryMore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked cell position " + position  , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovieGenre.size();
    }


    private class SecondaryViewHolder extends RecyclerView.ViewHolder {


        private ImageView mDishImage;
        private TextView mDishName;
        private ImageButton mDishType;
        private ImageButton mDishRatingIcon;
        private TextView mDishRatingNumber;
        private TextView mDishDeliveryTime;
        private TextView mDishPrice;
        private final View mView;

        private SecondaryViewHolder(View view) {
            super(view);
            mView = view;
            mDishImage = (ImageView) itemView.findViewById(R.id.dish_image);
            mDishName = (TextView) itemView.findViewById(R.id.dish_name);
            mDishType = (ImageButton) itemView.findViewById(R.id.dish_type);
            mDishRatingIcon = (ImageButton) itemView.findViewById(R.id.dish_rating_icon);
            mDishRatingNumber= (TextView) itemView.findViewById(R.id.dish_rating_number);
            mDishDeliveryTime = (TextView) itemView.findViewById(R.id.dish_delivery_time);
            mDishPrice = (TextView) itemView.findViewById(R.id.dish_price);


        }

        private void bindView(DishList dishList) {
            //mTextView.setText(name);
            mDishImage.setImageResource(dishList.getDishImage());
            mDishName.setText(dishList.getDishName());
            mDishType.setImageResource(dishList.getDishType());
            mDishRatingIcon.setImageResource(dishList.getDishRatingIcon());
            mDishRatingNumber.setText(dishList.getDishRatingNumber());
            mDishDeliveryTime.setText(dishList.getDishDeliveryTime());
            mDishPrice.setText(dishList.getDishPrice());


        }
    }

    private class SecondaryAdapter extends RecyclerView.Adapter<SecondaryViewHolder> {
        private ArrayList<DishList> mDishLists;

        private SecondaryAdapter(ArrayList<DishList> dishLists) {
            mDishLists = dishLists;
        }

        @Override
        public SecondaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            View view = LayoutInflater.from(context).inflate(R.layout.secondary_recycler_view_item, parent, false);
            view.setFocusable(true);
            return new SecondaryViewHolder(view);
        }

        @Override
        public void onBindViewHolder(SecondaryViewHolder holder, final int position) {
            DishList list = mDishLists.get(position);
            //holder.bindView(name);
            holder.bindView(list);

            holder.mView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    //callFragment(recipeStepSelected);
                    Toast.makeText(context, "You clicked cell position " + position  , Toast.LENGTH_SHORT).show();

                }
            });

        }

        @Override
        public int getItemCount() {
            return mDishLists.size();
        }
    }

    private SecondaryAdapter getSecondaryAdapter(int position) {

        SecondaryAdapter secondaryAdapter;
        ArrayList<DishList> mDishList = new ArrayList<DishList>();

        switch (position) {
            case 0:
                mActionMovies = new String[] {"Mission: Impossible – Rogue Nation",
                        "Mad Max: Fury Road", "Star Wars: The Force Awakens",
                        "Avengers: Age of Ultron", "Ant- Man","Terminator Genisys",        "Furious 7",              "Blackhat", "The Man from U.N.C.L.E",
                        "Jurassic World"
                };

                secondaryAdapter = new SecondaryAdapter(mDishList);
                DishList mMoviesAction1 = new DishList(R.mipmap.ic_launcher, "Chicken Biryani",
                        R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, "3.5", "45mins",
                        "$400");
                mDishList.add(mMoviesAction1);
                DishList mMoviesAction2 = new DishList(R.mipmap.ic_launcher, "Mutton Biryani",
                        R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, "4.5", "45mins",
                        "$600");
                mDishList.add(mMoviesAction2);
                DishList mMoviesAction3 = new DishList(R.mipmap.ic_launcher, "Egg Biryani",
                        R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, "4.0", "45mins",
                        "$300");
                mDishList.add(mMoviesAction3);
                DishList mMoviesAction4 = new DishList(R.mipmap.ic_launcher, "Veg Biryani",
                        R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, "4.5", "45mins",
                        "$300");
                mDishList.add(mMoviesAction4);
                secondaryAdapter.notifyDataSetChanged();

                return secondaryAdapter;
            case 1:
                mActionMovies = new String[] {"Mission: Impossible – Rogue Nation",
                        "Mad Max: Fury Road", "Star Wars: The Force Awakens",
                        "Avengers: Age of Ultron", "Ant- Man","Terminator Genisys",        "Furious 7",              "Blackhat", "The Man from U.N.C.L.E",
                        "Jurassic World"
                };
                secondaryAdapter = new SecondaryAdapter(mDishList);
                DishList mMoviesAdventure1 = new DishList(R.mipmap.ic_launcher, "Mutton Biryani",
                        R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, "3.5", "45mins",
                        "$400");
                mDishList.add(mMoviesAdventure1);
                DishList mMoviesAdventure2 = new DishList(R.mipmap.ic_launcher, "Chicken Biryani",
                        R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, "3.5", "45mins",
                        "$400");
                mDishList.add(mMoviesAdventure2);
                DishList mMoviesAdventure3 = new DishList(R.mipmap.ic_launcher, "Veg Biryani",
                        R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, "3.5", "45mins",
                        "$400");
                mDishList.add(mMoviesAdventure3);
                DishList mMoviesAdventure4 = new DishList(R.mipmap.ic_launcher, "Egg Biryani",
                        R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, "3.5", "45mins",
                        "$400");
                mDishList.add(mMoviesAdventure4);
                secondaryAdapter.notifyDataSetChanged();

                return secondaryAdapter;
            case 2:
                mActionMovies = new String[] {"Mission: Impossible – Rogue Nation",
                        "Mad Max: Fury Road", "Star Wars: The Force Awakens",
                        "Avengers: Age of Ultron", "Ant- Man","Terminator Genisys",        "Furious 7",              "Blackhat", "The Man from U.N.C.L.E",
                        "Jurassic World"
                };
                secondaryAdapter = new SecondaryAdapter(mDishList);
                DishList mMoviesComedy1 = new DishList(R.mipmap.ic_launcher, "Egg Biryani",
                        R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, "3.5", "45mins",
                        "$400");
                mDishList.add(mMoviesComedy1);
                DishList mMoviesComedy2 = new DishList(R.mipmap.ic_launcher, "Egg Biryani",
                        R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, "3.5", "45mins",
                        "$400");
                mDishList.add(mMoviesComedy2);
                DishList mMoviesComedy3 = new DishList(R.mipmap.ic_launcher, "Egg Biryani",
                        R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, "3.5", "45mins",
                        "$400");
                mDishList.add(mMoviesComedy3);
                DishList mMoviesComedy4 = new DishList(R.mipmap.ic_launcher, "Egg Biryani",
                        R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, "3.5", "45mins",
                        "$400");
                mDishList.add(mMoviesComedy4);
                secondaryAdapter.notifyDataSetChanged();

                return secondaryAdapter;


            default:
                return null;
        }
    }
}