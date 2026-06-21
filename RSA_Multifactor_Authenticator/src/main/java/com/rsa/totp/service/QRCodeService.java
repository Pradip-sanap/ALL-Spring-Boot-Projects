package com.rsa.totp.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class QRCodeService {

    public byte[] generateQRCode(String text) throws Exception {

        BitMatrix matrix = new MultiFormatWriter().encode(
                                text,
                                BarcodeFormat.QR_CODE,
                                300,
                                300
                            );

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        MatrixToImageWriter.writeToStream(
                matrix,
                "PNG",
                output
        );

        return output.toByteArray();
    }
}
