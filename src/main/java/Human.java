import java.util.UUID;

public interface Human {
    UUID getId();

    String getFirstName();

    String getLastName();

    int getAge();

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setAge(int age);
}
