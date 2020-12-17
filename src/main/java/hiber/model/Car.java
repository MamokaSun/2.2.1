package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @OneToOne( mappedBy = "car", cascade = CascadeType.ALL)
    private User user;


    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Long getId() { return this.id; }

    public void setId(Long id) { this.id = id; }

    public String getModel() { return this.model; }

    public void setModel(String model) { this.model = model; }

    public int getSeries(){ return this.series; }

    public void setSeries(int series) { this.series = series; }
}
