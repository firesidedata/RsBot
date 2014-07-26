package RS3.Scripts.FiresMiner.GUI;


import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.powerbot.bot.rt6.client.TileData;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;

import RS3.Scripts.FiresMiner.Database.Banks;
import RS3.Scripts.FiresMiner.Database.Rocks;
import RS3.Scripts.FiresMiner.Framework.Task;
import RS3.Scripts.FiresMiner.Tasks.Actions.Drop;
import RS3.Scripts.FiresMiner.Tasks.Actions.Mine;
import RS3.Scripts.FiresMiner.Tasks.Actions.Walk.Bank_Walk;
import RS3.Scripts.FiresMiner.Tasks.Banking.Bank_Deposit;
import RS3.Scripts.FiresMiner.Tasks.Banking.Bank_Open;
public class GUI extends ClientAccessor{

    private JFrame frame;
    private List Tasklist;
    private Rocks rock;
    private Banks banks;

    public GUI(ClientContext ctx, List tasklist) {
        super(ctx);
        this.Tasklist = tasklist;
        initialise();

    }

    private void initialise() {
        frame = new JFrame("Fires Miner");
        frame.getContentPane().setLayout(new GridLayout(0,1,0,0));

        frame.add(new JLabel("Select Type:"));
        final JComboBox Type = new JComboBox();
        Type.setModel(new DefaultComboBoxModel(new String[]{"Bank", "PowerMine"}));
        frame.add(Type);

        frame.add(new JLabel("Select ore:"));
        final JComboBox OreComboBox = new JComboBox(rock.values());
        frame.add(OreComboBox);

        frame.add(new JLabel("Banking Spot"));
        final JComboBox BankComboBox = new JComboBox(Banks.values());
        frame.add(BankComboBox);

        JButton startButton = new JButton("Start");
        frame.add(startButton);

        startButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = Type.getSelectedItem().toString();
                Rocks selectedRock = (Rocks) OreComboBox.getSelectedItem();
                Banks selectedBank = (Banks) BankComboBox.getSelectedItem();

                rock = selectedRock;
                banks = selectedBank;
                int[] bankloc=banks.getloc();
                
                if (selectedType.equals("PowerMine")) {
                    Tasklist.add(new Drop(ctx, GUI.this.rock));
                } else {
                	Tasklist.add(new Bank_Walk(ctx));
                    Tasklist.add(new Bank_Open(ctx));
                    Tasklist.add(new Bank_Deposit(ctx, GUI.this.rock));
                }
                Tasklist.add(new Mine(ctx, GUI.this.rock));
                frame.dispose();
            }
        });

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }
}