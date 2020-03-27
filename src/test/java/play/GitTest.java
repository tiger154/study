package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;
import java.util.zip.*;


public class GitTest {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);

    //https://thiscouldbebetter.wordpress.com/2011/08/26/compressing-and-uncompressing-data-in-java-using-zlib/
    @Test
    public void readBlob() throws FileNotFoundException, IOException {
        // 1. get blob file
        File file = new File(
          getClass().getClassLoader().getResource("95c5faf68fd0d906f3d7af04a728e5141f30ee").getFile()
        );
        // File exist?
        if (file.exists()) {
            log.debug("It's exist man!");
        }

        byte[] bytesArray = new byte[(int) file.length()];
        FileInputStream is = new FileInputStream(file);
        is.read(bytesArray);

        // 2. decompress file with zlib(Inflater)
        String result = decompressToString(bytesArray);

        // 3. Check the data

        log.debug("result xml: {}", result);



    }


    // Decompress function demo
    public byte[] decompress(byte[] bytesToDecompress)
    {
        byte[] returnValues = null;

        // 1. init decompressor instance
        Inflater inflater = new Inflater(); // Actual decompressor
        int numberOfBytesToDecompress = bytesToDecompress.length;

        // 2. set input
        inflater.setInput
                (
                        bytesToDecompress,
                        0,
                        numberOfBytesToDecompress
                );

        int bufferSizeInBytes = numberOfBytesToDecompress;

        int numberOfBytesDecompressedSoFar = 0;
        List<Byte> bytesDecompressedSoFar = new ArrayList<Byte>();

        try
        {
            while (inflater.needsInput() == false)
            {
                byte[] bytesDecompressedBuffer = new byte[bufferSizeInBytes];

                int numberOfBytesDecompressedThisTime = inflater.inflate
                        (
                                bytesDecompressedBuffer
                        );

                numberOfBytesDecompressedSoFar += numberOfBytesDecompressedThisTime;

                for (int b = 0; b < numberOfBytesDecompressedThisTime; b++)
                {
                    bytesDecompressedSoFar.add(bytesDecompressedBuffer[b]);
                }
            }

            // After finished decompression, put all to a byte array
            returnValues = new byte[bytesDecompressedSoFar.size()];
            for (int b = 0; b < returnValues.length; b++)
            {
                returnValues[b] = (byte)(bytesDecompressedSoFar.get(b));
            }

        }
        catch (DataFormatException dfe)
        {
            dfe.printStackTrace();
        }

        inflater.end();

        return returnValues;
    }

    public String decompressToString(byte[] bytesToDecompress)
    {
        byte[] bytesDecompressed = this.decompress
                (
                        bytesToDecompress
                );

        String returnValue = null;

        try
        {
            returnValue = new String
                    (
                            bytesDecompressed,
                            0,
                            bytesDecompressed.length,
                            "UTF-8"
                    );
        }
        catch (UnsupportedEncodingException uee)
        {
            uee.printStackTrace();
        }

        return returnValue;
    }


}
