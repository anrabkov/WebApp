package by.rabkov.anderson.entity;

import javax.persistence.*;


@Entity
@Table(name = "Quality")
public class Quality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quality_id")
    private int id;

    @Column(name = "name")
    private String name;

    public Quality() {}

    public Quality(String name) {
        this.name = name;
    }

    public Quality(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "Quality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
