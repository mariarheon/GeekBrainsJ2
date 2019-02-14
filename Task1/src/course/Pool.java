
package course;

import participant.*;

/** Java2. Lesson 1. OOP
 *
 * @author Maria mikhaleva
 * @version dated Feb 12 2019
 */
public class Pool extends Obstacle{
    private double length;

    public Pool(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Pool{" + "length=" + length + '}';
    }

    @Override
    public boolean doIt(Animal animal) {
        if(animal instanceof Swimable)
            return ((Swimable) animal).swim(length);
        return false;
    }

    
    
    
}
