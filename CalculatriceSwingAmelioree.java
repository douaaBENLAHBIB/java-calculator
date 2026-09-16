import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

    public class CalculatriceSwingAmelioree extends JFrame {
        private JTextField champNombre1, champNombre2;
        private JComboBox<String> listeOperations;
        private JLabel labelResultat;

        public CalculatriceSwingAmelioree() {
            setTitle("Calculatrice Avancée");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(450, 350);


            JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


            JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

            champNombre1 = new JTextField(10);
            champNombre2 = new JTextField(10);

            String[] operations = {"Addition (+)", "Soustraction (-)", "Multiplication (*)", "Division (/)"};
            listeOperations = new JComboBox<>(operations);

            inputPanel.add(new JLabel("Premier nombre :"));
            inputPanel.add(champNombre1);
            inputPanel.add(new JLabel("Deuxième nombre :"));
            inputPanel.add(champNombre2);
            inputPanel.add(new JLabel("Opération :"));
            inputPanel.add(listeOperations);


            JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            labelResultat = new JLabel("Résultat : ");
            labelResultat.setFont(new Font("Arial", Font.BOLD, 16));
            resultPanel.add(labelResultat);


            JButton boutonCalculer = new JButton("Calculer");
            boutonCalculer.setFont(new Font("Arial", Font.BOLD, 14));
            boutonCalculer.setBackground(new Color(70, 130, 180));
            boutonCalculer.setForeground(Color.WHITE);


            boutonCalculer.addActionListener((ActionEvent e) -> {
                calculerResultat();
            });


            mainPanel.add(inputPanel, BorderLayout.NORTH);
            mainPanel.add(boutonCalculer, BorderLayout.CENTER);
            mainPanel.add(resultPanel, BorderLayout.SOUTH);

            add(mainPanel);
            setLocationRelativeTo(null);
        }

        private void calculerResultat() {
            try {
                double n1 = Double.parseDouble(champNombre1.getText());
                double n2 = Double.parseDouble(champNombre2.getText());
                String operation = (String) listeOperations.getSelectedItem();
                double resultat = 0;

                if (operation.contains("Addition")) resultat = n1 + n2;
                else if (operation.contains("Soustraction")) resultat = n1 - n2;
                else if (operation.contains("Multiplication")) resultat = n1 * n2;
                else if (operation.contains("Division")) {
                    if (n2 == 0) {
                        JOptionPane.showMessageDialog(this, "Division par zéro impossible !");
                        return;
                    }
                    resultat = n1 / n2;
                }

                labelResultat.setText(String.format("Résultat : %.2f", resultat));

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Erreur : Veuillez entrer des nombres valides !",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new CalculatriceSwingAmelioree().setVisible(true);
            });
        }
    }

