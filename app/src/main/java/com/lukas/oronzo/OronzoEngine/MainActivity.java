package com.lukas.oronzo.OronzoEngine;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class MainActivity extends Activity {

    private GLSurfaceView glView;
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        glView = new GLView(this);
        setContentView(glView);
    }
}
