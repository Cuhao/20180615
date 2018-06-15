import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class s0010 extends JFrame{
    public s0010(){
        init();
    }
    private JButton jbnRun =new JButton("RUN");
    private JButton jbnup=new JButton("↑");
    private JButton jbndown=new JButton("↓");
    private JButton jbnleft=new JButton("←");
    private JButton jbnright=new JButton("→");
    private JButton jbnEXIT=new JButton("EXIT");
    private JPanel jPanel =new JPanel();
    private JPanel jPane2 =new JPanel();
    private int dirFlag=1;
    private int objX =100,onjY=100,objW=194,objH=259;
    private Container cp;
    private JLabel jlb =new JLabel();
    private ImageIcon icon =new ImageIcon("Lee01.png");
    private Timer t1;

    private  void init() {
        this.setBounds(10, 10, 1000, 1000);
        setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(10, 10));
        cp.add(jPanel, BorderLayout.CENTER);
        jPanel.add(jlb);
        cp.add(jPane2, BorderLayout.SOUTH);
        jPane2.setLayout(new GridLayout(1,6,2,2));
        jPane2.add(jbnRun);
        jPane2.add(jbnup);
        jPane2.add(jbndown);
        jPane2.add(jbnleft);
        jPane2.add(jbnright);
        jPane2.add(jbnEXIT);
        jlb.setIcon(icon);



        jbnRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                t1.start();
                jlb.setEnabled(true);
            }
        });
        jbnEXIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(EXIT_ON_CLOSE);
            }
        });
        jbnup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dirFlag=1;
            }
        });
        jbndown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dirFlag=2;

            }
        });
        jbnleft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dirFlag=3;

            }
        });
        jbnright.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dirFlag=4;

            }
        });
        t1=new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch (dirFlag){
                    case 1:
                        if ((onjY-50)>0){
                            onjY-=50;
                        }
                        break;
                    case 2:
                        if (onjY+50<(1000-objH)){
                            onjY+=50;
                        }
                        break;
                    case 3:
                        if ((objX-50)>0){
                            objX-=50;
                        }
                        break;
                    case 4:
                        if (objX+50<(1000-objW)){
                            objX+=50;
                            break;
                        }
                }
                jlb.setLocation(objX,onjY);
            }
        });

    }
}
