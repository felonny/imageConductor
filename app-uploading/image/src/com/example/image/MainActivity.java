package com.example.image;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btnPrimaryColor(View view){
		startActivity(new Intent(this,PrimaryColor.class));
	}
	public void btnColorMatrix(View view){
		startActivity(new Intent(this,ColorMatrix.class));
	}
	public void PixelsEffect(View view){
		startActivity(new Intent(this,PixeisEffect.class));
	}
}
