package utilityFuctions;

public class functions {
	
	 public static boolean is_Valid_Password(String password) {

	        if (password.length() < 10	) return false;

	        int charCount = 0;
	        int numCount = 0;
	        for (int i = 0; i < password.length(); i++) {

	            char ch = password.charAt(i);

	            if (is_Numeric(ch)) numCount++;
	            else if (is_UpperLetter(ch)) charCount++;
	            else if (is_LowerLetter(ch)) charCount++;
	            else return false;
	        }


	        return (charCount >= 2 && numCount >= 2);
	    }

	    public static boolean is_UpperLetter(char ch) {
	        ch = Character.toUpperCase(ch);
	        return (ch >= 'A' && ch <= 'Z');
	    }
	    
	    public static boolean is_LowerLetter(char ch) {
	        ch = Character.toUpperCase(ch);
	        return (ch >= 'a' && ch <= 'z');
	    }


	    public static boolean is_Numeric(char ch) {

	        return (ch >= '0' && ch <= '9');
	    }


}
