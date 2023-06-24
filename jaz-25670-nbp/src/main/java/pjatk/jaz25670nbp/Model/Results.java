package pjatk.jaz25670nbp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(minLength = 1, maxLength = 100)
    private String currency;
    @Schema(minLength = 1, maxLength = 100)
    private String start_date;
    @Schema(minLength = 1, maxLength = 100)
    private String end_date;
    private double average;
    private LocalDateTime query_date;

    public Results(String currency, String start_date, String end_date, double average, LocalDateTime query_date) {
        this.currency = currency;
        this.start_date = start_date;
        this.end_date = end_date;
        this.average = average;
        this.query_date = query_date;
    }

    public Results() {
    }

}

