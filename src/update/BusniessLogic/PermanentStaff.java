package BusniessLogic;

import java.util.ArrayList;
import java.util.List;

public class PermanentStaff extends User {
    private List<Unit> managedUnits;

    public PermanentStaff(int id, String name,String pass, String email, String phone) {
        super(id, name, email,pass, phone);
        this.managedUnits = new ArrayList<>();
    }

    public List<Unit> getManagedUnits() {
        return managedUnits;
    }

    public void setManagedUnits(List<Unit> managedUnits) {
        this.managedUnits = managedUnits;
    }

    public void addManagedUnit(Unit unit) {
        managedUnits.add(unit);
    }

    public void removeManagedUnit(Unit unit) {
        managedUnits.remove(unit);
    }
}
