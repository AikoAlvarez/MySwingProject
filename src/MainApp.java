import com.customui.components.CustomButton;
import com.customui.components.CustomTextField;
import com.customui.components.GradientPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainApp extends JFrame {

    public MainApp (){
        setTitle("Custom UI Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 500);
        setLocationRelativeTo(null);

        // fondo principal con gradiente
        GradientPanel mainBackground = new GradientPanel(
            new Color (17,24,39),
            new Color (31,41,55),
            0
        );

        mainBackground.setLayout(new GridBagLayout());
        setContentPane(mainBackground);

        // Contenedor central para el Login
        GradientPanel loginCard = new GradientPanel(
            new Color(255,255,255),
            new Color (249,250,251),
            24
        );
        loginCard.setLayout(new BoxLayout(loginCard, BoxLayout.Y_AXIS));
        loginCard.setBorder(new EmptyBorder(30,30,30,30));

        // titulo del encabezado 
        JLabel lblTitulo = new JLabel("Welcome Back");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(17, 24, 39));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        // Inputs
        CustomTextField txtEmail = new CustomTextField ("Email", 20);
        txtEmail.setMaximumSize(new Dimension(300,40));
    
        CustomTextField txtPassword = new CustomTextField("Password", 20);
        txtPassword.setMaximumSize(new Dimension(300,40));

        // Custom Button
        CustomButton btnLogin = new CustomButton("Sign In");
        btnLogin.setMaximumSize (new Dimension(300,42));
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Action Event
        btnLogin.addActionListener(e ->{
            String email = txtEmail.getText();
            JOptionPane.showMessageDialog(this, "Logging in with: " + email);
        });

        // Layout
        loginCard.add(lblTitulo);
        loginCard.add(Box.createRigidArea(new Dimension(0,25)));
        loginCard.add(txtEmail);
        loginCard.add(Box.createRigidArea(new Dimension(0, 15)));
        loginCard.add(txtPassword);
        loginCard.add(Box.createRigidArea(new Dimension(0, 25)));
        loginCard.add(btnLogin);

        mainBackground.add(loginCard);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainApp().setVisible(true);
        });
    }
}