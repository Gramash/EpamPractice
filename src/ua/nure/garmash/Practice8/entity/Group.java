package ua.nure.garmash.Practice8.entity;

public class Group {
    int id;
    String name;

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
        StringBuilder result = new StringBuilder().append(" ").append(getName());
        return result.toString();
    }

    public static Group createGroup (String name) {
        Group group = new Group();
        group.name=name;
        return group;
    }
}
