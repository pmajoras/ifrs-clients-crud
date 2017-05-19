package ifrs.crud.clients.models;

import java.util.Date;

public abstract class Client extends Entity {
	
	private String clientType;
	private String address;
	private String name;
	private String cep;
	private String cpfCnpj;
	private String phone;
	private String email;
	
	public Client(String clientType) {
		this.clientType = clientType;
	}
	
	public String getClientType() {
		return clientType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
