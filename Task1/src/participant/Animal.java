
package participant;

/** Java2. Lesson 1. OOP
 *
 * @author Maria mikhaleva
 * @version dated Feb 12 2019
 */
public abstract class Animal implements Runable{
    private int age;
    private String name;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" + "age=" + age + ", name=" + name + '}';
    }

    
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    
    public String smallInfo(){
        return "Animal";
    }
    
}
