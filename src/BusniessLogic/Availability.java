package BusniessLogic;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Availability {
	private String day;
	private LocalTime startTime;
	private LocalTime endTime;
	private long duration;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("h:mma");
    
    public Availability parseAvailabilityString(String availabilityString) {
        String[] parts = availabilityString.split(" ");
        String day = parts[0];
        String timeRange = parts[1] + " " + parts[2];

        String[] times = timeRange.split("-");
        LocalTime startTime = LocalTime.parse(times[0].trim(), TIME_FORMATTER);
        LocalTime endTime = LocalTime.parse(times[1].trim(), TIME_FORMATTER);
        long durationHours = startTime.until(endTime, ChronoUnit.HOURS);

        return new Availability(day, startTime, endTime, durationHours);
    }

	public Availability(String day, LocalTime startTime, LocalTime endTime, long duration) {
		super();
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
	}

	public Availability() {
		// TODO Auto-generated constructor stub
		this.day = null;
		this.startTime = null;
		this.endTime = null;
		this.duration = 0;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
    

}
