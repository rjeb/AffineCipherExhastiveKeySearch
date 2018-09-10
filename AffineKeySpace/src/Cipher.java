import java.util.ArrayList;
import java.util.Arrays;

public class Cipher {
	//keys for Affine Cipher
	int keyA, keyB;
	
	ArrayList<Character> chars = new ArrayList<Character>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l',
		'm','n','o','p','q','r','s','t','u','v','w','x','y','z'));
	
	public Cipher(){
		this.keyA = 0;
		this.keyB = 0;
	}
	
	public Cipher(int i) {
		this.keyA = 0;
		this.keyB = i;
	}
	
	public Cipher(int i, int d) {
		this.keyA = i;
		this.keyB = d;
	}
	
	private int modInverse(int x, int div) 
    { 
        int mod = x % div; 
        for (int i = 1; i < div; i++) 
           if ((mod * i) % div == 1) 
              return i; 
        return 1; 
    } 
	
	public String genCipherText(String input) {
		input = input.toLowerCase();
		String returnString = "";
		for (int i = 0; i < input.length(); i++) {
			char in = input.charAt(i);
			int charNum = (chars.indexOf(in));
			//calculates ciphertext value of character
			//using the affine cipher
			charNum = ((modInverse(keyA, 26)) * (charNum - keyB)) % 26;
			//correction for negative numbers from modulo
			if (charNum < 0) {
				charNum = 26 + charNum;
			}
			returnString += chars.get(charNum);
		}
		
		return returnString;
	}
}
