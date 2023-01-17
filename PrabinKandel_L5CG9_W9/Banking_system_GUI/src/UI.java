import javax.swing.*;

public class UI extends JFrame {

    private JButton createButton;
    private JButton checkButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton quitButton;
    private JTextField $EnterTheAmountTextField;
    private JTextField enterYourNameTextField;
    private JButton createSubmit;
    private JPanel LoginPage;
    private JTextField enterYourNameTextField1;
    private JButton checkSubmit;
    private JPanel Create;
    private JPanel Check;
    private JPanel Deposit;
    private JPanel Withdraw;
    private JLabel create_invalid_username;
    private JLabel create_invalid_amount;
    private JLabel deposit_user_not_found;
    private JLabel deposit_invalid_amount;
    private JLabel withdraw_user_not_found;
    private JLabel withdraw_insuf_balance;
    private JLabel check_user_not_found;
    private JButton depositSubmit;
    private JButton withdrawSubmit;

    private void errorMessage(JLabel[] l){
        JLabel[] messages = {create_invalid_amount,create_invalid_username,deposit_invalid_amount,deposit_user_not_found,withdraw_insuf_balance,withdraw_user_not_found,withdraw_insuf_balance,check_user_not_found};
        for(JLabel label : messages){
            label.setVisible(false);
        }
        for(JLabel L: l){L.setVisible(true);}
    }
    private void planeHider( JPanel panel){
        Create.setVisible(false);
        Check.setVisible(false);
        Deposit.setVisible(false);
        Withdraw.setVisible(false);
        panel.setVisible(true);
    }
    public UI(){
    setContentPane(LoginPage);
    setSize(500,400);
    createButton.addActionListener(e->{
        planeHider(Create);
    });
    checkButton.addActionListener(e->{
        planeHider(Check);
    });
    depositButton.addActionListener(e->{
        planeHider(Deposit);
    });
    withdrawButton.addActionListener(e->{
        planeHider(Withdraw);
    });
    quitButton.addActionListener(e->{
        System.exit(0);
    });
    createSubmit.addActionListener(e->errorMessage(new JLabel[]{create_invalid_amount,create_invalid_username}));
    withdrawSubmit.addActionListener(e->errorMessage(new JLabel[]{withdraw_insuf_balance,withdraw_user_not_found}));
    depositSubmit.addActionListener(e->errorMessage(new JLabel[]{deposit_invalid_amount,deposit_user_not_found}));
    checkSubmit.addActionListener(e->errorMessage(new JLabel[]{check_user_not_found}));
    setVisible(true);
    setResizable(false);
    }
}
