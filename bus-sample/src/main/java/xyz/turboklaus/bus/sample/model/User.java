package xyz.turboklaus.bus.sample.model;

/**
 * @program: sc
 * <p>
 * [desc]
 * @author: Klaus_gu
 * @createTime: 2020-11-04 22:14
 * @vsersion: 1.0
 **/
public class User {
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

}
