package tn.esprint.EdTech.Exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class errorDetails {
    private String message;
    private String uri;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyy hh:mm:ss")
    private Date timeStamp;

    public errorDetails(){
        this.timeStamp = new Date();
    }

    public errorDetails(String message, String uri) {
        this();
        this.message = message;
        this.uri = uri;
    }
}
