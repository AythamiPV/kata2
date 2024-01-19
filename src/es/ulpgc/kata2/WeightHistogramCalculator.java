package es.ulpgc.kata2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightHistogramCalculator implements HistogramCalculator{
    private static final int BIN_SIZE = 20;
    private final List<Person> people;

    public WeightHistogramCalculator(List<Person> people) {
        this.people = people;
    }
    @Override
    public Map<String, Integer> calculate(){
        Map<String, Integer> result = new HashMap<>();
        for(Person p: people){
            String key = toBin(p.getWeight());
            result.put(key, result.getOrDefault(key,0)+1);
        }
        return result;
    }
    private String toBin(double weight){
        return low(weight) + "-"+(higth(weight));
    }

    private int higth(double weight) {
        return low(weight) + BIN_SIZE;
    }
    private int low(double weight){
        return (int) (weight/BIN_SIZE)*BIN_SIZE;
    }
}
