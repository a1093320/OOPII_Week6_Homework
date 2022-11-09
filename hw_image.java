import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //事件觸發套件

class imageFrame extends JFrame{
    private JPanel imgJp;
    private ImageIcon img;
    private static JLabel lab;
    private int count = 1;
    private int totalImage = 5; //照片總數
    imageFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("圖片網");
        setBounds(100, 100, 500, 600);

        imgJp = new JPanel();
        imgJp.setLayout(new BorderLayout(30, 30));
        setContentPane(imgJp); //!!!

        img = new ImageIcon("img"+count+".png");
        img.setImage(img.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)); //set img size
        lab = new JLabel();
        lab.setIcon(img);
        imgJp.add(lab, BorderLayout.CENTER);

        //page button
        //上一張
        JButton pagePrevious = new JButton("上一張");
        imgJp.add(pagePrevious, BorderLayout.WEST);
        pagePrevious.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(count == 1){
                    JOptionPane.showMessageDialog(null, "這是第一張!", "警告!", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    count --;
                    img = new ImageIcon("img"+count+".png");
                    img.setImage(img.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)); //set img size
                    lab.setIcon(img);
                    imgJp.add(lab, BorderLayout.CENTER);
                }
            }   
        });
        
        
        //下一張
        JButton pageNext = new JButton("下一張");
        imgJp.add(pageNext, BorderLayout.EAST);
        pageNext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(count == totalImage){
                    JOptionPane.showMessageDialog(null, "這是最後一張", "警告!", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    count ++;
                    img = new ImageIcon("img"+count+".png");
                    img.setImage(img.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)); //set img size
                    lab.setIcon(img);
                    imgJp.add(lab, BorderLayout.CENTER);
                }
            }
        });
    
        setVisible(true);
    }
}

public class hw_image {
    public static void main(String[] args) {
        imageFrame imgF = new imageFrame();
    }
}
