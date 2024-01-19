import es.ulpgc.kata2.Person;
import es.ulpgc.kata2.TsvFilePersonLoader;
import es.ulpgc.kata2.WeightHistogramCalculator;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Person> people = TsvFilePersonLoader.with("hw_25000.tsv").load();
        Map<String, Integer> histogram = new WeightHistogramCalculator(people).calculate();
        for(String key: histogram.keySet().stream().toList()){
            System.out.println(key + " "+ histogram.get(key));
        }
    }
}