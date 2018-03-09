package com.achercasky.eppermissions;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by achercasky on 06/03/2018.
 */

public abstract class BasePermissions extends AppCompatActivity {

    @Override
    public void onRequestPermissionsResult(final int requestCode,
                                           @NonNull final String[] permissions, @NonNull final int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == Constants.Permissions.PERMISSIONS_REQUEST_LOCATION) {
            // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onPermissionAccepted();
            } else {
                onPermissionDenied();
            }
        }
    }

    protected void requestPermissions(@NonNull final int permissionCode) {
        final String[] permissions = getPermissions();
        final int code = validatePermissionCode(permissionCode);

        if (permissions != null) {
            ActivityCompat.requestPermissions(this, permissions, code);
        }
    }

    private int validatePermissionCode(@NonNull final int code) {

        if (code == 0) {
            throw new AssertionError("You need to set the permission code using the Constant class. " +
                    "You must not return 0!");
        } else {
            return code;
        }
    }

    public abstract String[] getPermissions();

    public abstract void onPermissionAccepted();

    public abstract void onPermissionDenied();

}


