package tn.esprint.EdTech.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class userStatus {
    private long nbArchive;
    private long nbDesactive;
    private long nbActive;
}
