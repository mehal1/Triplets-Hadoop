package com.mehal;
import java.util.*;

public class HashMapList {
    private Map<String, List<String>> mapObject;    //creating a HashMap object
    HashMapList()
    {  //constructor
        mapObject = new HashMap<>();
    }

//inserting key and its values in the HashMap
    public List<String> creatingMap(String mapKey, String mapValue) {
        List<String> listObj;

        if (mapObject.get(mapKey) == null)
            listObj = new ArrayList<>();
        else
            listObj = mapObject.get(mapKey);

        listObj.add(mapValue);
        return mapObject.put(mapKey, listObj);
    }

    public Set<String> returnKeySet() {      //function to return all keys in the HashMap
        return mapObject.keySet();
    }

    public List<String> getKey(Object key) {    //returns a key from the HashMap
        return mapObject.get(key);
    }

    public boolean containsKey(Object key) {      //returns true if the key exists in HashMap
        return mapObject.containsKey(key);
    }//particular obj's containskey

}
