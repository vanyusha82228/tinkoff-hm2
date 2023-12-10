package edu.pr4;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public final class ImageUtils {
    private static final int RGB_MAX = 255;
    private static final int RED_SHIFT = 16;
    private static final int GREEN_SHIFT = 8;

    private ImageUtils() {}

    public static void save(FractalImage image, Path filename, ImageFormat format) throws IOException {
        BufferedImage bufferedImage = convertFractalImageToBufferedImage(image);
        ImageIO.write(bufferedImage, format.name().toLowerCase(), filename.toFile());
    }

    private static BufferedImage convertFractalImageToBufferedImage(FractalImage image) {
        int width = image.width();
        int height = image.height();

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Pixel pixel = image.pixel(x, y);
                int rgb = createRGB(pixel.r(), pixel.g(), pixel.b());
                bufferedImage.setRGB(x, y, rgb);
            }
        }

        return bufferedImage;
    }

    private static int createRGB(double r, double g, double b) {
        int red = (int) (r * RGB_MAX);
        int green = (int) (g * RGB_MAX);
        int blue = (int) (b * RGB_MAX);
        return (red << RED_SHIFT) | (green << GREEN_SHIFT) | blue;
    }
}
