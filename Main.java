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
        
       
        while (true) {
            
            long currentTime = System.nanoTime();
            int count=0;
          //  float delta = (float)((currentTime - previousTime)/1000000000.0);
            //stars.UpdateAndRender(target, delta);
          
           target.clear((byte)0x00);
          
            previousTime=currentTime;
            target.drawTriangle(ymin,ymax,ymid);
        //     for (int i = 100; i < 200; i++) {
        //         target.DrawScanBuffer(i,300-i,300+i);
        //        
        //    }
           // target.fillShape(100,200);
            display.swapBuffers();
        }
    }
   
}