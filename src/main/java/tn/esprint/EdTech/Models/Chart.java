package tn.esprint.EdTech.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Chart {
    private List<ValidationsStats> validationsStats;
    private List<ValidationsStats> creationStats;
}
