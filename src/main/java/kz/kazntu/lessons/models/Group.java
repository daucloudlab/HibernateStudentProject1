package kz.kazntu.lessons.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {
    private long id ;
    private String name ;

    private Set<User> users = new HashSet<User>() ;

    public Group(){

    }
    public Group(String name) {
        this.name = name;
    }

    public void addUser(User user){
        this.users.add(user) ;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Users_Groups",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Id
    @GeneratedValue
    @Column(name = "group_id")
    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
