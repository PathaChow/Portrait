package com.example.portrait;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.GridView;
import android.view.View;
import android.widget.AdapterView;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    int currentTab;
    GridView clothGrid;
    GridView tabList;
    GridView colorGrid;

    int bottoms[]={R.drawable.longskirt,R.drawable.pants,R.drawable.shorts,R.drawable.skirt,R.drawable.none};
    int tops[]={R.drawable.hoodie,R.drawable.longsleeve,R.drawable.tshirt,R.drawable.tanktop,R.drawable.none};
    int layer[]={R.drawable.suit,R.drawable.vest,R.drawable.wind,R.drawable.none};
    int pattern[]={R.drawable.pattern,R.drawable.none};
    int body[]={R.drawable.unknown,R.drawable.white,R.drawable.asian,R.drawable.pacific,R.drawable.black};
    int tabs[]={R.string.str0,R.string.str1,R.string.str2,R.string.str3,R.string.str4};
    int colors[]={R.color.Red,R.color.Black,R.color.DarkOrange,R.color.Yellow,R.color.Green,R.color.Gray,R.color.Pink,R.color.Violet,R.color.Blue,R.color.DarkGreen};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentTab =0;

        clothGrid = (GridView) findViewById(R.id.bottom_grids);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), tops);
        clothGrid.setAdapter(customAdapter);
        clothGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                updateClothing(position);
                // change the according clothing part
            }
        });

        tabList = (GridView) findViewById(R.id.tabs);
        ListAdapter listAdapter = new ListAdapter(getApplicationContext(),tabs);
        tabList.setAdapter(listAdapter);
        tabList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentTab = position;
                updateGrid();
            }
        });

        colorGrid = (GridView) findViewById(R.id.color_grids);
        ColorAdapter colorAdapter = new ColorAdapter(getApplicationContext(), colors);
        colorGrid.setAdapter(colorAdapter);
        colorGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                updateColor(position);
                // change the according clothing part
            }
        });
    }

    private void updateGrid(){
        CustomAdapter customAdapter;
        if(currentTab==0){
            customAdapter = new CustomAdapter(getApplicationContext(), tops);
        }else if(currentTab==1){
            customAdapter = new CustomAdapter(getApplicationContext(), bottoms);
        }else if(currentTab==2){
            customAdapter = new CustomAdapter(getApplicationContext(), layer);
        }else if(currentTab==3){
            customAdapter = new CustomAdapter(getApplicationContext(), pattern);
        }else{
            customAdapter = new CustomAdapter(getApplicationContext(), body);
        }
        clothGrid.setAdapter(customAdapter);
    }

    private void updateClothing(int position){
        ImageView piece;
        if(currentTab==0) {
            piece = (ImageView) findViewById(R.id.shirtImg);
            if(tops[position]==R.drawable.none){
                piece.setImageResource(android.R.color.transparent);
                return;
            }
            piece.setImageResource(tops[position]);
        }else if(currentTab==1){
            piece = (ImageView) findViewById(R.id.pantsImg);
            if(bottoms[position]==R.drawable.none){
                piece.setImageResource(android.R.color.transparent);
                return;
            }
            piece.setImageResource(bottoms[position]);
        }else if(currentTab==2){
            piece = (ImageView) findViewById(R.id.layerImg);
            if(layer[position]==R.drawable.none){
                piece.setImageResource(android.R.color.transparent);
                return;
            }
            piece.setImageResource(layer[position]);
        }else if(currentTab==3){
            piece = (ImageView) findViewById(R.id.patternImg);
            if(pattern[position]==R.drawable.none){
                piece.setImageResource(android.R.color.transparent);
                return;
            }
            piece.setImageResource(pattern[position]);
        }else{
            piece = (ImageView) findViewById(R.id.bodyImg);
            piece.setImageResource(body[position]);
        }

    }

    private void updateColor(int position){
        ImageView piece;
        if(currentTab==0) {
            piece = (ImageView) findViewById(R.id.shirtImg);
        }else if(currentTab==1){
            piece = (ImageView) findViewById(R.id.pantsImg);
        }else if(currentTab==2){
            piece = (ImageView) findViewById(R.id.layerImg);
        }else if(currentTab==3){
            piece = (ImageView) findViewById(R.id.patternImg);
        }else{
            return;
        }
        if(piece.getDrawable()!=null){
            DrawableCompat.setTint(
                    DrawableCompat.wrap(piece.getDrawable()),
                    ContextCompat.getColor(getApplicationContext(),colors[position])
            );
        }
        return;
    }
}
