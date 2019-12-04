import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HumanTest {
    @Test
    public void gettersTest(){
        Human human = new Person("John", "Doe", 55);

        Assertions.assertEquals("John", human.getFirstName());
        Assertions.assertEquals("Doe", human.getLastName());
        Assertions.assertEquals(55, human.getAge());
    }

    @Test
    public void settersTest(){
        Human human = new Person("John", "Doe", 55);

        human.setFirstName("Mike");
        human.setLastName("Johnsson");
        human.setAge(22);

        Assertions.assertEquals("Mike", human.getFirstName());
        Assertions.assertEquals("Johnsson", human.getLastName());
        Assertions.assertEquals(22, human.getAge());
    }
}
