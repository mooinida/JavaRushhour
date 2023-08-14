package rushhour;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Finale extends JFrame{

	public Finale() {
		setTitle("END");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        JButton s1 = new JButton("END");
        Font f = new Font("맑은 고딕", Font.BOLD, 30);

        bgm st = new bgm("finale", true);

        s1.setBackground(Color.red);
        s1.setFont(f);
        s1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                st.close();
                effect b = new effect("button");
                b.play();
                

                setVisible(false);
                dispose();
            }
        });


        s1.setBounds(525, 600, 140, 70);
        c.add(s1);
        JLabel back = new JLabel(new ImageIcon(Finale.class.getResource("/img/END.png")));
        back.setBounds(0, 0, 1200, 900);
        c.add(back);

        setResizable(false);
        // setLocationRelativeTo(null);
        setLayout(null);
        setSize(1200, 900);

        // 버튼이 추가된 후에 setVisible(true) 호출
        setVisible(true);
        st.start();
	}

	public static void main(String[] args) {
		new Finale();

	}

}
