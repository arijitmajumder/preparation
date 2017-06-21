package test;

public class RegexValidation {

	public static void main(String[] args) {
		String regexp="[()*%;\\+/=&><?#*\"]";
		//String regexpWorking="^[\\p{L}0-9 _.'-]{0,100}+$";
		String regexpWorking="^[\\p{L}0-9 _.'-]{0,100}+$";
		String name="asda+sd";
		System.out.println(name.matches(regexpWorking));
		
	}
}
