import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.*;
import javax.swing.*;

public class Graph2 {
    
  public static void Start2(final int Step[]) {
    // Create a new frame
    JFrame frame = new JFrame("Grafik");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    
    final int[] cord = {50, 20, 40, 80, 60};  
    final int marg = 30;  
    final int[] CorX = new int [5];
    final int[] CorY = new int [5];

    JPanel panel = new JPanel() {

    	 public void paint(Graphics grf){  
    	        //create instance of the Graphics to use its methods  
    	        super.paintComponent(grf);  
    	        Graphics2D graph = (Graphics2D)grf;  
    	          
    	        //Sets the value of a single preference for the rendering algorithms.  
    	        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
    	          
    	        // get width and height  
    	        int width = getWidth();  
    	        int height = getHeight();  
    	          
    	        //find value of x and scale to plot points  
    	        double x = (double)(width-2*marg)/(cord.length-1);  
    	        double scale = (double)(height-2*marg)/getMax(cord); 
    	          
    	        //set color for points  
    	        graph.setPaint(Color.RED);  
    	          
    	        // set points to the graph  
    	        for(int i=0; i<cord.length; i++){  
    	            double x1 = marg+i*x;  
    	            double y1 = height-marg-scale*cord[i];  
    	            graph.fill(new Ellipse2D.Double(x1, y1, 10, 10));  
    	            System.out.println("x1: " + x1 + " y1: " + y1);

    	            CorX[i] = (int)x1;
    	            CorY[i] = (int)y1;
    	            
    	        }  
    	        for(int i=0;i<CorX.length-1;i++) {
    	        	System.out.println("X Dizi: " + CorX[i] + " Y Dizi: " + CorY[i]);
    	        }

    	        
    	        for(int i=0;i<CorX.length-1;i++) {
    	        	
    	        	System.out.println("X: " + CorX[i] + " Y: " + CorY[i]);
    	        }
    	        
    	        grf.drawLine(CorX[0], CorY[0], CorX[3] ,  CorY[3]);
    	        grf.drawString("16", ((CorX[0]+ CorX[3])/2)-10, ((CorY[0]+ CorY[3])/2));
    	        
    	    }  
    };
    
    
    frame.add(panel);
    frame.setVisible(true);
    
    
    
  }
  
  private static int getMax(int cord []){  
      int max = -Integer.MAX_VALUE;  
      for(int i=0; i<cord.length; i++){  
          if(cord[i]>max)  
              max = cord[i];  
           
      }  
      return max;  
  }   
}

