package ferreira.couto.raphael.formacaopv.domain.comum;

import javax.persistence.Entity;

@Entity
public class Usuario extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String username;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
