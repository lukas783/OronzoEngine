package com.lukas.oronzo.OronzoEngine;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.lukas.oronzo.OronzoEngine.model.Triangle;
import com.lukas.oronzo.OronzoEngine.util.Globals;

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

    private Triangle t;
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
        GLES20.glClearColor(0f, 0f, 0f, 1.0f); // sets default clear color (R, G, B, A)
        /**
         * This is where we create and load our shaders.
         * vs is our vertex shader, it is loaded using the code stored in Globals.VERTEX_SOURCE,
         * the shader is compiled and fs, our fragment shader, is loaded using code from
         * Globals.FRAG_SOURCE and compiled. the two shaders are linked to our program stored
         * in Globals.SHADER_PROGRAM and linked together with the program. now the shaders can be
         * used when GLES20.glUseProgram(Globals.SHADER_PROGRAM) is called.
         */
        Globals.SHADER_PROGRAM = GLES20.glCreateProgram();
        int vs = GLES20.glCreateShader(GLES20.GL_VERTEX_SHADER);
        GLES20.glShaderSource(vs, Globals.VERTEX_SOURCE);
        GLES20.glCompileShader(vs);
        int fs = GLES20.glCreateShader(GLES20.GL_FRAGMENT_SHADER);
        GLES20.glShaderSource(fs, Globals.FRAG_SOURCE);
        GLES20.glCompileShader(fs);
        Globals.SHADER_PROGRAM = GLES20.glCreateProgram();
        GLES20.glAttachShader(Globals.SHADER_PROGRAM, vs);
        GLES20.glAttachShader(Globals.SHADER_PROGRAM, fs);
        GLES20.glLinkProgram(Globals.SHADER_PROGRAM);
        /**
         * Here we initialize our new triangle class.. this is where our first time set-up stuff
         * will be, so this code will start to get heavy.
         */
        t = new Triangle();
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
        //We draw our triangle to the screen using normalized device coordinates, have to add
        //in world view coordinates and then we can have the objects move around based on (x,y) pos
        t.draw();

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
