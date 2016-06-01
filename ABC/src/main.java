import java.io.IOException;

class def {

    public void defg(Runnable a) {
        a.run();

    }
}
class main{

    public static void main(String args[]) throws IOException
    {

        def a = new def();
        a.defg(()->{
                for (int i=0;i<100000;i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(1 + " " +i);
                }
        }
         );

        a.defg(()->{
                for (int i=0;i<100000;i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    System.out.println(2 + " " +i);
                }

        });


    }

}