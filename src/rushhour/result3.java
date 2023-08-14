package rushhour;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class result3 extends JFrame {
    public result3(long duration, int count) {
        setTitle("Result");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        Font f1=new Font("맑은 고딕", Font.BOLD, 25);
        JLabel ti = new JLabel("소요된 시간 :       " + duration + "초");
        ti.setFont(f1);
        ti.setBounds(100, 100, 300, 30);
        c.add(ti);

        JLabel b = new JLabel("이동한 횟수 :       " + count + "회");
        b.setFont(f1);
        b.setBounds(100, 180, 300, 30);
        c.add(b);
        
        JButton next=new JButton("Finish");
        next.setBounds(170, 250, 150, 50);
        next.setFont(f1);
        next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				effect next=new effect("button");
				next.play();
				new Finale();
				
				
				}
        });
        c.add(next);
        
        

        
        setSize(500, 500);
        setLocation(500,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new result3(0, 0);
    }
}
