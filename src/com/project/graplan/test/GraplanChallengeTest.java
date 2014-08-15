package com.project.graplan.test;

import java.util.LinkedList;

import junit.framework.TestCase;

import android.os.Bundle;
import android.test.mock.MockContext;

import com.project.graplan.GraplanChallenge;

public class GraplanChallengeTest extends TestCase {
	private GraplanChallenge gc;
		
	protected void setUp(){
		MockContext mc = new MockContext();
		gc = GraplanChallenge.getInstance(mc);
	}
	
	public void testPreconditions(){
		assertNotNull( gc );
	}
	
	/** test every time GraplanChallenge is constructed a challenge is available **/
	public void testGraplanChallenge(){
		assertTrue( (gc.getChallengeFile()).contains("challenge-") );
	}
	
	public void testGetChallenge(){
		assertNotNull( gc.getChallenge() );
		assertTrue( gc.getChallenge() instanceof Bundle);
	}
	
	public void testGetEdges(){
		assertNotNull( gc.getEdges() );
		assertTrue( gc.getEdges() instanceof LinkedList );
	}
	
	public void testTestPlanarity(){
		//assertNotNull( challenge );
		assertNotNull( gc.testPlanarity() );
	}
}
