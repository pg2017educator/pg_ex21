package invoice;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Test;

public class InvoiceWriterTest {

    @Test
    public void testWrite() throws IOException {
        StringWriter output = new StringWriter();
        InvoiceWriter writer = new InvoiceWriter(output);

        Invoice invoice = new Invoice();
        invoice.setOwnerTelNumber("090-1234-0001");
        invoice.setBasicCharge(1100);
        invoice.addCallCharge(230);

        writer.write(invoice);

        invoice.clear();
        invoice.setOwnerTelNumber("090-1234-0002");
        invoice.setBasicCharge(1300);
        invoice.addCallCharge(199);

        writer.write(invoice);

        String expected = "1 090-1234-0001\n"
                + "5 1100\n"
                + "7 230\n"
                + "9 ====================\n"
                + "1 090-1234-0002\n"
                + "5 1300\n"
                + "7 199\n"
                + "9 ====================\n";

        writer.close();

        String actual = output.toString();
        assertEquals(expected, actual);
    }

}
