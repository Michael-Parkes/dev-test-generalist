package com.example.mike.johnlewisjobapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mike on 30/07/2016.
 */
public class SingleBikeRequest extends StringRequest {
    private static final String SINGLEBIKE_REQUEST_URL = "http://mikeparkes.netai.net/BikeData.php";
    private Map<String, String> params;
    //When a user searches for a bike they dont need to know the price or the description so i have not include them here.
    public SingleBikeRequest(String bikename, String bikeid, Response.Listener<String> listener){
        super(Request.Method.POST, SINGLEBIKE_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", bikename);
        params.put("bikeid", bikeid);
    }
    @Override
    public Map<String, String> getParams(){
        return params;
    }//This class is very similar to BikeRequest.
}

