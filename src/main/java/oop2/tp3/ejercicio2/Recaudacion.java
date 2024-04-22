package oop2.tp3.ejercicio2;

import oop2.tp3.ejercicio2.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Recaudacion {
    public static final String COMPANY_NAME = "company_name";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String ROUND = "round";
    private List<String[]> datos;

    public Recaudacion() {
        try {
            this.datos = new Reader().read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, String>> where(Map<String, String> options)
            throws IOException {

        if (options.containsKey(COMPANY_NAME)) {
            datos = filter((fila)->fila[1].equals(options.get(COMPANY_NAME)));
        }

        if (options.containsKey(CITY)) {
            datos = filter((fila) -> fila[4].equals(options.get(CITY)));
        }

        if (options.containsKey(STATE)) {
            datos = filter((fila) -> fila[5].equals(options.get(STATE)));
        }

        if (options.containsKey(ROUND)) {
            datos = filter((fila) -> fila[9].equals(options.get(ROUND)));
        }

        List<Map<String, String>> output = convertirMaps();
        return output;
    }

    private List<Map<String, String>> convertirMaps() {
        List<Map<String, String>> output = new ArrayList<Map<String, String>>();

        for (String[] dato : datos) {
            Map<String, String> mapped = new HashMap<String, String>();
            mapped.put("permalink", dato[0]);
            mapped.put(COMPANY_NAME, dato[1]);
            mapped.put("number_employees", dato[2]);
            mapped.put("category", dato[3]);
            mapped.put(CITY, dato[4]);
            mapped.put(STATE, dato[5]);
            mapped.put("funded_date", dato[6]);
            mapped.put("raised_amount", dato[7]);
            mapped.put("raised_currency", dato[8]);
            mapped.put(ROUND, dato[9]);
            output.add(mapped);
        }
        return output;
    }

    private List<String[]> filter(Predicate<String[]> predicate) {
        List<String[]> results = new ArrayList<String[]>();

        for (String[] element : datos) {
            if (predicate.test(element)) {
                results.add(element);
            }
        }
        return results;
    }

}
