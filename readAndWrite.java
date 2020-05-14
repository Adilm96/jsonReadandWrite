package model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.org.objectweb.asm.TypeReference;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class readAndWrite {

    public static void main(String [] args){

        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("/Users/adilhussain/Desktop/unece.json"));
            TypeReference<List<country>> typeReference = new TypeReference<List<country>>() {};
            List<country> unece = mapper.readValue(inputStream, typeReference);
            for (country c = unece){
                System.out.println("country"+c.getCountry()+"year"+c.getYear()+"population"+c.getPopulation());
            }
            country co= new country();
            co.setCountry("Japan");
            co.setYear(1890);
            co.setPopulation(2101020);
            mapper.writeValue(new File("/Users/adilhussain/Desktop/unece.json"), value);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (JsonParseException e){
            e.printStackTrace();
        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }


}
