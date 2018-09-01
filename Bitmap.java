/**
 * Bitmap
 */
import java.awt.*;
import java.util.Arrays;
public class Bitmap {
private final int m_width;
private final int m_height;
private final byte m_components[];

public Bitmap(int width, int height){
    m_width = width;
    m_height = height;
    m_components = new byte[m_width*m_height*4];
}
public void clear(byte shade){
    Arrays.fill(m_components, shade);
}
public void drawPixel(int x, int y,byte a,byte b,byte g,byte r){
int index = (x + y*m_width)*4;
m_components[index] = a;
m_components[index+1]= b;
m_components[index+2]= g;
m_components[index+3]= r;
}
public void copyToByteArray(byte dest[]){   
    for(int i=0; i < m_height*m_width ; i++){
        dest[i*3]= m_components[i*4+1];
        dest[(i*3)+1]= m_components[i*4+2];
        dest[(i*3)+2]= m_components[i*4+3];

    }
}

public int Get_width(){return m_width;}
public int Get_height(){return m_height;}
}


    
