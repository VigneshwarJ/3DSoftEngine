 /**
 * RenderContext
 */
public class RenderContext extends Bitmap {
    private final int m_scanBuffer[];
    byte white = (byte) 0xFF;

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