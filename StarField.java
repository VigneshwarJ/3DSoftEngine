/**
 * StarField
 */
public class StarField {
    private final float m_spread;
    private final float m_spead;
    private final float m_starX[];
    private final float m_starY[];
    private final float m_starZ[];
    public StarField(int numStars,float spread,float speed)
    {
        m_spead =speed;
        m_spread = spread;

        m_starX = new float[numStars];
        m_starY = new float[numStars];
        m_starZ = new float[numStars];

        for(int i=0;i<m_starX.length;i++) 
        {
            InitStar(i);
        }

    }
    private void InitStar(int i){
        m_starX[i] = 2*((float)Math.random()-0.5f)* m_spread;
        m_starY[i] = 2*((float)Math.random()-0.5f)* m_spread;
        m_starZ[i] = ((float)Math.random()+0.00001f)* m_spread;
    }
    public void UpdateAndRender(Bitmap target, float delta)
    {
        target.clear((byte) 0x00);
        System.out.println(delta);
        //byte white = (byte) 0xFF;
        float halfWidth = target.Get_width()/2.0f;
        float halfHeight = target.Get_height()/2.0f;
        target.clear((byte) 0x00);
        
        for (int i=0;i<m_starX.length; i++)
        {
            
            m_starZ[i] -= delta * m_spead;
            //System.out.println(m_starZ[i]);
          // System.out.println(delta);
            if(m_starZ[i] <=0)
            {
                System.out.println(m_starZ[i]);
                InitStar(i);
            }
            int x= (int)(((m_starX[i]/m_starZ[i])*halfWidth)  + halfWidth );
            int y= (int)(((m_starY[i]/m_starZ[i])*halfHeight) + halfWidth );

            if(x<0|| x>=target.Get_width()||(y<0||y>=target.Get_height()))
            {
                InitStar(i);
            }
            else
            {
                target.drawPixel(x, y,(byte) 0xFF ,(byte) 0xFF, (byte) 0xFF, (byte) 0xFF);
            }

            
        }
    }

}