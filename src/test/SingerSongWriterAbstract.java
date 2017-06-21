package test;

import java.util.Collections;

public class SingerSongWriterAbstract implements Songwriter,Singer
{

	public int asd;
	
	public static void main(String[] args) { 
		SingerSongWriterAbstract asd = new SingerSongWriterAbstract();
		Songwriter sq = new SingerSongWriterAbstract();
		Singer si =  new SingerSongWriterAbstract();
		System.out.println(asd.compose(false));
		System.out.println(sq.compose(false));
		System.out.println(si.compose(false));
		
	}

	@Override
	public String compose(boolean hit) {
		// TODO Auto-generated method stub
		return "asd";
	}
}
