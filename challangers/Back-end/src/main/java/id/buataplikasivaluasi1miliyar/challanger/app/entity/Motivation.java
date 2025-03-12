package id.buataplikasivaluasi1miliyar.challanger.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "motivation")
@NoArgsConstructor
@AllArgsConstructor
public class Motivation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "motivation_id")
    private Integer motivationId;
    @Column(name = "motivation_quotes")
    private String motivationQuotes;
    @Column(name = "motivation_author")
    private String motivationAuthor;
}
