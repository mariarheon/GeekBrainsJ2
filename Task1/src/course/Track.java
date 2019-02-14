
package course;

import participant.*;

/** Java2. Lesson 1. OOP
 *
 * @author Maria mikhaleva
 * @version dated Feb 12 2019
 */
public class Track extends Obstacle{
    
    private double length;

    public Track(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Track{" + "length=" + length + '}';
    }

      @Override
    public boolean doIt(Animal animal) {
        return animal.run(length);
    }
    
    
    
}
