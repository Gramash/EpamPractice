package ua.nure.garmash.Practice7.entity;

import java.util.ArrayList;
import java.util.List;

public class Pharmaceuticals {
    List<Medicine> medicines;

    public List<Medicine> getMedicines() {
        if(medicines == null) {
            medicines =  new ArrayList<Medicine>();
        }
        return medicines;
    }

    @Override
    public String toString() {
        if (medicines == null || medicines.size()==0) {
            return "Medicines contains no elements";
        }
        StringBuilder result = new StringBuilder();
        for (Medicine medicine: medicines) {
            result.append(medicine).append('\n');
            result.append("============================").append('\n');
        }

        return result.toString();
    }
}
