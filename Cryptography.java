package assignment1;
/**
 *Importing Scanner utility available in java package library.
 *The Scanner utility is used to get user input.
 */
import java.util.Scanner;
/**
 * This is the Cryptography class.
 * To create an object "keyboard", that is used to take input from user, in form of a message.
 * That message with the help of a shift key from the user aswell is further processed according to Caesar Cipher technique.
 * @author Qanitah Danial.
 */
public class Cryptography {
	    public static void main(String[] args) 
	    {
	        Scanner keyboard = new Scanner(System.in); //Create a new Scanner object
	        System.out.println("The Caesar Cipher Technique"); //Header
	        System.out.println("Enter any character"); 
	        System.out.print("Enter a message: ");//Ask user to input message to be encrypted.
	        String message = keyboard.nextLine();
	        System.out.print("Enter the shift key: ");//Ask user to enter a shift key, on the basis of which encyrption will move
	        int shift = keyboard.nextInt();

	        String encryptedmsg = encrypt(message, shift);
	        System.out.println("Encrypted message: " + encryptedmsg);//Displaying encrypted message

	        String decryptedmsg = decrypt(encryptedmsg, shift);
	        System.out.println("Decrypted message: " + decryptedmsg);//Displaying decrypted message

	        keyboard.close();//Indicating to close keyboard input
	    }

	    /**
	     * Encyrpts a message using cipher caesar through the shift value
	     * @param message - the message user entered
	     * @param shift - shift key value
	     * @return
	     */
	    public static String encrypt(String message, int shift) 
	    {
	        String encryptedmsg = "";//encyrpted message is null, will be assigned whatever user inputs
	        int msgLength = message.length();//Analyzing message length
	      /**
	       * This loop will be used to iterate through each character in the input message
	       * 'i' is the current character
	       * 
	       */
	        for (int i = 0; i < msgLength; i++) 
	        {
	            char c = message.charAt(i);
	            /**
	             * Check if the characters entered are uppercase or lowercase
	             * one by one encyrpting each character by shifting the character
	             */
	            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) 
	            {
	                char base = (c >= 'A' && c <= 'Z') ? 'A' : 'a';
	                char encryptedChar = (char) (((c - base + shift) % 26) + base);
	                encryptedmsg += encryptedChar;
	            } else 
	            {
	                encryptedmsg += c; //add to the the encrypted character's result
	            }
	        }
	        return encryptedmsg;
	    }
/**
 * Encyrpts a message using cipher caesar through the negative shift value
 * @param encryptedmsg - the encypted message
 * @param shift - negative shift for anticlockwise movement
 * @return
 */
	    public static String decrypt(String encryptedmsg, int shift) 
	    {
	        return encrypt(encryptedmsg, -shift);
	    }
}