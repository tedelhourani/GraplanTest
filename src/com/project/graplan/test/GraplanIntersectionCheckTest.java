/*
 * Copyright (C) 2011 Theodore Elhourani - ECE 573 
 * Project: Graplan
 * 
 * 
 */

package com.project.graplan.test;

import com.project.graplan.GraplanIntersectionCheck;

import android.os.Bundle;
import junit.framework.TestCase;

public class GraplanIntersectionCheckTest extends TestCase {

	protected void setUp(){
	}
	
	public void testHasIntersectingEdges(){
		Bundle vertices = new Bundle();
		Bundle edges = new Bundle();
		Bundle graph = new Bundle();

		vertices.putString("1","3"+","+"9");
		vertices.putString("2","6"+","+"3" );
		vertices.putString("3","0"+","+"3" );
		vertices.putString("4","6"+","+"6" );
		
		edges.putString("1"+","+"2", "anycolor");
		edges.putString("3"+","+"4", "anycolor");
		
		graph.putBundle("vertices", vertices);
		graph.putBundle("edges", edges);
		
		assertTrue( GraplanIntersectionCheck.
				hasIntersectingEdges( graph ));
	}
	
	public void testSingleEdge(){
		Bundle vertices = new Bundle();
		Bundle edges = new Bundle();
		Bundle graph = new Bundle();

		vertices.putString("1","3"+","+"9");
		vertices.putString("2","6"+","+"3" );
		//vertices.putString("3","0"+","+"3" );
		//vertices.putString("4","6"+","+"6" );
		
		edges.putString("1"+","+"2", "anycolor");
		//edges.putString("2","3"+","+"4");
		
		graph.putBundle("vertices", vertices);
		graph.putBundle("edges", edges);
		
		assertFalse( GraplanIntersectionCheck.
				hasIntersectingEdges( graph ));
	}
	
	public void testParallelEdges(){
		Bundle vertices = new Bundle();
		Bundle edges = new Bundle();
		Bundle graph = new Bundle();

		vertices.putString("1","3"+","+"0");
		vertices.putString("2","0"+","+"3" );
		vertices.putString("3","6"+","+"0" );
		vertices.putString("4","0"+","+"6" );
		
		edges.putString("1"+","+"2", "anycolor");
		edges.putString("3"+","+"4", "anycolor");
		
		graph.putBundle("vertices", vertices);
		graph.putBundle("edges", edges);
		
		assertFalse( GraplanIntersectionCheck.
				hasIntersectingEdges( graph ));
	}
	
	public void testIntersectOutsideRangeEdges(){
		Bundle vertices = new Bundle();
		Bundle edges = new Bundle();
		Bundle graph = new Bundle();

		vertices.putString("1","3"+","+"0");
		vertices.putString("2","0"+","+"3" );
		vertices.putString("3","4.5"+","+"0" );
		vertices.putString("4","0"+","+"6" );
		
		edges.putString("1"+","+"2", "anycolor");
		edges.putString("3"+","+"4", "anycolor");
		
		graph.putBundle("vertices", vertices);
		graph.putBundle("edges", edges);
		
		assertFalse( GraplanIntersectionCheck.
				hasIntersectingEdges( graph ));
	}

	public void testTwoEdgeIntersect(){
		Bundle vertices = new Bundle();
		Bundle edges = new Bundle();
		Bundle graph = new Bundle();

		vertices.putString("1","0"+","+"3");
		vertices.putString("2","3"+","+"0" );
		vertices.putString("3","0"+","+"3.2" );
		
		edges.putString("1"+","+"2", "anycolor");
		edges.putString("2"+","+"3", "anycolor");
		//edges.putString("3"+","+"1", "anycolor");
		
		graph.putBundle("vertices", vertices);
		graph.putBundle("edges", edges);
		
		assertFalse( GraplanIntersectionCheck.
				hasIntersectingEdges( graph ));
	}
	
	public void testTriangleIntersect(){
		Bundle vertices = new Bundle();
		Bundle edges = new Bundle();
		Bundle graph = new Bundle();

		vertices.putString("1","0"+","+"3");
		vertices.putString("2","3"+","+"0" );
		vertices.putString("3","3"+","+"6" );
		
		edges.putString("1"+","+"2", "anycolor");
		edges.putString("2"+","+"3", "anycolor");
		edges.putString("3"+","+"1", "anycolor");
		
		graph.putBundle("vertices", vertices);
		graph.putBundle("edges", edges);
		
		assertFalse( GraplanIntersectionCheck.
				hasIntersectingEdges( graph ));
	}
}
