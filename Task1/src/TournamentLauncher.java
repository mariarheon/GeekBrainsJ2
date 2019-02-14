
import java.util.ArrayList;
import java.util.List;

import participant.*;
import course.*;


/** Java2. Lesson 1. OOP
 *
 * @author Maria mikhaleva
 * @version dated Feb 12 2019
 */
public class TournamentLauncher {

    public static void main(String[] args) {

       Animal member1 = new Cat("Barsik", 5, Cat.BREED_BENGAL);
       Animal member2 = new Cat("Pushok", 7, Cat.BREED_SIAMESE);
       Animal member3 = new Dog("Bulya", 10, Dog.BREED_BULLDOG);
       Animal member4 = new Dog("Pioner", 3, Dog.BREED_GREYHOUND);
       Animal member5 = new Human(Gender.MALE, 40, "Stas");
       Animal member6 = new Human(Gender.FEMALE, 20, "Stasy");
       

       Team team = new Team("Super Puper Team1", new Animal[]{member1,member2,member5,member3});
       team.show();
               
       Course course = new Course(new Wall(0.8), new Track(2.2), new Pool(0.7));
       //course.show();
       
       course.doIt(team);
       team.showResult();

    }
    
}
