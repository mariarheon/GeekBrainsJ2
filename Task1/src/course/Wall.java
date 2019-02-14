
package course;

import participant.*;

/** Java2. Lesson 1. OOP
 *
 * @author Maria mikhaleva
 * @version dated Feb 12 2019
 */
public class Wall extends Obstacle{
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Wall{" + "height=" + height + '}';
    }

    @Override
    public boolean doIt(Animal animal) {
    if(animal instanceof Jumpable)
        return ((Jumpable)animal).jump(height);
    return false;
    }    
    
}
