import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.Locale;

import javax.swing.*;
import javax.xml.stream.Location;

public class Main extends JFrame {

    public boolean canParseInt(String str){
        if(str == null){
            return false;
        }
        return str.matches("\\d+");
    }

    public Main() {
        setTitle("PasswordMaker V3");
        setLocation(100,100);
        setBounds(300, 200, 340, 170);
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        JLabel jl = new JLabel("加密/解密前");
        jl.setBounds(10, 10, 200, 50);

        final JTextField password1 = new JTextField();
        password1.setBounds(140, 16, 170, 30);
        JLabel jl2 = new JLabel("加密/解密后");
        jl2.setBounds(10, 50, 200, 50);

        final JTextField nm = new JTextField();
        nm.setBounds(100,16,30,30);

        final JTextField password = new JTextField();
        password.setBounds(140, 61, 170, 30);
        cp.add(jl);
        cp.add(password1);
        cp.add(jl2);
        cp.add(password);
        cp.add(nm);
        JButton jb = new JButton("加密");
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (!canParseInt(nm.getText())){
                    JOptionPane.showMessageDialog(null,"加密码必须是一个整数!");
                    return;
                }
                if (password1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"加密框不允许为空");
                }else {
                    String s = password1.getText();
                    StringBuilder sb = new StringBuilder();
                    for (int x = 0 ; x < s.length() ; x++){
                        int l = s.charAt(x) + Integer.parseInt(nm.getText());
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
                if (!canParseInt(nm.getText())){
                    JOptionPane.showMessageDialog(null,"加密码必须是一个整数!");
                    return;
                }
                if (password1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"解密框不允许为空");
                }else {
                    String s = password1.getText();
                    StringBuilder sb = new StringBuilder();
                    for (int x = 0 ; x < s.length() ; x++){
                        int l = s.charAt(x) - Integer.parseInt(nm.getText());
                        sb.append((char)l);
                    }
                    password.setText(sb.toString());
                }
            }
        });
        button.setBounds(150, 110, 80, 20);
        getContentPane().add(button);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JOptionPane.showMessageDialog(null,"加密器很简单,但是他用法绝对没有看上去那么简单.");
        JOptionPane.showMessageDialog(null,"多重加密,多重解密,混淆加密和没加密的代码.");
        JOptionPane.showMessageDialog(null,"希望你用的上,代码会一直更新,每次的加密方法都会改.");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

}

