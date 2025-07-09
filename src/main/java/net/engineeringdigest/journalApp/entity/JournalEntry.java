package net.engineeringdigest.journalApp.entity;

import javafx.print.Collation;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document //(collection =
@Data
//@Setter
//@Getter
@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
public class JournalEntry {

    @Id
    private ObjectId id;

    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;

}
