package com.example.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

public class imageHelper {
    public static Bitmap handleImageEffect(Bitmap bm,float hue,float saturation,float lum){
    	Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);//最高处理模式
    	Canvas canvas = new Canvas(bmp);
    	Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    	
    	ColorMatrix hueMatrix = new ColorMatrix();//色相
    	hueMatrix.setRotate(0, hue);//0时修改的是red,1修改的是green，2修改的是blue
    	hueMatrix.setRotate(1, hue);
    	hueMatrix.setRotate(2, hue);
    	
    	ColorMatrix saturationMatrix = new ColorMatrix();//baohedu
    	saturationMatrix.setSaturation(saturation);
    	
    	ColorMatrix lumMatrix = new ColorMatrix();
    	lumMatrix.setScale(lum, lum, lum, 1);
    	
    	ColorMatrix imageMatrix = new ColorMatrix();//融合
    	imageMatrix.postConcat(hueMatrix);
    	imageMatrix.postConcat(saturationMatrix);
    	imageMatrix.postConcat(lumMatrix);
    	
    	paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));//画笔
    	canvas.drawBitmap(bm, 0, 0,paint);
    	
		return bmp;
    	
    }
    public static Bitmap handleImageNegative(Bitmap bm){
    	int width = bm.getWidth();
    	int height = bm.getHeight();
    	int color;
    	int r,g,b,a;
    	Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
    	int[] oldPx = new int[width*height];
    	int[] newPx = new int[width*height];
    	bm.getPixels(oldPx, 0, width, 0, 0, width, height);
    	for(int i = 0;i<width*height;i++){
    		color = oldPx[i];
    		r = Color.red(color);
    		g = Color.green(color);
    		b = Color.blue(color);
    		a = Color.alpha(color);
    		
    		r = 255 - r;
    		g = 255 - g;
    		b = 255 - b;
    		if(r>255){
    			r = 255;
    		}else if(r<0){
    			r = 0;
    		}
    		if(g>255){
    			g = 255;
    		}else if(g<0){
    			g = 0;
    		}
    		if(b>255){
    			b = 255;
    		}else if(b<0){
    			b = 0;
    		}
    		newPx[i] = Color.argb(a, r, g, b);
    	}
    	bmp.setPixels(newPx, 0, width, 0, 0, width, height);
		return bmp;
    	
    }
    public static Bitmap handleImageOldPhoto(Bitmap bm){
    	int width = bm.getWidth();
    	int height = bm.getHeight();
    	int color;
    	int r,g,b,a;
    	Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
    	int[] oldPx = new int[width*height];
    	int[] newPx = new int[width*height];
    	bm.getPixels(oldPx, 0, width, 0, 0, width, height);
    	for(int i = 0;i<width*height;i++){
    		color = oldPx[i];
    		r = Color.red(color);
    		g = Color.green(color);
    		b = Color.blue(color);
    		a = Color.alpha(color);
    		
    		r = (int)(0.393 * r + 0.769 *g + 0.189 *b);
    		g = (int)(0.349 * r + 0.686 *g + 0.168 *b);
    		b = (int)(0.272 * r + 0.534 *g + 0.131 *b);
    		if(r>255){
    			r = 255;
    		}
    		if(g>255){
    			g = 255;
    		}
    		if(b>255){
    			b = 255;
    		}
    		newPx[i] = Color.argb(a, r, g, b);
    	}
    	bmp.setPixels(newPx, 0, width, 0, 0, width, height);
		return bmp;
    	
    }
    public static Bitmap handleImagePixelsRelief(Bitmap bm){
    	int width = bm.getWidth();
    	int height = bm.getHeight();
    	int color;
    	int colorBefore;
    	int r,g,b,a;
    	int r1,g1,b1;
    	Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
    	int[] oldPx = new int[width*height];
    	int[] newPx = new int[width*height];
    	bm.getPixels(oldPx, 0, width, 0, 0, width, height);
    	for(int i = 1;i<width*height;i++){//注意
    		colorBefore = oldPx[i-1];
    		r = Color.red(colorBefore);
    		g = Color.green(colorBefore);
    		b = Color.blue(colorBefore);
    		a = Color.alpha(colorBefore);
    		color = oldPx[i];
    		r1 = Color.red(color);
    		g1 = Color.green(color);
    		b1 = Color.blue(color);
    		
    		r = (r-r1+127);
    		g = (g-g1+127);
    		b = (b-b1+127);
    		if(r>255){
    			r = 255;
    		}
    		if(g>255){
    			g = 255;
    		}
    		if(b>255){
    			b = 255;
    		}
    		newPx[i] = Color.argb(a, r, g, b);
    	}
    	bmp.setPixels(newPx, 0, width, 0, 0, width, height);
		return bmp;
    	
    }
}
