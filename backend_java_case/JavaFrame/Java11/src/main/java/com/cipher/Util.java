package com.cipher;

import javax.crypto.Cipher;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author yangzl 2020.12.07
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class Util {

    public static void crypt(InputStream in, OutputStream out, Cipher cipher) throws  Exception {

        int blockSize = cipher.getBlockSize();
        int outputSize = cipher.getOutputSize(blockSize);
        byte[] inBytes = new byte[blockSize];
        byte[] outBytes = new byte[outputSize];

        int inLength = 0;
        boolean more = true;

        while(more) {

            inLength = in.read(inBytes);

            if(inLength == blockSize) {
                int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
                out.write(outBytes, 0, outLength);
            }else {
                more = false;
            }
        }

        if(inLength > 0) outBytes = cipher.doFinal(inBytes, 0, inLength);
        else outBytes = cipher.doFinal();
        out.write(outBytes);
    }
}
