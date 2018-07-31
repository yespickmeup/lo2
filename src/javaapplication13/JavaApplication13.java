/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Guinness
 */
public class JavaApplication13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String file_serving = "C:\\Users\\Guinness\\Downloads\\Music\\38847666.mp3";
        speak();
    }

    public static void speak() {
        try {

            String directory = System.getProperty("user.home");
            directory = directory + "\\rsc_queue\\synthesize\\";
            String now_serving = "now_serving.wav";

            String filename = "C:\\Users\\Guinness\\Downloads\\Music\\38847666.mp3";
            System.out.println("directory: " + filename);
            File file = new File(filename);
            final Clip clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                }
            });

            clip.open(AudioSystem.getAudioInputStream(file));
            System.out.println("Playing audio file...");
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException xe) {
            System.out.println(xe);
        }
    }

}
