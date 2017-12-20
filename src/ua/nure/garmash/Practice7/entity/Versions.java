package ua.nure.garmash.Practice7.entity;

import java.util.ArrayList;
import java.util.List;

public class Versions {
    List<Version> versionList;

    public List<Version> getVersionList() {
        if (versionList == null) {
            versionList = new ArrayList<Version>();
        }
        return versionList;
    }

    public void setVersionList(List<Version> versionList) {
        this.versionList = versionList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(versionList == null || versionList.size()==0) {
            return "no alternative versions for this drug";
        }
        for (Version version: versionList) {
            sb.append(version).append('\n');
        }
        return sb.toString();
    }
}
