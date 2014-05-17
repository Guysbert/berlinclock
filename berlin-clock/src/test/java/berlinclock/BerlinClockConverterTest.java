package berlinclock;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

public class BerlinClockConverterTest {

	private DateTime getDate(int hour, int minute, int second) {
		DateTime dt = DateTime.now();
		dt = dt.withHourOfDay(hour);
		dt = dt.withMinuteOfHour(minute);
		dt = dt.withSecondOfMinute(second);
		return dt;
	}

	@Test
	public void getStringRepresentationOfMidnight() {
		DateTime dt = getDate(0, 0, 0);

		assertEquals("Y", BerlinClockConverter.getSecond(dt));
		assertEquals("OOOO", BerlinClockConverter.getHour5(dt));
		assertEquals("OOOO", BerlinClockConverter.getHour1(dt));
		assertEquals("OOOOOOOOOOO", BerlinClockConverter.getMinute5(dt));
		assertEquals("OOOO", BerlinClockConverter.getMinute1(dt));
	}

	@Test
	public void getStringRepresentationOf131701() {
		DateTime dt = getDate(13, 17, 01);

		assertEquals("O", BerlinClockConverter.getSecond(dt));
		assertEquals("RROO", BerlinClockConverter.getHour5(dt));
		assertEquals("RRRO", BerlinClockConverter.getHour1(dt));
		assertEquals("YYROOOOOOOO", BerlinClockConverter.getMinute5(dt));
		assertEquals("YYOO", BerlinClockConverter.getMinute1(dt));
	}
	
	@Test
	public void getStringRepresentationOf235959() {
		DateTime dt = getDate(23, 59, 59);

		assertEquals("O", BerlinClockConverter.getSecond(dt));
		assertEquals("RRRR", BerlinClockConverter.getHour5(dt));
		assertEquals("RRRO", BerlinClockConverter.getHour1(dt));
		assertEquals("YYRYYRYYRYY", BerlinClockConverter.getMinute5(dt));
		assertEquals("YYYY", BerlinClockConverter.getMinute1(dt));
	}
	
	
	
		
	
	

}
