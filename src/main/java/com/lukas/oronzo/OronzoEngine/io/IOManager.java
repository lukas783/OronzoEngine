package com.lukas.oronzo.OronzoEngine.io;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/** IOManager.java
 * Created by Lukas on 1/5/2016.
 *
 * IOmanager handles input and output of files from our resources folder. It is currently being
 * used to load shaders for us, this will have to be updated later to load more than just txt,
 * although its framework is set up enough so that it can load most files into a string without issue.
 */
public class IOManager {
    public static String loadFile( InputStream file ) {
        String s, buffer= "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(file));
            while((s = in.readLine())!= null)
                buffer+= s;

            System.out.print(buffer +"\n");
        } catch(FileNotFoundException fnfe) {
            Log.e("File Not Found", "Unable to open file");
            System.exit(1);
        } catch(IOException ioe) {
            Log.e("IO Exception", "Unable to read file");
            System.exit(1);
        }
        return buffer;
    }
}
