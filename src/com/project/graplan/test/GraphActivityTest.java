package com.project.graplan.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;

import com.project.graplan.GraphActivity;

public class GraphActivityTest extends ActivityInstrumentationTestCase2<GraphActivity> 
{
	private Activity mActivity;
	
	public GraphActivityTest( ) {
		super("com.project.graplan.GraphActivity", GraphActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void setUp() throws Exception{
		Bundle challenge = new Bundle();
		Bundle vertices = new Bundle();
		Bundle edges = new Bundle();
		challenge.putBundle("vertices", vertices);
		challenge.putBundle("edges", edges);
		

		challenge.putInt("level", 2);
		challenge.putInt("currentSteps", 1);
		
		Intent mIntent = new Intent();
		mIntent.putExtras(challenge);
		setActivityIntent(mIntent);
		mActivity = getActivity();
	}
	
	public void testPreconditions(){
		assertNotNull( mActivity );
	}
	
	
}
