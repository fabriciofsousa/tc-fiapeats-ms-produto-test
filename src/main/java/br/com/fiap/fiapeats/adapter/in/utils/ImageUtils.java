package br.com.fiap.fiapeats.adapter.in.utils;

import java.io.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

public class ImageUtils {

  public static String convertImageToBase64(MultipartFile file) throws IOException {
    if (file == null) {
      return null;
    } else {
      Base64 base64 = new Base64();
      return new String(base64.encode(file.getBytes()));
    }
  }
}
