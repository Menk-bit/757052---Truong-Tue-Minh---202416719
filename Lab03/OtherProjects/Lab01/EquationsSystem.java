import javax.swing.JOptionPane;

public class EquationsSystem {
	public static void main(String[] args) {
		String strCoeffA11, strCoeffA12, strCoeffA21, strCoeffA22, strCoeffB1, strCoeffB2; 
		strCoeffA11 = JOptionPane.showInputDialog(null, "Please input the A11 coefficient: ", 
				"Input A11: ", JOptionPane.INFORMATION_MESSAGE);
		strCoeffA12 = JOptionPane.showInputDialog(null, "Please input the A12 coefficient: ", 
				"Input A12: ", JOptionPane.INFORMATION_MESSAGE);
		strCoeffB1 = JOptionPane.showInputDialog(null, "Please input the B1 coefficient: ", 
				"Input A22: ", JOptionPane.INFORMATION_MESSAGE);
		strCoeffA21 = JOptionPane.showInputDialog(null, "Please input the A21 coefficient: ", 
				"Input A21: ", JOptionPane.INFORMATION_MESSAGE);
		strCoeffA22 = JOptionPane.showInputDialog(null, "Please input the A22 coefficient: ", 
				"Input B1: ", JOptionPane.INFORMATION_MESSAGE);
		strCoeffB2 = JOptionPane.showInputDialog(null, "Please input the B2 coefficient: ", 
				"Input B2: ", JOptionPane.INFORMATION_MESSAGE);
		
		double doubleCoeffA11 = Double.parseDouble(strCoeffA11);
		double doubleCoeffA12 = Double.parseDouble(strCoeffA12);
		double doubleCoeffA21 = Double.parseDouble(strCoeffA21);
		double doubleCoeffA22 = Double.parseDouble(strCoeffA22);
		double doubleCoeffB1 = Double.parseDouble(strCoeffB1);
		double doubleCoeffB2 = Double.parseDouble(strCoeffB2);
	
		if ((doubleCoeffA11 / doubleCoeffA21) == (doubleCoeffA12 / doubleCoeffA22)) {
			if ((doubleCoeffA11 / doubleCoeffA21) == (doubleCoeffB1 / doubleCoeffB2)) {
				JOptionPane.showMessageDialog(null, "The System has infinite solutions.");
			} else {
				JOptionPane.showMessageDialog(null, "The System has no solutions.");
			}
		} else {
			double ratio = doubleCoeffA11 / doubleCoeffA21;
			double x2 = (doubleCoeffB2 * ratio - doubleCoeffB1) / (doubleCoeffA22 * ratio - doubleCoeffA12);
			double x1 = (doubleCoeffB1 - doubleCoeffA12 * x2) / doubleCoeffA11;
			JOptionPane.showMessageDialog(null, "The solution is:" + '\n' +
							"The first value: " + x1 + "\nThe second value: " + x2);
		}
	}
}
