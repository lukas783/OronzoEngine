package com.lukas.oronzo.OronzoEngine;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.lukas.oronzo.OronzoEngine.io.IOManager;
import com.lukas.oronzo.OronzoEngine.util.Globals;

public class MainActivity extends Activity {

    private GLSurfaceView glView;
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        /**
         *
         */
        Globals.FRAG_SOURCE = IOManager.loadFile(getResources().openRawResource(R.raw.fragment));
        Globals.VERTEX_SOURCE = IOManager.loadFile(getResources().openRawResource(R.raw.vertex));
        glView = new GLView(this);
        setContentView(glView);


    }
}
