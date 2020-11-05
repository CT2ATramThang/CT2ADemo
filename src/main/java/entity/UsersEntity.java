package entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UsersEntity {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    
    private String userName;

    private String password;
    private int enabled;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    List<UserRolesEntity> userRolesList;
    
    public UsersEntity() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public List<UserRolesEntity> getUserRolesList() {
        return userRolesList;
    }

    public void setUserRolesList(List<UserRolesEntity> userRolesList) {
        this.userRolesList = userRolesList;
    }

    

}
