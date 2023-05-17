package BusniessLogic;

import java.util.ArrayList;
import java.util.List;

public class SessionalStaff extends User {
    private List<Unit> engagedUnits;
    private List<Unit> preferencesList;

    public SessionalStaff(int id, String name, String email,String pass, String phone) {
        super(id, name, email, pass, phone);
        this.engagedUnits = new ArrayList<>();
    }

    public List<Unit> getEngagedUnits() {
        return engagedUnits;
    }

    public void setEngagedUnits(List<Unit> engagedUnits) {
        this.engagedUnits = engagedUnits;
    }

    public void addEngagedUnit(Unit unit) {
        engagedUnits.add(unit);
    }

    public void removeEngagedUnit(Unit unit) {
        engagedUnits.remove(unit);
    }
    public List<Unit> getPreferencesList() {
		return preferencesList;
	}

	public void setPreferencesList(List<Unit> preferencesList) {
		this.preferencesList = preferencesList;
	}
}

