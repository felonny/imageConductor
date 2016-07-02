package com.example.image;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class PixeisEffect extends Activity{
	private ImageView imageView1,imageView2,imageView3,imageView4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pixeis_effect);
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.text4);
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView2 = (ImageView) findViewById(R.id.imageView2);
		imageView3 = (ImageView) findViewById(R.id.imageView3);
		imageView4 = (ImageView) findViewById(R.id.imageView4);
		
		imageView1.setImageBitmap(bitmap);
		imageView2.setImageBitmap(imageHelper.handleImageNegative(bitmap));
		imageView3.setImageBitmap(imageHelper.handleImageOldPhoto(bitmap));
		imageView4.setImageBitmap(imageHelper.handleImagePixelsRelief(bitmap));
	}

}
