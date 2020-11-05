
package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rolesId;
    private String role;
    
    @OneToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    List<UserRolesEntity> userRolesList;

    public RolesEntity() {
    }

    public int getRolesId() {
        return rolesId;
    }

    public void setRolesId(int rolesId) {
        this.rolesId = rolesId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<UserRolesEntity> getUserRolesList() {
        return userRolesList;
    }

    public void setUserRolesList(List<UserRolesEntity> userRolesList) {
        this.userRolesList = userRolesList;
    }

    
    
    
}
