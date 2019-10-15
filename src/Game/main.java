package Game;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Graphics2D;
public class main 
{
	public static void main(String[]args)
	{
		JFrame obj=new JFrame();
		//Title of snake game
		obj.setTitle("Snake Game ");
		obj.setBounds(10,10,905,700);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setBackground(Color.DARK_GRAY);
		Gameplay gameplay=new Gameplay();
		obj.add(gameplay);	
	}
}