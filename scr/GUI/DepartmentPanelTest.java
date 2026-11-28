
package GUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DepartmentPanelTest {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Department Management");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setSize(800, 500);

            frame.setLocationRelativeTo(null);

            frame.add(new DepartmentPanel());

            frame.setVisible(true);
        });
    }
}
