package Lab03.OtherProjects.Lab01;

import javax.swing.JOptionPane;
public class QuadraticEquation {
	public static void main (String[] args) {
		while (true) {
			String strNum1 = JOptionPane.showInputDialog("Please enter the coefficient a: ");
			String strNum2 = JOptionPane.showInputDialog("Please enter the coefficient b: ");
			String strNum3 = JOptionPane.showInputDialog("Please enter the coefficient c: ");
			double doubleA = Double.parseDouble(strNum1);
			double doubleB = Double.parseDouble(strNum2);
			double doubleC = Double.parseDouble(strNum3);
			
			if (doubleA == 0) {
				JOptionPane.showConfirmDialog(null, "a cannot be 0.");
				continue; // do not stop until user enter valid value
			}
			
			double delta = doubleB * doubleB - 4 * doubleA * doubleC;
			
			if (delta >= 0) {
				JOptionPane.showMessageDialog(null, "The first solution is: " 
						+ ((- doubleB - Math.sqrt(delta)) / (2 * doubleA)));
				JOptionPane.showMessageDialog(null, "The second solution is: " 
						+ ((- doubleB + Math.sqrt(delta)) / (2 * doubleA)));
				break;
			
			} else {
				JOptionPane.showMessageDialog(null, "The equation has no solution.");
				break;
			}
		}
	}
}
