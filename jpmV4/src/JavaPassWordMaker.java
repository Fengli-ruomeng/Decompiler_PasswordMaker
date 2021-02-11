import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class JavaPassWordMaker extends JFrame {

    String Code = "0-000";

    public boolean canParseInt(String str){
        if(str == null){
            return true;
        }
        return !str.matches("\\d+");
    }
    public void SetCode(){
        StringBuilder code = new StringBuilder();
        code.append('[');
        if (checkBox1.isSelected()) code.append('T'); else code.append('F');
        code.append('-');
        code.append(textField3.getText());
        code.append(']');
        Code = code.toString();
    }

    public JavaPassWordMaker() {
        initComponents();
        //加密
        okButton.addActionListener(arg0 -> {
            if (canParseInt(textField3.getText())){
                JOptionPane.showMessageDialog(null,"加密码必须是一个整数!");
                return;
            }
            if (textField1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"加密框不允许为空");
            }
            String s = textField1.getText();
            StringBuilder sb = new StringBuilder();
            if (checkBox1.isSelected()){
                for (int x = 0; x < s.length(); x++) {
                    int l = s.charAt(x) - Integer.parseInt(textField3.getText()) - 2;
                    sb.append((char) l);
                    textField2.setText(sb.toString());
                }
            }else {
                for (int x = 0; x < s.length(); x++) {
                    int l = s.charAt(x) + Integer.parseInt(textField3.getText());
                    sb.append((char) l);
                    textField2.setText(sb.toString());
                }
            }
            if (AutoCopy.isSelected()){
                StringSelection stsel = new StringSelection(textField2.getText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel,stsel);
            }
            SetCode();
        });
        //解密
        cancelButton.addActionListener(e -> {
            if (canParseInt(textField3.getText())){
                JOptionPane.showMessageDialog(null,"加密码必须是一个整数!");
                return;
            }
            if (textField1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "解密框不允许为空");
                return;
            }
            String s = textField1.getText();
            StringBuilder sb = new StringBuilder();
            if (checkBox1.isSelected()){
                for (int x = 0; x < s.length(); x++) {
                    int l = s.charAt(x) + Integer.parseInt(textField3.getText()) + 2;
                    sb.append((char) l);
                    textField2.setText(sb.toString());
                }
            }else {
                for (int x = 0; x < s.length(); x++) {
                    int l = s.charAt(x) - Integer.parseInt(textField3.getText());
                    sb.append((char) l);
                    textField2.setText(sb.toString());
                }
            }
            if (AutoCopy.isSelected()){
                StringSelection stsel = new StringSelection(textField2.getText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel,stsel);
            }
            SetCode();
        });
        //重置
        Reset.addActionListener( b -> {
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
        });
        //禁止输入
        textField2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                e.consume();
            }
        });
        //获取加密码
        JaMiCode.addActionListener(b ->{
            StringSelection stsel = new StringSelection(Code);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel,stsel);
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("xnl");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        okButton = new JButton();
        cancelButton = new JButton();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        checkBox1 = new JCheckBox();
        Reset = new JButton();
        AutoCopy = new JCheckBox();
        label4 = new JLabel();
        JaMiCode = new JButton();

        //======== this ========
        setTitle(bundle.getString("this.title"));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //---- label1 ----
                label1.setText(bundle.getString("label1.text"));
                contentPanel.add(label1);
                label1.setBounds(10, 5, 80, 30);

                //---- label2 ----
                label2.setText(bundle.getString("label2.text"));
                contentPanel.add(label2);
                label2.setBounds(10, 40, 80, 30);

                //---- okButton ----
                okButton.setText(bundle.getString("okButton.text"));
                contentPanel.add(okButton);
                okButton.setBounds(10, 115, 86, 25);

                //---- cancelButton ----
                cancelButton.setText(bundle.getString("cancelButton.text"));
                contentPanel.add(cancelButton);
                cancelButton.setBounds(105, 115, 95, 25);
                contentPanel.add(textField1);
                textField1.setBounds(100, 5, 210, 30);
                contentPanel.add(textField2);
                textField2.setBounds(100, 40, 210, 30);

                //---- label3 ----
                label3.setText(bundle.getString("label3.text"));
                contentPanel.add(label3);
                label3.setBounds(10, 75, 80, 30);
                contentPanel.add(textField3);
                textField3.setBounds(100, 75, 210, 30);

                //---- checkBox1 ----
                checkBox1.setText(bundle.getString("checkBox1.text"));
                contentPanel.add(checkBox1);
                checkBox1.setBounds(15, 150, 85, 29);

                //---- Reset ----
                Reset.setText(bundle.getString("Reset.text"));
                contentPanel.add(Reset);
                Reset.setBounds(210, 115, 95, 25);

                //---- AutoCopy ----
                AutoCopy.setText(bundle.getString("AutoCopy.text"));
                contentPanel.add(AutoCopy);
                AutoCopy.setBounds(100, 150, 140, 29);

                //---- label4 ----
                label4.setText(bundle.getString("label4.text"));
                contentPanel.add(label4);
                label4.setBounds(new Rectangle(new Point(345, 160), label4.getPreferredSize()));

                //---- JaMiCode ----
                JaMiCode.setText(bundle.getString("JaMiCode.text"));
                contentPanel.add(JaMiCode);
                JaMiCode.setBounds(315, 115, 110, 25);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JButton okButton;
    private JButton cancelButton;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JCheckBox checkBox1;
    private JButton Reset;
    private JCheckBox AutoCopy;
    private JLabel label4;
    private JButton JaMiCode;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        new JavaPassWordMaker().setVisible(true);
    }

}
