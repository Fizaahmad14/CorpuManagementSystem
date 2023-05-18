package BusniessLogic;

public class Unit {
    private int id;
    private String name;

    public Unit(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters for the fields

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

    // Additional methods

    public void printDetails() {
        System.out.println("Unit ID: " + id);
        System.out.println("Name: " + name);
    }

    // Override toString() method for custom string representation

    @Override
    public String toString() {
        return "Unit [id=" + id + ", name=" + name + "]";
    }
}

