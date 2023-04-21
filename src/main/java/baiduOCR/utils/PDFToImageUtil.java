package baiduOCR.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * PDF转图片-工具类
 *
 * @author Run Jiao
 * @date 2023-04-04 13:48
 **/
public class PDFToImageUtil {

    public static void pdfToImage(String pdfPath, String imagePath, String imageFormat) throws Exception {
        PDDocument pdf = PDDocument.load(new File(pdfPath));
        PDFRenderer renderer = new PDFRenderer(pdf);
        BufferedImage image;
        for (int i = 0; i < pdf.getNumberOfPages(); i++) {
            image = renderer.renderImageWithDPI(i, 300);
            ImageIO.write(image, imageFormat, new File(imagePath + "/" + i + "." + imageFormat));
        }
    }

    public static void main(String[] args) throws Exception {
        String pdfPath = "C:\\Users\\79905\\Desktop\\银联国际-Java-赵恒柏 .pdf";
        String imagePath = "C:\\Users\\79905\\Desktop";
        String imageFormat = "png";
        pdfToImage(pdfPath, imagePath, imageFormat);
    }
}
