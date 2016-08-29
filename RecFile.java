package favexplorer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 *  This class can check if given file is: JFIF,PNG,WAVE,GIF,ZIP/JAR,7z.The class won't check if the file actually exists, it must be checked before otherwise the class throws IOException.
 * @author JCrusher
 * @version 1.0
 */
public class RecFile {
    
   public static void main(String[] args) throws IOException{
       boolean b = is7z(new File("/home/lukas/Desktop/obraz.gif"));
       System.out.print(b);
   }
   /**
   *Checks wheter the file is wave file.
     * @param f  the file which type is needed to be known
     * @return boolean isWave - if file is wave file it is true, otherwise false. 
     * @throws java.io.IOException 
   */
    public static boolean isWave(File f) throws IOException{
        boolean isWave = false;

        byte[] b = new byte[13];
        InputStream in = new FileInputStream(f);
        in.read(b, 0, 13);
        
        String result = "";
        String wave = "WAVE";
        for(int it = 8; it<12;it++){
            int i = (int)b[it];
            char c = (char)i;
            result = result+c;
        }
        if(result.equals(wave)){
            isWave = true;
        }
        return isWave;
    }
    /**
   *Checks wheter the file is AVI file.
     * @param f  the file which type is needed to be known
     * @return boolean isAvi - if file is AVI file it is true, otherwise false. 
     * @throws java.io.IOException 
   */
    public static boolean isAvi(File f) throws IOException{
        boolean isAvi = false;
        
        byte[] b = new byte[13];
        InputStream in = new FileInputStream(f);
        in.read(b, 0, 13);
        
        String result = "";
        String wave = "AVI";
        for(int it = 8; it<12;it++){
            int i = (int)b[it];
            char c = (char)i;
            result = result+c;
        }
        if(result.equals(wave)){
            isAvi = true;
        }
        return isAvi;
    }
    /**
   *Checks wheter the file is PNG file.
     * @param f  the file which type is needed to be known
     * @return boolean isPng - if file is PNG file it is true, otherwise false. 
     * @throws java.io.IOException 
   */
    public static boolean isPng(File f) throws IOException{
        boolean isPng = false;

        byte[] b = new byte[4];
        InputStream in = new FileInputStream(f);
        in.read(b, 0, 4);
        String result = "";
        String wave = "PNG";
        for(int it = 1; it<4;it++){
            int i = (int)b[it];
            char c = (char)i;
            result = result+c;
        }
        System.out.print(result);
                
        if(result.equals(wave)){
            isPng = true;
        }
        return isPng;
    }
    
    /**
   *Checks wheter the file is JPG file.
     * @param f  the file which type is needed to be known
     * @return boolean isJpg - if file is JFIF file it is true, otherwise false. 
     * @throws java.io.IOException 
   */
    public static boolean isJpg(File f) throws IOException{
        boolean isJpg = false;

        byte[] b = new byte[10];
        InputStream in = new FileInputStream(f);
        in.read(b, 0, 10);
        String result = "";
        String wave = "JFIF";
        for(int it = 6; it<10;it++){
            int i = (int)b[it];
            char c = (char)i;
            result = result+c;
        }
        System.out.print(result);
                
        if(result.equals(wave)){
            isJpg = true;
        }
        return isJpg;
    }
    /**
   *Checks wheter the file is GIF file.
     * @param f  the file which type is needed to be known
     * @return boolean isGif - if file is GIF file it is true, otherwise false. 
     * @throws java.io.IOException 
   */
    public static boolean isGif(File f) throws IOException{
        boolean isGif = false;

        byte[] b = new byte[6];
        InputStream in = new FileInputStream(f);
        in.read(b, 0, 6);
        String result = "";
        String wave = "GIF89a";
        for(int it = 0; it<6;it++){
            int i = (int)b[it];
            char c = (char)i;
            result = result+c;
        }
        System.out.print(result);
                
        if(result.equals(wave)){
            isGif = true;
        }
        return isGif;
    }
    /**
   *Checks wheter the file is 7z file.
     * @param f  the file which type is needed to be known
     * @return boolean is7z - if file is 7z file it is true, otherwise false. 
     * @throws java.io.IOException 
   */
public static boolean is7z(File f) throws IOException{
        boolean is7z = false;

        byte[] b = new byte[2];
        InputStream in = new FileInputStream(f);
        in.read(b, 0, 2);
        String result = "";
        String wave = "7z";
        for(int it = 0; it<2;it++){
            int i = (int)b[it];
            char c = (char)i;
            result = result+c;
        }
        System.out.print(result);
                
        if(result.equals(wave)){
            is7z = true;
        }
        return is7z;
    }
/**
   *Checks wheter the file is ZIP/JAR file.
     * @param f  the file which type is needed to be known
     * @return boolean isZip - if file is ZIP or JAR file it is true, otherwise false. 
     * @throws java.io.IOException 
   */
public static boolean isZip(File f) throws IOException{
        boolean isZip= false;

        byte[] b = new byte[2];
        InputStream in = new FileInputStream(f);
        in.read(b, 0, 2);
        String result = "";
        String wave = "PK";
        for(int it = 0; it<2;it++){
            int i = (int)b[it];
            char c = (char)i;
            result = result+c;
        }
        
                
        if(result.equals(wave)){
//            System.out.print(result);
            isZip = true;
        }
        return isZip;
    }
/**
   *Checks wheter the file is MP3 file.
     * @param f  the file which type is needed to be known
     * @return boolean isMp3 - if file is MP3 file it is true, otherwise false. 
     * @throws java.io.IOException 
   */
public static boolean isMp3(File f) throws IOException{
        boolean isMp3 = false;

        byte[] b = new byte[3];
        InputStream in = new FileInputStream(f);
        in.read(b, 0, 3);
        String result = "";
        String wave = "ID3";
        for(int it = 0; it<3;it++){
            int i = (int)b[it];
            char c = (char)i;
            result = result+c;
        }
        System.out.print(result);
                
        if(result.equals(wave)){
            isMp3 = true;
        }
        return isMp3;
    }
}
