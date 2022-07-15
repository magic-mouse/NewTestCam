package com.kvedro.app.newTest;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamCompositeDriver;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import java.awt.image.BufferedImage;
import java.util.concurrent.TimeoutException;
import boofcv.io.webcamcapture.UtilWebcamCapture;

public class Start {

   // static {
       // Webcam.setDriver(new WebcamCompositeDriver()); // this is important
   // }

    public static void main(String[] args) {

        System.out.println("Hello World");
        Webcam webcam = null;
        Result result = null;
        BufferedImage image = null;
        boolean running = true;

        Webcam.getWebcams().forEach(System.out::println);


        while(webcam == null) {
            System.out.println("Connecting webcam");
            try {
               webcam =  UtilWebcamCapture.openDefault(640, 480);
               // webcam = Webcam.getDefault(1000L);

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Failed to connect....");
        }

        while (running) {
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

          //  LuminanceSource source = new BufferedImageLuminanceSource(image);
          //  BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
          //  try {
                //result = new MultiFormatReader().decode(image); //bitmap);
               // System.out.println(result.getText());
          //  } catch (NotFoundException e) {
                // fall through, it means there is no QR code in image
          //  }
        }

    }
}
