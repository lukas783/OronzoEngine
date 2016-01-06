package com.lukas.oronzo.OronzoEngine.util;

/**
 * Globals.java
 * Created by Lukas on 1/5/2016.
 *
 * Globals is a public class with static variables inside. This class is for any variable that
 * is needed in multiple classes for any reason. use of static will make sure that it is initialized
 * once and can be called by Globals.VAR_NAME.
 */
public class Globals {
    public static boolean IS_TOUCHED = false; // our touchevent boolean
    public static int SHADER_PROGRAM;
    public static String FRAG_SOURCE = "";
    public static String VERTEX_SOURCE = "";
}
