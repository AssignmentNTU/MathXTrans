package com.example.edwardsujono.mathxtrans.search;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edwardsujono.mathxtrans.R;
import com.example.edwardsujono.mathxtrans.manager.SearchManager;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by edwardsujono on 18/5/17.
 */

public class Search extends Fragment {

    private final static int CAMERA_REQUEST = 1888;


    /* DEFINE YOUR COMPONENT HERE  */
    private FloatingActionButton fab;
    private ImageView imageView;
    private Button button;
    private TextView textView;
    private byte[] byteImage;

    // other manager
    private SearchManager searchManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.search_activity, container, false);

        fab = (FloatingActionButton) myView.findViewById(R.id.take_picture);
        imageView = (ImageView) myView.findViewById(R.id.take_picture_image);
        button = (Button) myView.findViewById(R.id.translate_button);
        textView = (TextView) myView.findViewById(R.id.text_area_translation);

        searchManager = new SearchManager();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (byteImage != null){
                    searchManager.callAPITranslate(textView, byteImage);
                }
            }
        });


        return myView;
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byteImage = stream.toByteArray();
            imageView.setImageBitmap(photo);
        }
    }



}
