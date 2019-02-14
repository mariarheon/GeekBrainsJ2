
package participant;

/** Java2. Lesson 1. OOP
 *
 * @author Maria mikhaleva
 * @version dated Feb 12 2019
 */
public enum Gender {
    MALE(0.9), FEMALE(0.8);
    
    private double strength;

    private Gender(double strength) {
        this.strength = strength;
    }

    public double getStrength() {
        return strength;
    }
    
}
