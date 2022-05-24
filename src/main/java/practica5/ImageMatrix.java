package practica5;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageMatrix {

  public int[][][] getImageMatrix(String inputFileName) {
    File input = new File(inputFileName);
    BufferedImage image;
    int[][][] imageCube = null;

    try {
      image = ImageIO.read(input);
      int width = image.getWidth();
      int height = image.getHeight();

      imageCube = new int[3][height][width];

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          Color color = new Color(image.getRGB(j, i));
          imageCube[0][i][j] = color.getRed();
          imageCube[1][i][j] = color.getGreen();
          imageCube[2][i][j] = color.getBlue();
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    return imageCube;
  }

  public void setMatrixImage(int[][][] imageCube, String outputFileName) {

    File output = new File(outputFileName);
    BufferedImage image = new BufferedImage(imageCube[0].length, imageCube[0].length, 5);
    Color color;
    try {
      for (int i = 0; i < imageCube[0].length; i++) {
        for (int j = 0; j < imageCube[0].length; j++) {
           System.out.println("i: " + i + " j: " + j);
          // color = new Color(imageCube[0][i][j], imageCube[1][i][j],
          // imageCube[2][i][j]);
          // System.out.println(color.getRGB());
          image.setRGB(j, i, new Color(imageCube[0][i][j], imageCube[1][i][j], imageCube[2][i][j]).getRGB());

          
        }
      }
      ImageIO.write(image, "bmp", output);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
