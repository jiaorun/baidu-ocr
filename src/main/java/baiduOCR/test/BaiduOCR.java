package baiduOCR.test;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;

/**
 * 百度OCR-PDF识别
 *
 * @author Run Jiao
 * @date 2023-04-04 13:54
 **/
public class BaiduOCR {

    public static void recognition(String appId, String apiKey, String secretKey, String imagePath) {
        // 初始化一个 AipOcr
        AipOcr client = new AipOcr(appId, apiKey, secretKey);

        // 设置参数
        HashMap<String, String> options = new HashMap<>();
        options.put("language_type", "CHN_ENG");

        // 读取图片，并进行 OCR 识别
        File imageFile = new File(imagePath);
        JSONObject res = client.basicGeneral(imageFile.getAbsolutePath(), options);
        JSONArray jsonArray = res.getJSONArray("words_result");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = (JSONObject) jsonArray.get(i);
            String text = object.getString("words");
            System.out.println(text);
        }
    }
}
