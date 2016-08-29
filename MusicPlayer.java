/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package favexplorer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author lukas
 */
public class MusicPlayer extends JApplet {
    
    private static final int JFXPANEL_WIDTH_INT = 300;
    private static final int JFXPANEL_HEIGHT_INT = 250;
    private static JFXPanel fxContainer;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                LookAndFeelInfo[] s = UIManager.getInstalledLookAndFeels();
                for(LookAndFeelInfo o : s){
                    if(o.getName().equals("GTK+")){
                        UIManager.setLookAndFeel(o.getName());
                    }
                }
                
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            }
            
            JFrame frame = new JFrame("JavaFX 2 in Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JApplet applet = new MusicPlayer();
            applet.init();
            
            frame.setContentPane(applet.getContentPane());
            
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            
            applet.start();
        });
    }
    
    @Override
    public void init() {
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        add(fxContainer, BorderLayout.CENTER);
        // create JavaFX scene
        Platform.runLater(() -> {
            try {
                createScene();
            } catch (MalformedURLException ex) {
                Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void createScene() throws MalformedURLException {
        Button btn = new Button();
        Button btn2 = new Button("Pause");
        Button btn3 = new Button("Stop");
        Button mute = new Button("Mute");
        Button prev = new Button("Prev");
        Button next = new Button("Next");
        Button seek = new Button("Seek");
        btn.setText("Play");
        
         final URL resource = new File(GuiForm.jTextField1.getText()).toURL();
    final Media media = new Media(resource.toString());
    final MediaPlayer mediaPlayer = new MediaPlayer(media);
    mediaPlayer.setAutoPlay(false);
        btn.setOnAction((ActionEvent event) -> {
            mediaPlayer.play();
        });
         btn2.setOnAction((ActionEvent event) -> {
            mediaPlayer.pause();
        });
         btn3.setOnAction((ActionEvent event) -> {
            mediaPlayer.stop();
        }); 
        mute.setOnAction((ActionEvent event) -> {
            if(mute.getText().equals("Mute")){
                mediaPlayer.setMute(true);
                mute.setText("Unmute");
                mute.prefWidth(50);
            }else{
                mediaPlayer.setMute(false);
                mute.setText("Mute");
            }
       
        });
         seek.setOnAction((ActionEvent event) -> {
             Duration d = mediaPlayer.getCurrentTime();
             
        
            mediaPlayer.seek(d.add(Duration.seconds(20)));
            
        });
         
        StackPane root = new StackPane();
        VBox vb = new VBox(20);
        HBox hb = new HBox(75);
        HBox hbx = new HBox(110);
        HBox hb2 = new HBox(75);
        Slider s = new Slider();
        s.setMax(10);
        s.setMin(0);
        
        s.setOnScrollFinished((ScrollEvent event)->{
            mediaPlayer.setVolume(s.getValue());
        });
        hb.setPrefWidth(root.getPrefWidth());
        hb.getChildren().add(btn);
        hb.getChildren().add(btn2);
        hb.getChildren().add(btn3);
        hbx.getChildren().add(s);
        hbx.getChildren().add(mute);
        hb2.getChildren().add(prev);
        hb2.getChildren().add(seek);
        hb2.getChildren().add(next);
        vb.getChildren().add(hb);
        vb.getChildren().add(hbx);
        vb.getChildren().add(hb2);
        root.getChildren().add(vb);
      
       
        fxContainer.setScene(new Scene(root));
        
    
    }
    
}
