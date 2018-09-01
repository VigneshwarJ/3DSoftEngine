public class Main{

    public static void main(String[] args) {
        System.out.println("Hello world");
        Display display = new Display(800,600,"hhh");
        Bitmap target = display.GetFrameBuffer();
        long previousTime = System.nanoTime();
        StarField stars = new StarField(406, 64.0f, 30.0f); 
        //System.out.println("fool");
        while (true) {
            //System.out.println("fool1");
            long currentTime = System.nanoTime();
            int count=0;
            float delta = (float)((currentTime - previousTime)/1000000000.0);
            stars.UpdateAndRender(target, delta);
           // System.out.println(delta);
            previousTime=currentTime;
            //System.out.println(previousTime);
            //System.out.println(delta);
            display.swapBuffers();
        }
    }
   
}