package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>()); return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount(); list.addCity(new City("Estevan", "SK")); assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity(){
        list = MockCityList();
        City city = new City("Vancouver", "British Columbia");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));

    }

    @Test
    public void testDelete(){
        list = MockCityList();
        City city = new City("Vancouver", "British Columbia");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        list.delete(city);
        assertFalse(list.hasCity(city));
    }

    @Test
    public void testDeleteException(){
        list = MockCityList();
        City city = new City("Vancouver", "British Columbia");
        assertThrows( IllegalArgumentException.class, () -> {
            list.delete(city); });
    }

    @Test
    public void testCountCities(){
        list = MockCityList();
        int cityCountPre = list.countCities();
        Assert.assertEquals(0, cityCountPre);
        list.addCity(new City("Vancouver", "British Columbia"));
        list.addCity(new City("Charlottetown", "Prince Edward Island"));
        list.addCity(new City("Yellowknife", "Northwest Territories"));



        int cityCountPost = list.countCities();

        Assert.assertEquals(3, cityCountPost);
    }

}
