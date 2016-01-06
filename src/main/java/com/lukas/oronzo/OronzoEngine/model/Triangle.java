package com.lukas.oronzo.OronzoEngine.model;

import android.opengl.GLES20;

import com.lukas.oronzo.OronzoEngine.util.Globals;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/** Triangle.java
 * Created by Lukas on 1/5/2016.
 *
 * Triangle is just a test class, courtesy of Android's OpenGLES test files. It is just to draw
 * a green triangle to the screen to make sure our shaders work correctly. Once image reading is
 * finished, this class will more than likely be deprecated or deleted and replaced with a sprite
 * batch library or image loading library.
 */
public class Triangle {
    private FloatBuffer vertexBuffer;
    private static final int COORDS_PER_VERTEX = 3; // 3 vertices per triangle...
    private static float triangleCoords[] = {
            0.0f, 1.0f, 0.0f,
            -0.5f, -0.0f, 0.0f,
            0.5f, 0.0f, 0.0f
    };
    private float triangleColor[] = {
        0.64f, 0.77f, 0.22f, 1.0f
    };

    public Triangle() {
        ByteBuffer bb= ByteBuffer.allocateDirect(triangleCoords.length * 4);
        bb.order(ByteOrder.nativeOrder());

        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(triangleCoords);
        vertexBuffer.position(0);

    }

    private int mPositionHandle;
    private int mColorHandle;

    private final int vertexCount = triangleCoords.length / COORDS_PER_VERTEX;
    private final int vertexStride = COORDS_PER_VERTEX * 4; // 4 bytes per vertex

    public void draw() {
        // Add program to OpenGL ES environment
        GLES20.glUseProgram(Globals.SHADER_PROGRAM);

        // get handle to vertex shader's vPosition member
        mPositionHandle = GLES20.glGetAttribLocation(Globals.SHADER_PROGRAM, "vPosition");

        // Enable a handle to the triangle vertices
        GLES20.glEnableVertexAttribArray(mPositionHandle);

        // Prepare the triangle coordinate data
        GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX,
                GLES20.GL_FLOAT, false,
                vertexStride, vertexBuffer);

        // get handle to fragment shader's vColor member
        mColorHandle = GLES20.glGetUniformLocation(Globals.SHADER_PROGRAM, "vColor");

        // Set color for drawing the triangle
        GLES20.glUniform4fv(mColorHandle, 1, triangleColor, 0);

        // Draw the triangle
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount);

        // Disable vertex array
        GLES20.glDisableVertexAttribArray(mPositionHandle);
    }
}
