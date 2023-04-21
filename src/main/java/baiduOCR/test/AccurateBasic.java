package baiduOCR.test;

import baiduOCR.utils.Base64Util;
import baiduOCR.utils.FileUtil;
import baiduOCR.utils.HttpUtil;

import java.net.URLEncoder;

/**
 * 百度OCR-通用文字识别(高精度版)
 *
 * @author Run Jiao
 * @date 2023-03-30 11:13
 **/
public class AccurateBasic {

    /**
     * 通用文字识别(高精度版)
     *
     * @param
     * @return String
     * @author Run Jiao
     * @date 2023/3/30 11:14
     */
    public static String accurateBasic() {

        /**
         * 通用请求URL
         */
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic";

        try {
            // 本地文件路径
            String failPath = "C:\\Users\\79905\\Desktop\\0.png";
            byte[] imgData = FileUtil.readFileByBytes(failPath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.569a65653dce70e56e9e4e3a384cb142.2592000.1682738879.282335-31809314";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        AccurateBasic.accurateBasic();
    }
}
