public class Main{

    public static void main(String[] args) {
       // System.out.println("Hello world");
        Display display = new Display(800,600,"hhh");// creates a new display
        RenderContext target = display.GetFrameBuffer();//creates a render context
        long previousTime = System.nanoTime();
        //StarField stars = new StarField(406, 64.0f, 30.0f); 
       
        while (true) {
            
           // long currentTime = System.nanoTime();
          //  int count=0;
          //  float delta = (float)((currentTime - previousTime)/1000000000.0);
            //stars.UpdateAndRender(target, delta);
          
           target.clear((byte)0x00);
           
           // previousTime=currentTime;
            for (int i = 100; i < 200; i++) {
                target.DrawScanBuffer(i,300-i,300+i);
                
            }
            target.fillShape(100,200);
           
            display.swapBuffers();
        }
    }
   
}