package com.example.tectdepot.spaceapp;


import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageGalleryDialog {
    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 1;

    public static void showDialog(Context context, int imageRes, int position, int[] images) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.image_gallery_dialog);

        ImageView imageView = dialog.findViewById(R.id.dialogImageView);
        imageView.setImageResource(imageRes);

        ImageView btnClose = dialog.findViewById(R.id.btnClose);
        ImageView btnForward = dialog.findViewById(R.id.btnForward);
        ImageView btnBack = dialog.findViewById(R.id.btnBack);
        ImageView btnDownload = dialog.findViewById(R.id.btnDownload);

        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();

        int imagesSize = images.length - 1;
        final int[] currentImageIndex = {position};

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentImageIndex[0] == imagesSize) {
                    currentImageIndex[0] = 0;
                } else {
                    currentImageIndex[0]++;
                }

                imageView.setImageResource(images[currentImageIndex[0]]);
                Toast.makeText(context, "" + currentImageIndex[0], Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentImageIndex[0] == 0) {
                    currentImageIndex[0] = imagesSize;
                } else {
                    --currentImageIndex[0];
                }

                imageView.setImageResource(images[currentImageIndex[0]]);
                Toast.makeText(context, "" + currentImageIndex[0], Toast.LENGTH_SHORT).show();
            }
        });

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }



}



