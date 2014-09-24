package io.github.binaryfoo.decoders;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.List;

import io.github.binaryfoo.EmvTags;
import io.github.binaryfoo.tlv.Tag;
import org.junit.Test;

import io.github.binaryfoo.DecodedData;


public class TLVDecoderTest {

	@Test
	public void testDecode() {
		TLVDecoder decoder = new TLVDecoder();
        String input = "E05A9F020600000000500082025C009F360200019F260886087FD3A9FE6FB49F100706010A03A010009F3303E0F0C09F1A0200365F2A0200369F1E08424B00081905CB9F950500000080009A030809229C01009F37041035EA1F8A00";
        DecodeSession session = new DecodeSession();
        session.setTagMetaData(EmvTags.METADATA);
        List<DecodedData> actual = decoder.decode(input, 0, session);
		assertThat(actual.get(0).getTag(), is(Tag.fromHex("E0")));
	}
}