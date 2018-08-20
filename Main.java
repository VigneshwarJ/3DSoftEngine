public class Main{

    public static void main(String[] args) {
        System.out.println("Hello world");
        Display display = new Display(800,600,"hhh");
        //System.out.println("fool");
        while (true) {
            //System.out.println("fool1");
            display.swapBuffers();
        }
    }
   
}