import java.util.Scanner;
public class lab1 {
public static void main(String[] args){
  

 Scanner input = new Scanner(System.in);

 char[] message;
 int[] frequency = new int[26];
 int maxFrequency = 0;
 int commonLetter = 0;
 int key;

 System.out.println("Enter the encrypted message:");
 String text = input.nextLine();

 message = text.toCharArray();


 for (int i = 0; i < message.length; i++) {

 char ch = Character.toUpperCase(message[i]);

 if (ch >= 'A' && ch <= 'Z') {
 int index = ch - 'A';
 frequency[index]++;
 }
 }

 for (int i = 0; i < 26; i++) {

 if (frequency[i] > maxFrequency) {
 maxFrequency = frequency[i];
 commonLetter = i;
 }
 }

 if (maxFrequency == 0) {
 System.out.println("No letters found in the message.");
 input.close();
 return;
 }

 
 System.out.println("\nLetter frequency analysis:");

 for (int i = 0; i < 26; i++) {

 if (frequency[i] > 0) {
 System.out.println((char)('A' + i) + " : " + frequency[i]);
 }
 }

 
 key = (commonLetter - ('E' - 'A') + 26) % 26;

 System.out.println("\nEstimated key: " + key);


 System.out.println("\nDecrypted message:");

 for (int i = 0; i < message.length; i++) {

 char ch = message[i];

 if (ch >= 'A' && ch <= 'Z') {
 ch = (char)('A' + (ch - 'A' - key + 26) % 26);
 }
 else if (ch >= 'a' && ch <= 'z') {
 ch = (char)('a' + (ch - 'a' - key + 26) % 26);
 }

 System.out.print(ch);
 }

 System.out.println();

 input.close();
 }
 

}
