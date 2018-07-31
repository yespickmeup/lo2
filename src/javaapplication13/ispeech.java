/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;

import com.iSpeech.*;

/**
 *
 * @author Guinness
 */
public class ispeech {

    public static void main(String[] args) {
        ispeech i = new ispeech();
        i.iSpeechTTS("09eee795ce292e9aea1b130360e1d92f", true);
    }

    public void iSpeechTTS(String api, boolean production) {
        try {
            iSpeechSynthesis iSpeechTTS = iSpeechSynthesis.getInstance(api, production);
            String format = "wav"; //or mp3
            iSpeechTTS.setOptionalCommand("format", format);
            File file = new File("tts." + format);

            FileOutputStream out = new FileOutputStream(file);

            iSpeechTTS.setOptionalCommand("voice", "usenglishfemale");
            TTSResult result = iSpeechTTS.speak("hi, how are you?");

            //iSpeechTTS.setOptionalCommand("voice", "usspanishfemale");
            //TTSResult result = iSpeechTTS.speak("hola, ¿cómo estás hoy");
            DataInputStream in = result.getDataInputStream();

            byte[] buffer = new byte[2048];
            int size = 0;
            while ((size = in.read(buffer)) > -1) {
                out.write(buffer, 0, size);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
