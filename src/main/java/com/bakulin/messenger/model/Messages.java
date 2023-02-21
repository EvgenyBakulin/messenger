package com.bakulin.messenger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long author;
    private String text;
    private List<String> correspondents;
    private List <String> file;
    private LocalDateTime date;
    private boolean isRead;
    @ManyToOne
    @JoinColumn(name = "users")
    @JsonIgnore
    private Users users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Messages message)) return false;
        return isRead() == message.isRead() && Objects.equals(getId(), message.getId()) && Objects.equals(getAuthor(), message.getAuthor()) && Objects.equals(getText(), message.getText()) && Objects.equals(getCorrespondents(), message.getCorrespondents()) && Objects.equals(getFile(), message.getFile()) && Objects.equals(getDate(), message.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthor(), getText(), getCorrespondents(), getFile(), getDate(), isRead());
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", author=" + author +
                ", text='" + text + '\'' +
                ", correspondents=" + correspondents +
                ", file=" + file +
                ", date=" + date +
                ", isRead=" + isRead +
                '}';
    }
}
