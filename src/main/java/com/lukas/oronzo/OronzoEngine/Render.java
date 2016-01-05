package com.lukas.oronzo.OronzoEngine;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Render.java - An implementatoin of Renderer.java (GLSurfaceView.Renderer)
 * Created by Lukas on 1/4/2016..
 *
 * Render handles most draw calls to the screen, the class is set as the default
 * renderer for our context view.
 */
public class Render implements GLSurfaceView.Renderer {

    /**
     * void onSurfaceCreated(g, c)
     *  - When screen is created and after everything has been
     *  - initialized this callback function is set. Not much will
     *  - be done here, might implement player loading here..
     *
     * @param g - GL10 Graphics (Deprecated&Useless, dont use)
     * @param c - GL10 Configuration (Deprecated&Useless, dont use)
     */
    @Override
    public void onSurfaceCreated(GL10 g, EGLConfig c) {
        GLES20.glClearColor(0.1f, 0.8f, 0.6f, 1.0f); // sets default clear color (R, G, B, A)
    }

    /**
     * void onDrawFrame(g)
     * - The screen is updated at the refresh rate of the phone
     * - this function is called to draw the frame, probably not
     * - a good idea to overload this function with too much drawing
     * - will look into how drawing could be handled elsewhere.
     *
     * @param g - GL10 Graphics (Deprecated&Useless, dont use)
     */
    @Override
    public void onDrawFrame(GL10 g) {
        //Calls the clear command from GLES, this instance clears the color and depth
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

    }

    /**
     * void onSurfaceChanged(g, width, height)
     * - The phone will be rotated occasionally, like landscape and portrait mode,
     * - should change our viewport and camera view to accomodate for this.
     * @param g - GL10 Graphics (Deprecated&Useless, dont use)
     * @param width - the screen's width (in portrait width < height, in landscape width > height)
     * @param height - the screen's height, see above
     */
    @Override
    public void onSurfaceChanged(GL10 g, int width, int height) {
        // when surface changes... reloads, resizes, etc... changes viewport to fit..
        GLES20.glViewport(0, 0, width, height);
    }


}
