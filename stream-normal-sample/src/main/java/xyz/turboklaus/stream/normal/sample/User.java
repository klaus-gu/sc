package xyz.turboklaus.stream.normal.sample;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 **/
public class User {

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    String name;
    Integer age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
