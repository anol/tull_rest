package no.aaoeya;

import no.aaoeya.piio.SPI;

import java.io.IOException;
import java.nio.ByteBuffer;

public class Max6675 {

    private SPI spi;

    public Max6675() throws IOException {
        spi = new SPI();
    }

    public String getTemperature() throws IOException {
        double temperature = getConversionValue();
        System.out.println(temperature);
        return String.valueOf(temperature);
    }

    public double getConversionValue() throws IOException {
        int data = getData();
        data = data >> 3;
        return data / 4.0;
    }

    private int getData() throws IOException {
        byte txData[] = new byte[]{0, 0, 0, 0};
        byte[] result = spi.write(txData);
        return ByteBuffer.wrap(result).getShort();
    }
}