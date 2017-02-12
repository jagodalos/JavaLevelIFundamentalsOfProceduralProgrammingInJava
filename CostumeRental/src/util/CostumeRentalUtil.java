package util;

public class CostumeRentalUtil {
	
	public static boolean isBlankOrNull(String value){
		if(value == null || value.isEmpty()){
			return true;
		}
		return false;
	}
	
}
