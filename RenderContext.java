/**
 * RenderContext
 */
public class RenderContext extends Bitmap {
    private final int m_scanBuffer[];
    byte white = (byte) 0xFF;

    public RenderContext(int width, int height)
    {
        super(width, height);
        m_scanBuffer = new int[height*2];

    }
    public void DrawScanBuffer(int yCoord, int xMin, int XMax)
    {
        m_scanBuffer[yCoord*2] =xMin;
        m_scanBuffer[yCoord*2 + 1] =XMax;
        //System.out.println("i am till here");

    }
    public void drawEdges(vertex y_min,vertex y_max,boolean whichside)
    {
        float xstep = (y_max.getY()-y_min.getY())/(y_max.getX() -y_min.getX());
        float C = y_min.getY() -(y_min.getX()*xstep);
        for(int x= (int)y_min.getY();x<=(int)y_max.getY();x++)
        {   
            
            int xMin = (int)(((float)x -C)/xstep);

            if (whichside) {//xmax
                m_scanBuffer[x*2 + 1] =xMin;
               // System.out.println("xstep is" +xstep + " xmax is"+xMin+" for y "+x);
            }
            else
            { //xmin
                m_scanBuffer[x*2] =xMin;
               // System.out.println("xstep is" +xstep+" xmin is"+xMin+" for y "+x);
            }
           
        }

    }
    public void drawTriangle(vertex y_min,vertex y_max,vertex y_mid)
    {
        vertex temp ;
        if (y_max.getY()<y_min.getY()) {
            
            temp  = y_max;
            y_max = y_min;
            y_min = temp;
        }
        if (y_max.getY()<y_mid.getY()) {
            temp  = y_max;
            y_max = y_mid;
            y_mid = temp;
        }
        if (y_mid.getY()<y_min.getY()) {
            temp  = y_mid;
            y_mid = y_min;
            y_min = temp;
        }
        if (y_min.triangleArea(y_mid, y_max)> 0) {
            drawEdges(y_min, y_max, false);
            drawEdges(y_min, y_mid, true);
            drawEdges(y_mid, y_max, true); 
        } else {
            drawEdges(y_min, y_max, true);
            drawEdges(y_min, y_mid, false);
            drawEdges(y_mid, y_max, false);
        }
        
        fillShape((int)y_min.getY(), (int)y_max.getY());
    }
    public void fillShape(int yMin, int yMax)
    {
       // System.out.println("i am done");
        for(int j =yMin;j<yMax;j++)
        {
            int xMin = m_scanBuffer[j*2];
            int xMax = m_scanBuffer[j*2 + 1];
           // System.out.println(xMin);
          
            for(int i=xMin;i<xMax;i++)
            {
                drawPixel(i, j, white, white, white, white);
               
            }
        }
    }
    
}