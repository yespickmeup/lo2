/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 *
 * @author Guinness
 */
public class Mp3 {

    public static void main(String[] args) {
        String filename1 = "C:\\Users\\Guinness\\rsc_queue\\voices\\now serving.mp3";
        String filename2 = "C:\\Users\\Guinness\\rsc_queue\\voices\\numbers\\10.mp3";
        String filename3 = "C:\\Users\\Guinness\\rsc_queue\\voices\\letters\\p.mp3";
        try {
            FileInputStream fis = new FileInputStream(filename1);
            BufferedInputStream bis = new BufferedInputStream(fis);
            Player player1 = new Player(bis);
            player1.play();

            FileInputStream fis3 = new FileInputStream(filename3);
            BufferedInputStream bis3 = new BufferedInputStream(fis3);
            Player player3 = new Player(bis3);
            player3.play();

            FileInputStream fis2 = new FileInputStream(filename2);
            BufferedInputStream bis2 = new BufferedInputStream(fis2);
            Player player2 = new Player(bis2);
            player2.play();

        } catch (Exception e) {
            System.out.println("Problem playing file " + filename1);
            System.out.println(e);
        }
    }
    private String filename;
    private Player player;

    // constructor that takes the name of an MP3 file
    public Mp3(String filename) {
        this.filename = filename;
    }

    public void close() {
        if (player != null) {
            player.close();
        }
    }

    // play the MP3 file to the sound card
    public void play() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        } catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            public void run() {
                try {
                    player.play();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();

    }
}
