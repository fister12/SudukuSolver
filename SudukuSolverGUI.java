import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SudokuSolverGUI {
  private JFrame frame;
  private JPanel panel;
  private JTextField[][] textFields;
  private JButton solveButton;

  public SudokuSolverGUI() {
    textFields = new JTextField[9][9];

    frame = new JFrame("Sudoku Solver");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel();
    panel.setLayout(new GridLayout(9, 9));

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        textFields[i][j] = new JTextField();
        panel.add(textFields[i][j]);
      }
    }

    solveButton = new JButton("Solve");
    solveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            try {
              grid[i][j] = Integer.parseInt(textFields[i][j].getText());
            } catch (NumberFormatException ex) {
              grid[i][j] = 0;
            }
          }
        }
        SudukuSolver solver = new SudukuSolver();
        solver.bestPlacement(grid);
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            textFields[i][j].setText(String.valueOf(grid[i][j]));
          }
        }
      }
    });
    panel.add(solveButton);

    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new SudokuSolverGUI();
  }
}
