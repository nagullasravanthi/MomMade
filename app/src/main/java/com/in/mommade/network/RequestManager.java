package com.in.mommade.network;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequestManager {
    private static final Object TAG = RequestManager.class.getSimpleName();
    public static final int VOLLEY_REQUEST_TIMEOUT = 60000;
    public static final int VOLLEY_MAXIMUM_RETRIES = 1;
    public static final int VOLLEY_BACK_OFF_MULTIPLIER = 2;
    /**
     * t{@link RequestQueue} containing all the requests which are send by our application.
     */
    private RequestQueue mRequestQueue;
    private static RequestManager instance;

    public static RequestManager getInstance() {
        if (instance == null) {
            instance = new RequestManager();
        }
        return instance;
    }

    /**
     * @param context application context
     */
    public void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    /**
     * Returns the request queue associated with our application.Parameter context should be at the application level for creating
     * the RequestQueue.
     *
     * @return {@link RequestQueue} associated with our application.
     * @throws IllegalStateException if the request queue is not initialized.
     */
    public RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("Not initialized");
        }
    }

    /**
     * Cancels all the pending requests in the request queue.
     */
    public void cancelAllRequests() {
        if (getRequestQueue() != null) {
            getRequestQueue().cancelAll(new RequestQueue.RequestFilter() {

                @Override
                public boolean apply(Request<?> arg0) {
                    // return true for cancelling the requests.
                    return true;
                }
            });
        }
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        req.setRetryPolicy(new DefaultRetryPolicy(VOLLEY_REQUEST_TIMEOUT,
                VOLLEY_MAXIMUM_RETRIES, VOLLEY_BACK_OFF_MULTIPLIER));
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        req.setRetryPolicy(new DefaultRetryPolicy(VOLLEY_REQUEST_TIMEOUT,
                VOLLEY_MAXIMUM_RETRIES, VOLLEY_BACK_OFF_MULTIPLIER));
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
