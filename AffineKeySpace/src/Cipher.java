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
	
	public String genCipherText(String input) {
		input = input.toLowerCase();
		String returnString = "";
		for (int i = 0; i < input.length(); i++) {
			char in = input.charAt(i);
			int charNum = (chars.indexOf(in));
			//calculates ciphertext value of character
			//using the affine cipher
			charNum = ((keyA * charNum) + keyB) % 26;
			returnString += chars.get(charNum);
		}
		
		return returnString;
	}
}
