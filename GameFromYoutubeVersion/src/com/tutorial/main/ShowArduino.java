package com.tutorial.main;

/**
 * Created by LENOVO on 6/4/2017.
 */
public class ShowArduino {
    int input;
    public void setup() {

    }
    void setupWithoutPublic() {
        //visible to package
    }
    void setUpLight() {
        //pretty much the same
    }
    public ShowArduino() {
        // this is a constructor,
        // without the void or any variable like int
    }
    public int showArduino() {
        return input;
    }// unlike above constructor, this is a method along with other methods
    // that has void or variable.
    public static void main(String[] arg) {
        // c++ has the void int() or something to run the code
        //likewise, java uses this as a run method to run your programs
        // i cast the constructor into an object
        ShowArduino arduino = new ShowArduino();

    }

}
