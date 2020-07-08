package codegym.models;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "blogs")
public class Blog {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
    private Timestamp date_create;
    private Long likes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDate_create() {
        return date_create;
    }

    public void setDate_create(Timestamp date_create) {
        this.date_create = date_create;
    }

    public Long getLike() {
        return likes;
    }

    public void setLike(Long likes) {
        this.likes = likes;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
