/*
 * Copyright (C) 2011 Theodore Elhourani - ECE 573 
 * Project: Graplan
 * 
 * 
 */

package com.project.graplan.test;


import com.project.graplan.GraplanChallenge;
import com.project.graplan.GraplanUtils;
import com.project.graplan.StateController;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

public class StateControllerTest extends
		ActivityInstrumentationTestCase2<StateController> {

	private GraplanChallenge challenge;
	private GraplanUtils utils;
	private Activity mActivity;
	private boolean windowFocus;
	
	public StateControllerTest() {
		super("com.project.graplan.StateController",StateController.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		// must also mock the MainMenuView and the GraphActivity Activities here
		// this activity once started it automatically starts the mainmenuview activity
		// if not handled properly it will be stuck in the mainmenuview
		mActivity = this.getActivity();
		challenge = (getActivity()).getGraplanChallenge();
		utils = challenge.getGraplanUtils();
		windowFocus = mActivity.hasWindowFocus();
	}
	
	public void testPreconditions(){
		assertNotNull(mActivity);
		assertNotNull(challenge);
		assertNotNull(utils);
		assertFalse( windowFocus );
	}
}
