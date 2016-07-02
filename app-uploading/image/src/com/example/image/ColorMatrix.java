package com.example.image;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

public class ColorMatrix extends Activity{
	private ImageView mImageview;
	private GridLayout mGroup;
	private Bitmap bitmap;
	private int mEtWidth,mEtHeight;
	private EditText[] mEts = new EditText[20];
	private float[] mColorMatrix = new float[20];
 @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.color_matrix);
	bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.text4);
	mImageview = (ImageView) findViewById(R.id.imageview);
	mGroup = (GridLayout) findViewById(R.id.group);
	mImageview.setImageBitmap(bitmap);
	mGroup.post(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//如果把这两个方法直接放在oncreate方法中只能都得到0
			mEtWidth = mGroup.getWidth()/5;
			mEtHeight = mGroup.getHeight()/4;
			addEts();
			initMatrix();
		}
	});
}
     private void getMatrix(){
    	 for(int i=0;i<20;i++){
    		 mColorMatrix[i] = Float.valueOf(mEts[i].getText().toString());
    	 }
     }
     private void setImageMatrix(){
    	 Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),Bitmap.Config.ARGB_8888);
    	 android.graphics.ColorMatrix ColorMatrix = new android.graphics.ColorMatrix();
    	 ColorMatrix.set(mColorMatrix);//矩阵
    	 Canvas canvas = new Canvas(bmp);
    	 Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿
    	 paint.setColorFilter(new ColorMatrixColorFilter(ColorMatrix));//画笔
    	 canvas.drawBitmap(bitmap, 0, 0, paint);
    	 mImageview.setImageBitmap(bmp);
     }
     public void btnChange(View view){
    	 getMatrix();
    	 setImageMatrix();
     }
     public void btnReset(View view){
    	 initMatrix();
    	 getMatrix();
    	 setImageMatrix();
     }
     private void addEts(){
    	 for(int i = 0;i<20;i++){
    		 EditText editText = new EditText(ColorMatrix.this);
    		 mEts[i]  = editText;
    		 mGroup.addView(editText,mEtWidth,mEtHeight);
    	 }
     }
     private void initMatrix(){
    	 for(int i = 0;i<20;i++){
    		 if(i % 6 == 0){
    			 mEts[i].setText(String.valueOf(1));
    		 }else{
    			 mEts[i].setText(String.valueOf(0));
    		 }
    	 }
     }
}
