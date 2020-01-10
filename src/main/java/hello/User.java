package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.MultitenantType;
import org.eclipse.persistence.annotations.TenantTableDiscriminator;
import org.eclipse.persistence.annotations.TenantTableDiscriminatorType;

@Entity // This tells Hibernate to make a table out of this class
@Multitenant(MultitenantType.TABLE_PER_TENANT)
@TenantTableDiscriminator(type = TenantTableDiscriminatorType.SCHEMA, contextProperty = "eclipselink.tenant-id")
public class User {
    @Id
    private String id;

    private String name;

    private String email;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}

