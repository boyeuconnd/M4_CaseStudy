package codegym.models.blogs;


import codegym.models.Users;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "blogs")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
    private Timestamp date_create = new Timestamp(System.currentTimeMillis());

    @Column(columnDefinition = " default 0")
    private Long likes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users_id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;


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

    public Users getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Users users_id) {
        this.users_id = users_id;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }
}
