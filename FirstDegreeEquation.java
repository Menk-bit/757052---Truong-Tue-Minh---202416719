import javax.swing.JOptionPane;
public class FirstDegreeEquation {
	public static void main (String[] args) {
		String strNum1 = JOptionPane.showInputDialog("Please enter the coefficient a: ");
		String strNum2 = JOptionPane.showInputDialog("Please enter the coefficient b: ");
		double doubleNum1 = Double.parseDouble(strNum1);
		double doubleNum2 = Double.parseDouble(strNum2);
		if (doubleNum1 == 0) {
			if (doubleNum2 == 0) {
				JOptionPane.showMessageDialog(null, "Inifinitely many solutions.");
			} else {
				JOptionPane.showMessageDialog(null, "No solutions");
			}
		} else {
			JOptionPane.showMessageDialog(null, "One unique solution: " + (- doubleNum2/doubleNum1));
		}
	}
}
