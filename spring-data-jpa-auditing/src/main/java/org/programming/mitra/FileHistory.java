package org.programming.mitra;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * @author Naresh Joshi
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
public class FileHistory {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "file_id", foreignKey = @ForeignKey(name = "FK_file_history_file"))
    private File file;

    @CreatedBy
    private String actionPerformedBy;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date actionDate;

    @Enumerated(STRING)
    private Action action;

    public FileHistory() {
    }

    public FileHistory(File file, Action action) {
        this.file = file;
        this.action = action;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getActionPerformedBy() {
        return actionPerformedBy;
    }

    public void setActionPerformedBy(String actionPerformedBy) {
        this.actionPerformedBy = actionPerformedBy;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}