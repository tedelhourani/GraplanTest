package com.project.graplan.test;

import java.util.Hashtable;
import junit.framework.TestCase;
import android.test.mock.MockContext;
import com.project.graplan.GraplanUtils;

public class GraplanUtilsTest extends TestCase {
	private GraplanUtils utils;
		
	protected void setUp(){
		MockContext mc = new MockContext();
		utils = new GraplanUtils(mc);
	}
	
	public void testPreconditions(){
		assertNotNull( utils );
	}
	
	public void testGetXmlPullParser() {
		final String state = "state.xml";
		final String challenge = "challenge-0.xml";
		final String directory = "/data/data/com.project.graplan/files/";
		assertNotNull(utils);
		assertNotNull(utils.getXmlPullParser(directory + state));
		assertNotNull(utils.getXmlPullParser(directory + challenge));
	}

	public void testXmlChallengeToEdgeArrays() {
		final String challenge = "challenge-0.xml";
		final String directory = "/data/data/com.project.graplan/files/";
		assertNotNull(utils);
		assertNotNull(utils.xmlChallengeToEdgeArrays(directory + challenge));
	}

	public void testXmlChallengeToBundle() {
		final String challenge = "challenge-0.xml";
		final String directory = "/data/data/com.project.graplan/files/";
		assertNotNull(utils);
		assertNotNull(utils.xmlChallengeToBundle(directory + challenge));
	}

	public void testXmlUnsolvedChallengeList() {
		final String state = "state.xml";
		final String directory = "/data/data/com.project.graplan/files/";
		assertNotNull(utils);
		assertTrue(utils.xmlUnsolvedChallengeList(directory + state) instanceof Hashtable);
		Hashtable<String, String> ht = ((Hashtable<String, String>) utils
				.xmlUnsolvedChallengeList(directory + state));
		assertNotNull( ht );
	}

}
