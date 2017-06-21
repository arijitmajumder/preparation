package symantec.cuttingedge;

import java.util.Set;
import java.util.TreeSet;

public class BTLDay1 {

	public static void getStrongWall(int noOfPoints,String pointDetails,int noOfWalls,String wallDetails)
    {
		Set<Points> pointList = new TreeSet();
	    if(null != pointDetails)
	    {
	    	String[] pointArr = pointDetails.split("(?<=\\)),(?=\\()");
	    	for(String str: pointArr)
	    	{
	    		
	    	}
	    }
    }
	
	public static void main(String[] args) {
		getStrongWall(0,"(1,1),(8,1),(4,2),(7,2),(2,3),(4,3),(6,3),(2,5),(4,5),(6,5),(4,6),(7,6),(1,8),(4,8),(8,8)",0,null);
	}
}

class Points implements Comparable<Points>
{
	Integer x1;
	Integer y1;
	
	public Points(Integer x1, Integer y1) {
		super();
		this.x1 = x1;
		this.y1 = y1;
	}

	@Override
	public int compareTo(Points o) {
		int comp = this.x1.compareTo(o.x1);
		if(comp==0)
			return this.y1.compareTo(o.y1);
		return comp;
	}
	
}