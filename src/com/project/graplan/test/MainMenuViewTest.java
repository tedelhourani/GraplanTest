/*
 * Copyright (C) 2011 Theodore Elhourani - ECE 573 
 * Project: Graplan
 * 
 * 
 */
package com.project.graplan.test;

import com.project.graplan.Constants;
import com.project.graplan.MainMenuView;
import com.project.graplan.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.util.Log;
import android.widget.Button;

public class MainMenuViewTest extends ActivityInstrumentationTestCase2<MainMenuView> {

	private Activity mActivity;
	
	public MainMenuViewTest( ) {
		super("com.project.graplan.MainMenuView", MainMenuView.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception{
		Intent mainMenuViewIntent = new Intent();
		mainMenuViewIntent.putExtra("level", "7");
		setActivityIntent(mainMenuViewIntent);
	}
	
	public void testPreconditions(){
	}
	
	@UiThreadTest
	public void testPlay(){
		mActivity = this.getActivity();
		Button playButton = (Button) mActivity.findViewById(R.id.play);
		playButton.performClick();
		Bundle message = ((MainMenuView) mActivity).getMessage();
		assertNotNull( message );
		assertNotNull( message.getInt(Constants.ACTION) );
		assertTrue( mActivity.isFinishing() );
	}
	
	@UiThreadTest
	public void testQuit(){
		mActivity = this.getActivity();
		Button button = (Button) mActivity.findViewById(R.id.quit);
		button.performClick();
		Bundle message = ((MainMenuView) mActivity).getMessage();
		assertNotNull( message );
		assertNotNull( message.getInt(Constants.ACTION) );
		Log.i("MainView Quit value: ", ""+message.getInt(Constants.ACTION));
		assertTrue( mActivity.isFinishing() );
	}
	
	@UiThreadTest
	public void testNonPlanar(){
		mActivity = this.getActivity();
		Button button = (Button) mActivity.findViewById(R.id.non_planar);
		button.performClick();
		Bundle message = ((MainMenuView) mActivity).getMessage();
		assertNotNull( message );
		assertNotNull( message.getInt(Constants.ACTION) );
		Log.i("MainView Nonplanar value: ", ""+message.getInt(Constants.ACTION));
		assertTrue( mActivity.isFinishing() );
	}
	
	@UiThreadTest
	public void testPlanar(){
		mActivity = this.getActivity();
		Button button = (Button) mActivity.findViewById(R.id.planar);
		button.performClick();
		Bundle message = ((MainMenuView) mActivity).getMessage();
		assertNotNull( message );
		assertNotNull( message.getInt(Constants.ACTION) );
		assertTrue( mActivity.isFinishing() );
	}
}
