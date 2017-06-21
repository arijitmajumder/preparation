package test;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Test{

	public static void main(String[] args) {
		new Test().calculateExecutionTime("mnuaL7HBQHyy7md0I_kHia");
	}
	
	private Date calculateExecutionTime(String agentID) {
		try {
			if (null != agentID) {
				byte[] buffer = new byte[1024];
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				byte[] dis = md5.digest(agentID.getBytes("UTF-8"));
				BigInteger bigInt = new BigInteger(1,dis);
				int int32Digit = bigInt.intValue();
				int time = int32Digit%120;
				String hashtext = bigInt.toString(16);
				System.out.println(dis);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return DateTime.now().plusDays().toDateTime(DateTimeZone.UTC).toDate();
		return null;
	}
}
