class vertex{
public int m_x;
public int m_y;
public vertex(int x,int y)
{
    m_x = x;
    m_y = y;
}
public float getX()
{
    return m_x;
}

public float getY()
{
    return m_y;
}
public float triangleArea(vertex b,vertex c)
{
    float area;
    float x1 = b.getX() -m_x;
    float y1 = b.getY() -m_y;

    float x2 = c.getX() -m_x;
    float y2 = c.getY() -m_y;
    
    area = (x1*y2) - (y1*x2);
    return area;

}
}