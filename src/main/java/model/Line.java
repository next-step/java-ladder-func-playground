package model;

import java.util.ArrayList;
import java.util.List;

public record Line (List<Step> steps){
    public Line(List<Step> steps) {
        this.steps = steps;
    }
}
