package jnu_escape_1;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * 
 */
public class SetSound {
	/**
     * blackmagic 브금
     */
	public static final String WAV_FILE_PATH = "../bgm/black-magic.wav";
	/**
     * 소리를 조절하는데 필요한 인자
     */
    public static Clip clip;
    /**
     * mainbgm 브금
     */
    public static final String MAIN_BGM_FILE_PATH = "../bgm/mainbgm.wav";
    /**
     * 배경음 온오프 버튼 누른 값을 저장
     */
    public static int nowmp3 = 0;
    /**
     * 배경음 온오프 버튼 이미지
     */
    public static final ImageIcon mp3Icon = new ImageIcon(GameMap.class.getResource("../source/onoff.png"));
    /**
     * 효과음 온오프 버튼을 누른 값을 저장
     */
    public static int noweffect = 0;
    /**
     * 효과음 온오프 버튼 이미지
     */
    public static final ImageIcon effecticon = new ImageIcon(GameMap.class.getResource("../source/onoff.png"));
    /**
     * happyend 브금
     */
    public static final String happy_BGM_FILE_PATH = "../bgm/happyend.wav";
    /**
     * 한 번 눌릴 때마다 nowmp3가 1 증가
     * 배경음악을 끌 땐 값이 홀수, 킬 땐 짝수가 됨
     */
    public static JButton createMP3Button() {
        JButton mp3Button = new JButton(mp3Icon);
        mp3Button.setBounds(150, 320, mp3Icon.getIconWidth(), mp3Icon.getIconHeight());
        mp3Button.setBorderPainted(false);
        mp3Button.setContentAreaFilled(false);
        mp3Button.setFocusPainted(false);
        mp3Button.setOpaque(false);

        mp3Button.addActionListener(e -> {
            if (clip != null && clip.isRunning()) {
                stopMP3();
            } else {
                playMP3();
            }
            nowmp3++;
        });

        return mp3Button;
    }
    /**
     * 효과음을 키고 끄는 기능
     */
    public static JButton createeffectButton() {
        JButton effectButton = new JButton(effecticon);
        effectButton.setBounds(150, 400, effecticon.getIconWidth(), effecticon.getIconHeight());
        effectButton.setBorderPainted(false);
        effectButton.setContentAreaFilled(false);
        effectButton.setFocusPainted(false);
        effectButton.setOpaque(false);

        effectButton.addActionListener(e -> {
            
            noweffect++;
        });

        return effectButton;
    }
    /**
     * 배경음악 재생 기능
     */
    public static void playMP3() {
        try {
            URL wavUrl = SetSound.class.getResource(WAV_FILE_PATH);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(wavUrl);
            clip = AudioSystem.getClip();

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

            clip.open(audioInputStream);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    /**
     * 재생중인 배경음악 끄는 기능
     */
    public static void stopMP3() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }
    
    /**
     * main브금 재생
     */
    public static void playMainBGM() {
        stopMP3(); // 현재 재생 중인 BGM을 멈춥니다.

        try {
            URL mainBGMUrl = SetSound.class.getResource(MAIN_BGM_FILE_PATH);
            AudioInputStream mainBGMAudioInputStream = AudioSystem.getAudioInputStream(mainBGMUrl);
            clip = AudioSystem.getClip();

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

            clip.open(mainBGMAudioInputStream);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * blackmagic 브금 재생
     */
    public static void playBlackMagicBGM() {
        stopMP3(); // 현재 재생 중인 BGM을 멈춥니다.

        try {
            URL blackMagicBGMUrl = SetSound.class.getResource(WAV_FILE_PATH);
            AudioInputStream blackMagicBGMAudioInputStream = AudioSystem.getAudioInputStream(blackMagicBGMUrl);
            clip = AudioSystem.getClip();

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

            clip.open(blackMagicBGMAudioInputStream);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * 퍼즐 오답 효과음
     */
    public static void playNoSoundOnce() {
        try {
            String noSoundFilePath = "../bgm/no.wav";
            URL noSoundUrl = SetSound.class.getResource(noSoundFilePath);
            Clip noSoundClip = AudioSystem.getClip();

            noSoundClip.open(AudioSystem.getAudioInputStream(noSoundUrl));
            noSoundClip.start();

            // 소리가 재생을 마칠 때까지 기다린 후 클립을 닫습니다.
            Thread.sleep(noSoundClip.getMicrosecondLength() / 1000);

            noSoundClip.close();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * happyend 브금 재생
     */
    public static void playhappyendBGM() {
        stopMP3(); // 현재 재생 중인 BGM을 멈춥니다.

        try {
            URL happyendBGMUrl = SetSound.class.getResource(happy_BGM_FILE_PATH);
            AudioInputStream happyendBGMAudioInputStream = AudioSystem.getAudioInputStream(happyendBGMUrl);
            clip = AudioSystem.getClip();

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

            clip.open(happyendBGMAudioInputStream);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}
