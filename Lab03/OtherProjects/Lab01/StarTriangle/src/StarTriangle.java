import javax.swing.*;

public class StarTriangle {
    public static void main(String[] args) {
        String strHeight = JOptionPane.showInputDialog("Please enter the height of the triangle: ");
        int intHeight = Integer.parseInt(strHeight);

        String blank = " ";
        String star = "*";
        StringBuilder triangle = new StringBuilder();

        for (int i = 1; i <= intHeight; i++) {
            triangle.append(blank.repeat(intHeight - i))
                    .append(star.repeat(2 * i - 1))
                    .append("\n");
        }

        JTextArea textArea = new JTextArea(triangle.toString());
        textArea.setFont(new java.awt.Font("Courier New", java.awt.Font.PLAIN, 14));
        textArea.setEditable(false);

        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), 
                                      "Star Triangle", JOptionPane.PLAIN_MESSAGE);
    }
}