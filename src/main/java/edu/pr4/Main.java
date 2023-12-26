package edu.pr4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {

    private final static int N = 100000;          // количество итераций
    private final static int EQ_COUNT = 5;       // количество аффинных преобразований
    private final static int IT = 500;           // количество шагов внутреннего цикла
    private final static int XRES = 800;         // ширина изображения
    private final static int YRES = 600;         // высота изображения
    private final static int SYMMETRIES = 4; // количество симметрий
    private final static double GAMMA = 2.2; // параметр гамма-коррекции

    private Main() {
    }

    public static void main(String[] args) {


        long startTime = System.currentTimeMillis();

        FractalImage fractalImage = new ParallelFractalGenerator(N, EQ_COUNT, IT, XRES, YRES, SYMMETRIES,
            GAMMA).renderParallel();

//        FractalImage fractalImage = FractalRenderer.render(N, EQ_COUNT, IT, XRES, YRES, SYMMETRIES,
//            GAMMA);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        log.info("Время выполнения: " + executionTime + " миллисекунд");


        try {
            Path filePath = Paths.get("F:\\Tinkoff2\\src\\main\\java\\edu\\pr4\\img\\image15.png");
            ImageUtils.save(fractalImage, filePath, ImageFormat.PNG);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    }

