/**Java 2. Lesson 5. Multithreading. 
 *
 * @author Maria Mikhaleva
 * @version dated Feb 25 2019
 */
public class CalcArray implements Runnable{

    private float[] array;
    private int shift;
    
    CalcArray(float[] array, int shift){
        this.array = array;
        this.shift = shift;
    }
    @Override
    public void run() {
        for(int i = 0; i < array.length; i++){
            array[i] = (float)(array[i] * Math.sin(0.2f + (i + shift) / 5) * Math.cos(0.2f + (i + shift) / 5) * Math.cos(0.4f + (i + shift) / 2));
        }
    }
    
}
