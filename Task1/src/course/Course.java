
package course;

import participant.*;

/** Java2. Lesson 1. OOP
 *
 * @author Maria mikhaleva
 * @version dated Feb 12 2019
 */
public class Course {
    private Obstacle[] course;

    public Course(Obstacle... course) {
        this.course = course;
    }
    
    public void show(){
        for (Obstacle o : course)
            System.out.println(o.toString());
    }
    
    public void doIt(Team team){
        for (Obstacle  o : course)
            team.doIt(o);
    }
    
}
