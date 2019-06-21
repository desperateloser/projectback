package com.project.project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "news", schema = "contactcenter")
public class News implements Serializable {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_news", nullable=false, updatable=false)
    private int id_news;
    @NotNull
    @Column(name = "news_title")
    private String news_title;
    @NotNull
    @Column(name = "news_description")
    private String news_description;
    @Column(name = "publishing_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishing_date;
/*
    @OneToOne(fetch = FetchType.LAZY,optional = false )
    @JoinColumn(name = "id_attachment", nullable = false)
    private Attachment attachment;
*/
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(
        name = "id_admin",
        referencedColumnName = "id_admin",
        insertable = false,
        updatable = false)

private Admin admin;

    protected News (){}


    public News(@NotNull String title, @NotNull String newsDescription, Date publishingDate) {
        this.news_title = title;
        this.news_description = news_description;
        this.publishing_date = publishing_date;
    }

    public int getIdNews() {
        return id_news;
    }

    public void setId_news(int id_news) {
        this.id_news = id_news;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String title) {
        this.news_title = title;
    }

    public String getNews_description() {
        return news_description;
    }

    public void setNews_description(String news_description) {
        this.news_description = news_description;
    }

    public Date getPublishing_date() {
        return publishing_date;
    }

    public void setPublishing_date(Date publishing_date) {
        this.publishing_date = publishing_date;
    }

    @Override
    public String toString() {
        return "News{" +
            "id_news=" + id_news +
            ", news_title='" + news_title + '\'' +
            ", news_description='" + news_description + '\'' +
            ", publishing_date=" + publishing_date +
            '}';
    }
}
