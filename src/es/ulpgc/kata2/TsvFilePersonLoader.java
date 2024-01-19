package es.ulpgc.kata2;

import java.io.*;
import java.util.Collections;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class TsvFilePersonLoader implements PersonLoader{
    private final File file;
    private TsvFilePersonLoader(File file){this.file=file;}

    public static PersonLoader with(String file){return new TsvFilePersonLoader(new File(file));}
    @Override
    public List<Person> load(){
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            return load(reader);
        }catch (IOException e){
            return Collections.emptyList();
        }
    }
    private List<Person> load(BufferedReader reader) throws IOException{
        return reader.lines().skip(1).map(this::toPerson).collect(toList());
    }
    private Person toPerson(String line){return toPerson(line.split("\t"));}

    private Person toPerson(String[] fields){
        return new Person(  parseInt(fields[0]),parseDouble(fields[1]),parseDouble(fields[2]));
    }

}
