package strings;

public class PrintStringInReverse 
{
	public void reverseString(String str)
	{
		if(null != str)
		{
			String[] strArr = str.split(" ");
			StringBuilder sb = new StringBuilder();
			for(String strTemp : strArr)
			{
				sb.append(new StringBuffer(strTemp).reverse()).append(" ");
			}
			sb.trimToSize();
			System.out.println(sb.toString());
		}
	}
	
	public static void main(String[] args) {
		String s = "Gagan is a boy.";
		new PrintStringInReverse().reverseString(s);
	}
}
