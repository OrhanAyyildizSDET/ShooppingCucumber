package pojo;

public class Medunna_CState_Full {
    public Medunna_CState_Full(int id, String name, Medunna_Country_Full country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Medunna_CState_Full() {
    }

    private int id;
    private String name;
    private Medunna_Country_Full country;//required

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

    public Medunna_Country_Full getCountry() {
        return country;
    }

    public void setCountry(Medunna_Country_Full country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CState{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
