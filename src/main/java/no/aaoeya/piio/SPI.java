package no.aaoeya.piio;

import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiDevice;
import com.pi4j.io.spi.SpiFactory;

import java.io.IOException;

public class SPI {

    private static SpiDevice spi;

    public SPI() throws IOException {
        spi = SpiFactory.getInstance(SpiChannel.CS0, SpiDevice.DEFAULT_SPI_SPEED, SpiDevice.DEFAULT_SPI_MODE);
    }

    public byte[] write(byte[] txData) throws IOException {
        return spi.write(txData);
    }

}

/*
public class SPI {
    public byte[] write(byte[] txData) {
        byte[] dummy = {txData[0], txData[1]};
        return dummy;
    }
}
*/
