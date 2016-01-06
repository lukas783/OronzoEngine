package com.lukas.oronzo.OronzoEngine;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

import com.lukas.oronzo.OronzoEngine.util.Globals;

/**
 * GLView.java, extension of GLSurfaceView
 * Created by Lukas on 1/4/2016.
 *
 * GLView is an extension of GLSurfaceView, it handled our viewport,
 * context, and sets our renderer. This is the basic initialization for
 * OpenGLES and sets up our context and callback functions.
 */

public class GLView extends GLSurfaceView {

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

        Render renderer = new Render();
        setRenderer(renderer);
    }

    /**
     * boolean onTouchEvent(e)
     *  - Our touch event handler, when input to the screen through touch happens, this function
     *  - will be called and will handle everyting using our motion event e. This function must be
     *  - in our GLSurfaceView extension as it is the view/context we are touching.
     *  -  I may move this to its own class later on by pointing a function call to another file
     *  -  not entirely sure if it will be a concern or not, when more files and functions are added
     *  -  i will have to re-organize some things into packages such as model, io, event, etc.
     *
     * @param e - our motion event, is an in abstract class (i think) that contains all of
     *          - our touch events information such as xy pos and button presses
     * @return - true if successfully processed, false if not.
     */
    @Override
    public boolean onTouchEvent(MotionEvent e) {

        if(Globals.IS_TOUCHED && (e.getAction() == MotionEvent.ACTION_MOVE)) {
            System.out.println("Button Dragged to "+e.getX()+" , "+e.getY());
        }
        if(!Globals.IS_TOUCHED && (e.getAction() == MotionEvent.ACTION_DOWN)) {
            Globals.IS_TOUCHED = true;
            System.out.println("Button Pressed at " +e.getX()+ " , " +e.getY());
        }
        if(Globals.IS_TOUCHED && (e.getAction() == MotionEvent.ACTION_UP)) {
            Globals.IS_TOUCHED = false;
            System.out.println("Button Released at " +e.getX()+ " , " +e.getY());
        }
        //System.out.println(e.getAction() + " | Down = "+MotionEvent.ACTION_DOWN+" | Up = " +MotionEvent.ACTION_UP);
        return true;
    }
}
