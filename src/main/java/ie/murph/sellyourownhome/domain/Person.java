package ie.murph.sellyourownhome.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long person_id;

	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;

	public Long getPerson_id() {
		return person_id;
	}
	
	public Person() {}

	public Person(String firstName, String lastName, String password, String username) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
}

	public void setPerson_id(Long person_id) {
		this.person_id = person_id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getPerson_id()).append(", ").append(this.getFirstName()).append(", ").append(this.getLastName());
		return builder.toString();
}

}
