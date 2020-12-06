package utils.web.provider;

import com.voicerss.tts.*;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java_fx
 *
 * @author Jan Adams
 * @version 30.11.2020
 */

public class VoiceRSS {

    private final VoiceProvider provider;
    private final String format;
    private byte[] voice;
    private final VoiceParameters parameters;

    public VoiceRSS(String text, String language) {
        provider = new VoiceProvider("eb39d31dd48547f79d6065a8daec5c78");
        format = AudioFormat.Format_44KHZ.AF_44khz_16bit_stereo;
        parameters = new VoiceParameters(text, language);
        voice =  new byte[0];
        adjustParameters();
        textToSpeech();
    }

    private void adjustParameters(){
        parameters.setCodec(AudioCodec.WAV);
        parameters.setFormat(format);
        parameters.setBase64(false);
        parameters.setSSML(false);
        parameters.setRate(0);
    }


    public void textToSpeech(){
        try {
            voice = provider.speech(parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean saveVoiceFile(String path, String fileName){
        FileOutputStream fileOutput;

        try {
            fileOutput = new FileOutputStream(path + fileName);
            fileOutput.write(voice, 0, voice.length);
            fileOutput.flush();
            fileOutput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static void main(String[] args) {
        String loginTxt = "now you can look for you favorites movies";
        System.out.println(new VoiceRSS(loginTxt, Languages.English_Australia).saveVoiceFile("resources/", "LoginVoice.wav"));

    }




}
