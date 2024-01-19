package es.ulpgc.kata2;

import java.util.List;
import java.util.Map;

public class MeanCalculator {
        public Map<String, Double> calculate(List<Person> people){
            return Map.of("Height", meanHeigth(people),
                    "weigth", meanWeigth(people));
    }
    private double meanHeigth(List<Person> people){
            return people.stream().mapToDouble(Person::getHeight).average().orElse(0);
    }
    private double meanWeigth(List<Person> people){
        return people.stream().mapToDouble(Person::getWeight).average().orElse(0);
    }

}
