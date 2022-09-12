package school.devskill.Fumetteria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100)
    private String description;

    private String  image = null;

    @Column(length = 100)
    private String  title;

    @Column(length = 100)
    private Integer dimension;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 100, nullable = false)
    private String type;

    @Column(nullable = false)
    private String author;

    @Column
    private String pages;



}
