package intuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class amazon2 
{

	public static void main(String[] args) {
		try {
			readInp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readInp() throws IOException
	{
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/

        //Scanner
        Scanner s = new Scanner(System.in);
        String input = s.next();
        
        System.out.println("input "+input);
        String[] inp = input.split(",");
        int i = s.nextInt();
        int j = s.nextInt();
        longestValidParentheses(inp, i, j);
	}
	
	public static void longestValidParentheses(String[] inp, int i, int j) 
	{
		int temp1 = i;
		int temp2 = j;
		List<String> op = new ArrayList<>();
		for(String x:inp)
		{
			if(temp1 != 0)
			{
				op.add(x);
				temp1--;
			}
			else if(temp1 == 0 && temp2!=0)
			{
				temp2--;
                if(temp2 == 0){
                    temp1=i;
                    temp2=j;
                }
			}
		}
		StringBuilder builder = new StringBuilder();
		for (String value : op) {
		    builder.append(value).append(",");
		}
		String text = builder.substring(0,builder.length()-1);
		System.out.println(text);
	}
}
