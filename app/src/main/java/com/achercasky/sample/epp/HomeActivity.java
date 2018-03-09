package com.achercasky.sample.epp;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.achercasky.eppermissions.BasePermissions;
import com.achercasky.eppermissions.Constants;
import com.achercasky.sample.R;

public class HomeActivity extends BasePermissions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        requestPermissions(Constants.Permissions.PERMISSIONS_REQUEST_LOCATION);
    }

    @Override
    public String[] getPermissions() {
        return new String[]{Manifest.permission. ACCESS_FINE_LOCATION};
    }

    @Override
    public void onPermissionAccepted() {
        Toast.makeText(this, "Acepto el permiso", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPermissionDenied() {
        Toast.makeText(this, "LO RECHAZO", Toast.LENGTH_LONG).show();
    }
}
