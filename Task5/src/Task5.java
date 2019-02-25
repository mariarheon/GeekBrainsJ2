
import java.util.Arrays;

/**Java 2. Lesson 5. Multithreading. 
 *
 * @author Maria Mikhaleva
 * @version dated Feb 25 2019
 */
public class Task5 {
    
    final int SIZE = 1000000;
    final int HALF_SIZE = SIZE/2;
    
    public static void main(String[] args) {
        Task5 t5 = new Task5();
        t5.withoutThreads();
        t5.withThreads();
        
    }
    
    void withoutThreads(){
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        
        long before = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++)
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        long after = System.currentTimeMillis();
        
        System.out.println("Time with threads:" + (after - before));}
    
    void withThreads(){
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF_SIZE];
        float[] arr2 = new float[HALF_SIZE];
        Arrays.fill(arr, 1);
        
        long before = System.currentTimeMillis();
        
        System.arraycopy(arr, 0, arr1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, arr2, 0, HALF_SIZE);
        
        Thread t1 = new Thread(new CalcArray(arr1, 0));
        Thread t2 = new Thread(new CalcArray(arr2, HALF_SIZE));
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        
        System.arraycopy(arr1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(arr2, 0, arr, HALF_SIZE, HALF_SIZE);
        long after = System.currentTimeMillis();
        
        System.out.println("Time with threads:" + (after - before));
    }
}
