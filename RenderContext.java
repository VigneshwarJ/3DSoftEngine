
/**
 * RenderContext
 */
public class RenderContext extends Bitmap {
    private final int m_scanBuffer[]; //filling with x min and x max with y axis
    byte white = (byte) 0xFF;
    // public final Vertex y_min = new Vertex(100.0f,200.0f);
    // public final Vertex y_mid = new Vertex(50.0f,400.0f);
    // public final Vertex y_max = new Vertex(200.0f,600.0f);

    public RenderContext(int width, int height)
    {
        super(width, height);//goes to bitmap.
        m_scanBuffer = new int[height*2];

    }
    public void DrawScanBuffer(int yCoord, int xMin, int XMax)
    {
        m_scanBuffer[yCoord*2] =xMin;
        m_scanBuffer[yCoord*2 + 1] =XMax;
        

    }
    public void DrawTriangle(Vertex y_min,Vertex y_mid,Vertex y_max)
    {
        Vertex temp;
        float ymin = y_min.GetY();
        float ymax = y_max.GetY();
        float ymid = y_mid.GetY();
        if(ymin>ymax)
        {
            temp = y_min;
            y_min = y_max;
            y_max = temp;
        }
        if(ymid>ymax)
        {
            temp = y_mid;
            y_mid = y_max;
            y_max = temp;

        }
        if(ymin>ymid)
        {
            temp = y_min;
            y_min = y_mid;
            y_mid = temp;

        }
        float xstep = (y_max.GetY() -y_min.GetY())/(y_max.GetX()-y_min.GetX());
        float xstep1 = (y_max.GetY() -y_mid.GetY())/(y_max.GetX()-y_mid.GetX());
        float xstep2 = (y_mid.GetY() -y_min.GetY())/(y_mid.GetX()-y_min.GetX());
        float b = y_min.GetY() - (y_min.GetX() * xstep);
            float b1 = y_mid.GetY() - (y_mid.GetX() * xstep1);
            float b2 = y_min.GetY() - (y_min.GetX() * xstep2);
        //System.out.println(b + "   " + y_min.GetY()+ "  "+(y_min.GetX()*xstep)+ ""+ y_min.GetX() );

        for(int i =(int) (y_min.GetY());i<=(int)(y_max.GetY());i++)
        {
            float xmin = (((float)i - b)/(float)xstep);
            float xMax =0;
            if(i<=(int) (y_mid.GetY()))
            {
            xMax = (((float)i - b2)/(float)xstep2); 
            }
            else
            xMax = (((float)i - b1)/(float)xstep1);
            // float xMax = y_mid.GetX() + ((float)i/xstep2);
            // System.out.println(xMax + " " +((float)i/xstep2));
            //float xMax = y_max.GetX();
        //     if(xMax>xmin)
        //     {
        //     System.out.println(xMax + "    "+ (((float)i - b)/(float)xstep)+"    " + xmin+"  " +i);
        //     DrawScanBuffer(i, (int)xmin, (int)xMax);
        // }
        //     else{
                System.out.println(xMax +"    " + xmin+"  " +i);
                DrawScanBuffer(i, (int)xMax, (int)xmin);
            // }
           // DrawScanBuffer(i, (int)xMax, (int)xmin);

        }
        //System.out.println(y_max.GetY()+ "  "+y_min.GetY());
        fillShape( (int)y_min.GetY(),  (int)y_max.GetY());
        
    }
    public void fillShape(int yMin, int yMax)
    {
       
        for(int j =yMin;j<yMax;j++)
        {
            int xMin = m_scanBuffer[j*2];
            int xMax = m_scanBuffer[j*2 + 1];
            
            for(int i=xMin;i<xMax;i++)
            {
                drawPixel(i, j, white, white, white, white);
                
            }
        }
    }
    
}