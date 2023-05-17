package BusniessLogic;

public class Qualification {
	private int qualificationId;
	private String education; //masters bachelors etc
    private String certification; //BSCS, MSCS etc

    public Qualification(String qualificationName, String education,String certification) {
        this.certification = qualificationName;
        this.education = education;
        this.certification = certification;
    }

    // Getters and setters for the fields

    @Override
	public String toString() {
		return "Qualification [qualificationId=" + qualificationId + ", education=" + education + ", certification="
				+ certification + "]";
	}

	public int getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(int qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCertificationName() {
        return certification;
    }

    public void setCertificationName(String qualificationName) {
        this.certification = qualificationName;
    }

}

