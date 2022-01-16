package by.rabkov.anderson.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "Person_Quality",
               joinColumns = {@JoinColumn (name = "person_id")},
               inverseJoinColumns = {@JoinColumn(name = "quality_id")}
               )
    private List<Quality> qualityList;

    public Person() {}

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(int id, String name, List<Quality> qualityList) {
        this.id = id;
        this.name = name;
        this.qualityList = qualityList;
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

    public List<Quality> getQualityList() {
        return qualityList;
    }

    public void setQualityList(List<Quality> qualityList) {
        this.qualityList = qualityList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qualityList=" + qualityList +
                '}';
    }
}
