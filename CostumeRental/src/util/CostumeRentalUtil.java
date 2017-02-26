package util;

public class CostumeRentalUtil {
	
	public static boolean isBlankOrNull(String value){
		if(value == null || value.isEmpty()){
			return true;
		}
		return false;
	}
	
	public static java.sql.Timestamp getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
}
