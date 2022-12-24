package com.bichngoc.lab2;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class NoteEntity implements Serializable {
    private static int count = 0;
    private Integer id;
    private String title,content;
    private Date createTime;

    public NoteEntity(String title, String content, Date createTime) {
        this.id = count++;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        NoteEntity.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
