  package Game;
  import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
@SuppressWarnings("serial")
public class Gameplay  extends JPanel implements
KeyListener,ActionListener {

	private int snakexlenght[]=new int[750];
    private int snakeylenght[]=new int [750];

    private boolean left=false;			
    private boolean right=false;
    private boolean up=false;
    private boolean down=false;

    private ImageIcon rightmouth;
    private ImageIcon leftmouth;
    private ImageIcon downmouth;
    private ImageIcon upmouth;
    private ImageIcon snakeimage;
    
    private  int enemyxpos[]={25,50,75,100,125,
    		150,200,225,250,275,300,325,350,
    		374,400,425,450,475,500,525,550,
		575,600,625,650,675,700,725,750,775,800,825,850};
   
    private  int enemyypos[]= {75,100,125,150,175,200,
    		225,250,275,300,325,350,
    		374,400,425,450,475,500,525,550,
		575};
    
    private ImageIcon enemyimage;
    private Random random=new Random();
    
    private int xpos=random.nextInt(34);
   
    private int ypos=random.nextInt(23);
    
    private Timer timer;
    private int delay=150;

    private int lenghtofsnake=3;
    private int moves=0;
    private int scores=0;

    private ImageIcon titleImage;	
	public Gameplay()
	{    
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer= new Timer(delay,this);
		timer.start();
		
	}
	public void paint(Graphics g)
	{
		if(moves==0) 
	    {
			snakexlenght[0]=100;
			snakexlenght[1]=75;
			snakexlenght[2]=50;
			
		
		snakeylenght[0]=500;
		snakeylenght[1]=500;
		snakeylenght[2]=500;
		
	     }
		//border of title image
		g.setColor(Color.white);
		g.drawRect(24,10,851,55);
	
		titleImage =new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this,g,25,11);
		
		//border of space image
	g.setColor(Color.white);
	g.drawRect(24,74,851,577);
	g.setColor(Color.black);
    g.fillRect(25,74,851,577);
    //drow the score
    g.setColor(Color.WHITE);
    g.setFont(new Font("arial",Font.PLAIN,14));
    g.drawString("scores :"+scores,780,30);
    g.drawString("Length :"+ lenghtofsnake ,780,50);
    
    rightmouth =new ImageIcon("rightmouth.png");
   rightmouth.paintIcon(this,g,snakexlenght[0],snakeylenght[0]);	
    for(int a=0;a<lenghtofsnake;a++) 
    {
   if(a==0 && right) 
   {
     rightmouth =new ImageIcon("rightmouth.png");
    rightmouth.paintIcon(this,g,snakexlenght[a],snakeylenght[a]);
    }
   if(a==0 && left) 
   {
   leftmouth =new ImageIcon("leftmouth.png");
   leftmouth.paintIcon(this,g,snakexlenght[a],snakeylenght[a]);
   }
   if(a==0 && up) 
    {
	upmouth =new ImageIcon("upmouth.png");
	upmouth.paintIcon(this , g, snakexlenght[a],snakeylenght[a]);
	}
	if(a==0 && down) 
		{
		downmouth =new ImageIcon("downmouth.png");
		downmouth.paintIcon(this , g, snakexlenght[a],snakeylenght[a]);
		}
		if(a!=0) 
   	{
	snakeimage=new ImageIcon("snakeimage.png");
	snakeimage.paintIcon(this,g,snakexlenght[a],snakeylenght[a]);
	}
	}
    enemyimage =new ImageIcon("enemy.png");
    enemyimage.paintIcon(this,g ,enemyxpos[xpos],enemyypos[ypos]);
	if(enemyxpos[xpos]==snakexlenght[0]&& enemyypos[ypos]==snakeylenght[0])
     {		
		lenghtofsnake++;
		scores++;
		xpos=random.nextInt(34);
		ypos=random.nextInt(23);
		}
	for(int b=1;b<lenghtofsnake;b++) 
	   {
		if(snakexlenght[b]==snakexlenght[0]&&snakeylenght[b]==snakeylenght[0]) 
		{
			right=false;
			left=false;
			up=false;
			down=false;
			
			g.setColor(Color.red);
		    g.setFont(new Font("arial",Font.BOLD,50));
		    g.drawString("Game Over :",300,300);
		    
		    g.setFont(new Font("arial",Font.BOLD,20));
		    g.drawString("Spcae TO RESTATE :",350,340);
		   g.drawString("Length :"+ lenghtofsnake ,580,50);
		}
	}
    g.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(right)
		{
			for(int i=lenghtofsnake-1;i>=0;i--) 
			{
		snakeylenght[i+1]=snakeylenght[i];	
			}
			for(int i=lenghtofsnake;i>=0;i--) 
			{
				if(i==0) 
				{
		snakexlenght[i]=snakexlenght[i]+25;
					
				}
				else 
				{
		snakexlenght[i]=snakexlenght[i-1];
					
				}
				if(snakexlenght[i]>850) 
				{
					snakexlenght[i]=25;
				}
			}
			repaint();	
		}
		if(left)
		{
			for(int i=lenghtofsnake-1;i>=0;i--) 
			{
		snakeylenght[i+1]=snakeylenght[i];	
			}
			for(int i=lenghtofsnake;i>=0;i--) 
			{
				if(i==0) 
				{
		snakexlenght[i]=snakexlenght[i]-25;
					
				}
				else 
				{
		snakexlenght[i]=snakexlenght[i-1];
					
				}
				if(snakexlenght[i]<25) 
				{
					snakexlenght[i]=850;
				}
			}
			repaint();	
		}
		if(up)
		{
			for(int i=lenghtofsnake-1;i>=0;i--) 
			{
		snakexlenght[i+1]=snakexlenght[i];	
			}
			for(int i=lenghtofsnake;i>=0;i--) 
			{
				if(i==0) 
				{
		snakeylenght[i]=snakeylenght[i]-25;
					
				}
				else 
				{
		snakeylenght[i]=snakeylenght[i-1];
					
				}
				if(snakeylenght[i]<75) 
				{
					snakeylenght[i]=625;
				}
			}
			repaint();	
		}
		if(down)
		{
			for(int i=lenghtofsnake-1;i>=0;i--) 
			{
		snakexlenght[i+1]=snakexlenght[i];	
			}
			for(int i=lenghtofsnake;i>=0;i--) 
			{
				if(i==0) 
				{
		snakeylenght[i]=snakeylenght[i]+25;
					
				}
				else 
				{
		snakeylenght[i]=snakeylenght[i-1];
					
				}
				if(snakeylenght[i]>625) 
				{
					snakeylenght[i]=75;
				}
			}
			repaint();	
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) 
				{
					moves++;
				if(!left)
					{
						right=true;
					 }
				else
				{
						left=true;
						right=false;
				}
						up=false;
						down=false;
					}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) 
		{
			moves++;
		if(!right)
			{
				left=true;
			}
		else
		{
				left=false;
				right=true;
		}
				up=false;
				down=false;
			}
		if(e.getKeyCode()==KeyEvent.VK_UP) 
		{
			moves++;
		if(!down)
			{
				up=true;
			}
		else
		{
				down=true;
				up=false;
		}
				left=false;
				right=false;
			}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) 
		{
			moves++;
		if(!up)
			{
				down=true;
			}
		else
		{
	 			up=true;
				down=false;
		}
				right=false;
				left=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) 
		{    
			    scores=0;
			    moves=0;
			 lenghtofsnake=3;
			 repaint();
		}
		
	}	
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
