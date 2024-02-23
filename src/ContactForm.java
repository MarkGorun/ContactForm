import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    JTextField name_text, e_mail_text;
    JRadioButton male, female;

    JCheckBox check;

    public ContactForm(){
        super("Contact form");
        super.setBounds(200, 150 , 250 , 150);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout( new GridLayout(4, 2, 2, 2));

        JLabel name = new JLabel("Input name");
        name_text = new JTextField("" , 1);
        JLabel e_mail = new JLabel("Input eMail");
        e_mail_text = new JTextField("" , 1);

        container.add(name);
        container.add(name_text);
        container.add(e_mail);
        container.add(e_mail_text);

        male  = new JRadioButton("Male");
        female = new JRadioButton("Female");
        check = new JCheckBox("Accept" , false);
        JButton  send_button = new JButton("Send");

        container.add(male);
        container.add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(female);
        group.add(male);
        container.add(check);
        container.add(send_button);
        male.setSelected(true);

        send_button.addActionListener(new ButtonEventManager());
    }

    class ButtonEventManager implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            String name = name_text.getText();
            String e_mail = e_mail_text.getText();

            String gender = "Male";
            if (  !male.isSelected()) gender = "Female";

            boolean check_box = check.isSelected();



            JOptionPane.showMessageDialog(null ,
                    "Your e-mail:  "+ e_mail + "\nYour gender: " + gender +"\n",
                    "Hi " + name , JOptionPane.PLAIN_MESSAGE );
        }
    }
}
