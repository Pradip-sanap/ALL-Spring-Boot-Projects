package com.qr;

import java.io.IOException;
import java.nio.file.Paths;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRGenerator {

	public static void main(String[] args) throws WriterException, IOException {
		String data="www.youtube.com/arjuncodes";
        String path="C:\\Users\\pradips\\Music\\ALL-Spring-Boot-Projects\\08-QR-Generator-Decoder\\src\\main\\java\\com\\qr\\qrcode.jpg";
        
        BitMatrix matrix=new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE,100,100);

        MatrixToImageWriter.writeToPath(matrix,"jpg", Paths.get(path));

        System.out.println("QR code successfully created");

	}

}
