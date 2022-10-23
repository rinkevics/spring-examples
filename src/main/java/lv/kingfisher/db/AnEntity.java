package lv.kingfisher.db;

import javax.persistence.*;

@Entity
public class AnEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Integer id;

    public String name;

    public AnEntity(String name) {
        this.name = name;
    }

    public AnEntity() {
    }

}
