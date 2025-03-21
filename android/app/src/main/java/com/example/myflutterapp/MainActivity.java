package com.example.myflutterapp;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "com.example.mykotlinapp/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler((@NonNull MethodCall call, @NonNull MethodChannel.Result result) -> {
                    if (call.method.equals("getUsers")) {
                        List<Map<String, String>> users = getUsersFromContentProvider();
                        if (users != null) {
                            result.success(users);
                        } else {
                            result.error("UNAVAILABLE", "User data not available", null);
                        }
                    } else {
                        result.notImplemented();
                    }
                });
    }

    private List<Map<String, String>> getUsersFromContentProvider() {
        List<Map<String, String>> userList = new ArrayList<>();
        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        Uri uri = Uri.parse("content://com.example.mykotlinapp.provider/users");

        try (Cursor cursor = contentResolver.query(uri, null, null, null, null)) {
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    Map<String, String> user = new HashMap<>();
                    user.put("id", cursor.getString(cursor.getColumnIndexOrThrow("_id")));
                    user.put("name", cursor.getString(cursor.getColumnIndexOrThrow("name")));
                    user.put("email", cursor.getString(cursor.getColumnIndexOrThrow("email")));
                    userList.add(user);
                }
            }
        } catch (Exception e) {
            Log.e("ContentProvider", "Error retrieving data", e);
            return null;
        }

        return userList;
    }
}
