package Lab03.OtherProjects.Lab01.JavaBasics.src;





import java.util.Scanner;
public class InputFromKeyboard {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What's your name?");
		String StrName = keyboard.nextLine();
		System.out.println("How old are you?");
		int iAge = keyboard.nextInt();
		System.out.println("How tall are you (m)?");
		double dHeight = keyboard.nextDouble();
		
		keyboard.close();
		
		System.out.println("Mrs/Ms. " + StrName + "," + iAge + "years old. "
				+ "Your height is " + dHeight + ".");
	}
}
