package com.lukas.oronzo.OronzoEngine;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * GLView.java, extension of GLSurfaceView
 * Created by Lukas on 1/4/2016.
 *
 * GLView is an extension of GLSurfaceView, it handled our viewport,
 * context, and sets our renderer. This is the basic initialization for
 * OpenGLES and sets up our context and callback functions.
 */

public class GLView extends GLSurfaceView {

    private Render renderer;


    /**
     * GLView(context)
     *  - This is our constructor, when GLView is declared and
     *  - initialized this function is called, it handles setting
     *  - up our context and callback functions by setting renderer
     *  - and our GLES context client version. Not much is done in this
     *  - class outside of that.
     *
     * @param context - our Activity's context
     */
    public GLView(Context context) {
        super(context);

        setEGLContextClientVersion(2);//set our context to GLES2.0

        renderer = new Render();
        setRenderer(renderer);
    }
}
