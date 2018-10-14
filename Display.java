import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.swing.JFrame;


public class Display extends Canvas
{
   private static final long serialVersionUID = 1L;
   private final JFrame m_frame;
   private final RenderContext m_frameBuffer;
   private final BufferedImage m_displayImage;
   private final byte[] m_displayComponents;
   private final BufferStrategy m_strategy;
   private final Graphics m_Graphics;

   public Display(int width, int height, String title)
   {
        Dimension size = new Dimension(width,height);
        setPreferredSize(size);
        setMaximumSize(size);
        setMaximumSize(size);     
        
        m_frameBuffer = new RenderContext(width, height);//creates a bitmap for the width and height and a scan_buffer
        m_displayImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR); //buffered image is iamge  data with type of color component used 
        m_displayComponents = ((DataBufferByte)m_displayImage.getRaster().getDataBuffer()).getData();
        m_frameBuffer.clear((byte)0x60);
        


        m_frame = new JFrame();
        m_frame.add(this);
        m_frame.pack();
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_frame.setTitle(title);
        m_frame.setVisible(true);
        createBufferStrategy(1);
        m_strategy = getBufferStrategy();
        m_Graphics = m_strategy.getDrawGraphics();
   }
   public RenderContext GetFrameBuffer() { return m_frameBuffer; }
    public void swapBuffers()
    {
        m_frameBuffer.copyToByteArray(m_displayComponents);
        m_Graphics.drawImage(m_displayImage, 0, 0, m_frameBuffer.Get_width(), m_frameBuffer.Get_height(),null);
        m_strategy.show();
        //System.out.println("1");
    }
}