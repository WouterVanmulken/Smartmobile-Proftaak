package com.wouterv.quantifiedstudents.Volley;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Interface for passing Volley results
 *
 * Created by sander on 25-5-2016.
 */
public interface IResultFitbit {
    /**
     * Method that contains the JSONObject from a successful request
     * @param requestType
     * @param response
     */
    void notifySuccess(String requestType, JSONArray response);

    /**
     * Method that contains the VolleyError from an unsuccessful request
     * @param requestType
     * @param error
     */
    void notifyError(String requestType, VolleyError error);
}
