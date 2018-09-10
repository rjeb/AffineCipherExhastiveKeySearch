import java.util.Scanner;

//exhastive key search for Affine cipher
public class Main {
	public static void main(String[] args) {
		int iteration = 1;
		String plainText;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a sample plaintext:");
		plainText = scanner.nextLine();
		for(int i = 0; i < 12; i++) {
			for(int d = 0; d < 26; d++) {
				//prints the cipher text for every key out of the 312 sized keyspace
				Cipher tempCipher = new Cipher(i+1, d+1);
				String cipherText = tempCipher.genCipherText(plainText);
				System.out.println(""+ iteration+":" + cipherText);
				iteration++;
			}
		}
		scanner.close();
	}
}
