package berlinclock;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import org.joda.time.DateTime;

public class BerlinClock {

	private static Scanner scanner = new Scanner(System.in);

	private static DateTime getDate(int hour, int minute, int second) {
		DateTime dt = DateTime.now();
		dt = dt.withHourOfDay(hour);
		dt = dt.withMinuteOfHour(minute);
		dt = dt.withSecondOfMinute(second);
		return dt;
	}

	private static void println(String line) {
		System.out.println(line);
	}

	public static void main(String[] args) {
		while (true) {

			int hour = readInt("Enter hour (0-23): ", 0, 23);
			int minute = readInt("Enter minute(0-59): ", 0, 59);
			int second = readInt("Enter second(0-59): ", 0, 59);

			DateTime dt = getDate(hour, minute, second);

			println("The according Berlin Clock representation is:");
			println(BerlinClockConverter.getSecond(dt));
			println(BerlinClockConverter.getHour5(dt));
			println(BerlinClockConverter.getHour1(dt));
			println(BerlinClockConverter.getMinute5(dt));
			println(BerlinClockConverter.getMinute1(dt));

			if (readString("Again? [Y/n]: ").equalsIgnoreCase("n")){
				break;
			}
		}

		println("K Thx Bye");
	}
	
	private static String readString(String message){
		System.out.print(message);
		return scanner.nextLine();
	}

	private static int readInt(String message, int boundarylow, int boundaryhigh) {
		while (true) {
			try {
				System.out.print(message);
				int number = Integer.parseInt(scanner.nextLine());
				;
				if (number >= boundarylow && number <= boundaryhigh) {
					return number;
				} else {
					System.out.println(String.format(
							"Sorry, please enter a number between %s and %s.",
							boundarylow, boundaryhigh));
				}
			} catch (NumberFormatException e) {
				System.out.println("Sorry, that was not a number. Try again.");
			}
		}

	}

}
