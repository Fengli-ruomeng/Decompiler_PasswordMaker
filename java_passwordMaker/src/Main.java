import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        setTitle("PasswordMaker V1.0");
        setBounds(300, 200, 350, 180);
        Container cp = getContentPane();
        cp.setLayout(null);
        JLabel jl = new JLabel("加密/解密前");
        jl.setBounds(10, 10, 200, 50);
        final JTextField password1 = new JTextField();
        password1.setBounds(140, 16, 170, 30);
        JLabel jl2 = new JLabel("加密/解密后");
        jl2.setBounds(10, 50, 200, 50);
        final JTextField password = new JTextField();
        password.setBounds(140, 61, 170, 30);
        cp.add(jl);
        cp.add(password1);
        cp.add(jl2);
        cp.add(password);
        JButton jb = new JButton("加密");
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (password1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"加密框不允许为空");
                }else {
                    String s = password1.getText();
                    StringBuilder sb = new StringBuilder();
                    for (int x = 0 ; x < s.length() ; x++){
                        int l = s.charAt(x) + 2;
                        sb.append((char)l);
                    }
                    password.setText(sb.toString());
                }
            }
        });
        jb.setBounds(50, 110, 80, 20);
        cp.add(jb);

        final JButton button = new JButton();
        button.setText("解密");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (password1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"解密框不允许为空");
                }else {
                    String s = password1.getText();
                    StringBuilder sb = new StringBuilder();
                    for (int x = 0 ; x < s.length() ; x++){
                        int l = s.charAt(x) - 2;
                        sb.append((char)l);
                    }
                    password.setText(sb.toString());
                }
            }
        });
        button.setBounds(150, 110, 80, 20);
        getContentPane().add(button);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

}

