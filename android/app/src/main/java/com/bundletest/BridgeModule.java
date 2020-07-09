//  Created by react-native-create-bridge

package com.bundletest;

import android.content.SharedPreferences;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.os.Bundle;
import android.preference.PreferenceManager;
import javax.annotation.Nonnull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BridgeModule extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "Bridge";
    private static ReactApplicationContext reactContext = null;

    BridgeModule(ReactApplicationContext context) {
        super(context);

        reactContext = context;
    }

    @Override
    @Nonnull
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void getBundle(Promise promise) {
        final Bundle bundle = new Bundle();
        bundle.putStringArray("strings", new String[] {"youpi"});

        final Bundle nestedBundle = new Bundle();
        nestedBundle.putFloat("float", 3.14f);
        bundle.putBundle("bundle", nestedBundle);

        promise.resolve(bundle);
    }

    @ReactMethod
    public void getList(Promise promise) {
        promise.resolve(Arrays.asList("youpi", "this", "should", "work"));
    }

    @ReactMethod
    public void getArray(Promise promise) {
        promise.resolve(new String[] {"youpi", "this", "should", "work"});
    }
}
