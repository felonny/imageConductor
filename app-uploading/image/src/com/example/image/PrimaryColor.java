package com.example.image;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class PrimaryColor extends Activity implements SeekBar.OnSeekBarChangeListener{
	private ImageView mImageview;
	private SeekBar mSeekbarhue,mSeekbarSaturation,mSeekbarLum;
	//设置刻度值
	private static int MAX_VALUE = 255;
	private static int MID_VALUE = 127;
	
	private float mHue,mSaturation,mLum;
	
	private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.primarycolor);
    	bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test1);
    	mImageview = (ImageView) findViewById(R.id.imageview);
    	mSeekbarhue = (SeekBar) findViewById(R.id.seekbarHue);
    	mSeekbarSaturation = (SeekBar) findViewById(R.id.seekbarSaturation);
    	mSeekbarLum = (SeekBar) findViewById(R.id.seekbarLum);
    	
    	mSeekbarhue.setOnSeekBarChangeListener(this);
    	mSeekbarSaturation.setOnSeekBarChangeListener(this);
    	mSeekbarLum.setOnSeekBarChangeListener(this);
    	
    	mSeekbarhue.setMax(MAX_VALUE);
    	mSeekbarSaturation.setMax(MAX_VALUE);
    	mSeekbarLum.setMax(MAX_VALUE);
    	
    	//最初的时候停留位置
    	mSeekbarhue.setProgress(MID_VALUE);
    	mSeekbarSaturation.setProgress(MID_VALUE);
    	mSeekbarLum.setProgress(MID_VALUE);
    	
    	mImageview.setImageBitmap(bitmap);
    }
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		switch (seekBar.getId()) {
		case R.id.seekbarHue:
			mHue = (progress-MID_VALUE)*1.0F/MID_VALUE *180;
			break;
        case R.id.seekbarSaturation:
			mSaturation = progress *1.0F/MID_VALUE;
			break;
        case R.id.seekbarLum:
	        mLum = progress *1.0F/MID_VALUE;
	        break;
		default:
			break;
		}
		mImageview.setImageBitmap(imageHelper.handleImageEffect(bitmap, mHue, mSaturation, mLum));;
	}
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
}
