package ifrs.crud.clients.models;

import java.util.Date;

import ifrs.crud.clients.core.ClientsConstants;

public class PersonalClient extends Client {

	private String rg;
	private String cnh;
	private String motherName;
	private String fatherName;
	private Date birthDate;
	
	public PersonalClient() {
		super(ClientsConstants.PERSONAL);
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
}
