package com.example.mike.johnlewisjobapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by Mike on 30/07/2016.
 */
public class BikeRequest extends StringRequest {
    private static final String BIKE_REQUEST_URL = "http://mikeparkes.netai.net/AddBike.php";
    private Map<String, String> params;
    //This will POST what the user puts into the following fields. However, if a user enters blank the database still records.
    public BikeRequest(String bikename, String bikeid, String description, int price, Response.Listener<String> listener){
        super(Method.POST, BIKE_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", bikename);
        params.put("bikeid", bikeid);
        params.put("description", description);
        params.put("price", price + "");//You have to add a string to convert from a int
    }
    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
