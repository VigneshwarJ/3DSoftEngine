<<<<<<< HEAD
public class Main{
    
    public static void main(String[] args) {
       
        Display display = new Display(800,600,"hhh");// creates a new display
        RenderContext target = display.GetFrameBuffer();//creates a render context
        long previousTime = System.nanoTime();
       
        //StarField stars = new StarField(406, 64.0f, 30.0f); 
        Vertex y_min = new Vertex(100.0f, 200.0f);
        Vertex y_mid = new Vertex(50.0f,300.0f);
        Vertex y_max = new Vertex(200.0f, 500.0f);
        while (true) {
            
           // long currentTime = System.nanoTime();
          //  int count=0;
          //  float delta = (float)((currentTime - previousTime)/1000000000.0);
            //stars.UpdateAndRender(target, delta);
          
           target.clear((byte)0x00);

            target.DrawTriangle(y_min, y_mid, y_max);
           // previousTime=currentTime;
            // for (int i = 100; i < 200; i++) {
            //     target.DrawScanBuffer(i,300-i,300+i);
                
            // }
            
           
            display.swapBuffers();
        }
    }
   
=======
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");
        Display display = new Display(800,600,"hhh");
        RenderContext target = display.GetFrameBuffer();
        long previousTime = System.nanoTime();
        StarField stars = new StarField(406, 64.0f, 30.0f); 
        vertex ymin = new vertex(50,150);
        vertex ymid = new vertex(120, 100);
        vertex ymax = new vertex(150, 50);
        
        //System.out.println("fool");
        while (true) {
            //System.out.println("fool1");
            long currentTime = System.nanoTime();
            int count=0;
          //  float delta = (float)((currentTime - previousTime)/1000000000.0);
            //stars.UpdateAndRender(target, delta);
           // System.out.println(delta);
           target.clear((byte)0x00);
           //System.out.println("fool");
            previousTime=currentTime;
            target.drawTriangle(ymin,ymax,ymid);
        //     for (int i = 100; i < 200; i++) {
        //         target.DrawScanBuffer(i,300-i,300+i);
        //         //System.out.println("inside loop");
        //    }
           // target.fillShape(100,200);
            //System.out.println(previousTime);
            //System.out.println(delta);
            display.swapBuffers();
        }
    }
   
>>>>>>> 89ea1d92999bc58d658f9b1f6e6f1ea853b96b88
}