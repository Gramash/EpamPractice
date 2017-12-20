package ua.nure.garmash.Practice7.entity;

import java.util.ArrayList;
import java.util.List;

public class Medicine {
    private int id;
    private String name;
    private String pharm;
    private String group;
    private List<String> analogsList;
    private Versions versions;
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

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<String> getAnalogsList() {
        if (analogsList == null) {
            analogsList = new ArrayList<>();
        }
        return analogsList;
    }

    public void setVersions(Versions versions) {
        this.versions = versions;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder().append("Medicine # " + id).append('\n');
        sb.append("Name: " + name).append('\n').
                append("Pharmacy organisation: " + pharm).append('\n').
                append("Group: " + group).append('\n').append("analogs: ");
        for (String analogs : analogsList) {
            sb.append(analogs).append(",");
        }
        sb.append("\n").append(versions);
        return sb.toString();
    }
}
