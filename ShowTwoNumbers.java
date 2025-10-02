import javax.swing.JOptionPane;
public class ShowTwoNumbers {
	public static void main(String[] args) {
		String strNum1, strNum2;
		String notification = "You've just entered: ";
		strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", 
				"Input the first number", JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", 
				"Input the second number", JOptionPane.INFORMATION_MESSAGE);
		double doubleNum1 = Double.parseDouble(strNum1);
		double doubleNum2 = Double.parseDouble(strNum2);
		JOptionPane.showMessageDialog(null, "The sum of the two numbers is " + (doubleNum1 + doubleNum2));
		JOptionPane.showMessageDialog(null, "The difference of the two numbers is " + (doubleNum1 - doubleNum2));
		JOptionPane.showMessageDialog(null, "The product of two the numbers is " + (doubleNum1 * doubleNum2));
		
		if (doubleNum2 != 0) { 
				JOptionPane.showMessageDialog(null, "The division of the two numbers is " + (doubleNum1 / doubleNum2));
		} else {
			JOptionPane.showMessageDialog(null, "Second number cannot be 0 for divison");
		}
	}
}
