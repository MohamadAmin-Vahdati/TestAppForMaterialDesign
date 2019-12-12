package com.mavp.testapp;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;


import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;


public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private List<Album> albumList;
    private MyViewHolder viewHolder ;
    private RelativeLayout layoutParent;
    private RecyclerView recyclerView ;
    private Context context ;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        MaterialTextView AlbumName, NumOfSongs , AlbumNameAbout , NumOfSongAbout , AlbumAbout;
        AppCompatImageView AlbumImage , btn_back;
        MaterialCardView cardView ;
        CollapsingToolbarLayout collapsingToolbarLayout ;
        MaterialToolbar materialToolbar ;
        CoordinatorLayout coordinatorLayout ;

        public MyViewHolder(View view) {
            super(view);
            AlbumName =  view.findViewById(R.id.AlbumName);
            NumOfSongs = view.findViewById(R.id.NumOfSong);
            AlbumImage =  view.findViewById(R.id.AlbumImage);

            cardView = view.findViewById(R.id.cardview);
            AlbumNameAbout = layoutParent.findViewById(R.id.AlbumNameAbout);
            NumOfSongAbout = layoutParent.findViewById(R.id.NumOfSongAbout);
            AlbumAbout = layoutParent.findViewById(R.id.AlbumAbout);
            collapsingToolbarLayout = layoutParent.findViewById(R.id.CollapsingToolbar);
            btn_back = layoutParent.findViewById(R.id.btn_back);
            materialToolbar = layoutParent.findViewById(R.id.toolbar);
            coordinatorLayout = layoutParent.findViewById(R.id.coordinatorLayout) ;

            Typeface typeface = Typeface.createFromAsset(context.getAssets(),"fonts/B Mitra Bold_YasDL.com_0.ttf");
            AlbumName.setTypeface(typeface);
            NumOfSongs.setTypeface(typeface);
            AlbumNameAbout.setTypeface(typeface);
            NumOfSongAbout.setTypeface(typeface);
            AlbumAbout.setTypeface(typeface);
        }

        public void bind (final Album album ){
            AlbumName.setText(album.getAlbumName());
            NumOfSongs.setText(album.getNumOfSongs()+" قطعه");
            AlbumImage.setBackgroundResource(album.getAlbumPic());
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                            coordinatorLayout.setVisibility(View.VISIBLE);
                            AlbumNameAbout.setText("آلبوم "+album.getAlbumName());
                            NumOfSongAbout.setText(album.getNumOfSongs()+" قطعه");
                            AlbumAbout.setText(album.getAlbumAbout());
                            collapsingToolbarLayout.setBackgroundResource(album.getAlbumPic());

                            recyclerView.setVisibility(View.GONE);
                            materialToolbar.setVisibility(View.GONE);

                }
            });
            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerView.setVisibility(View.VISIBLE);
                    materialToolbar.setVisibility(View.VISIBLE);
                    coordinatorLayout.setVisibility(View.GONE);
                }
            });



        }
    }


    public AlbumsAdapter(List<Album> albumList , RelativeLayout layoutParent, RecyclerView recyclerView , Context context) {
        this.albumList = albumList;
        this.layoutParent = layoutParent;
        this.recyclerView = recyclerView ;
        this.context = context ;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);
        viewHolder = new MyViewHolder(itemView) ;
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        viewHolder.bind(albumList.get(position));


    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}