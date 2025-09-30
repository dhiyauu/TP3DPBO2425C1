public class Schedule {
    private final String id;
    private int dayOfWeek;
    private String startTime;
    private String endTime;

    // ===== Constructor =====
    public Schedule(String id, int dayOfWeek, String startTime, String endTime) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // ===== Getter =====
    public String getId() {
        return id;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    // ===== Setter =====
    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    // ===== toString =====
    @Override
    public String toString() {
        String[] dayMap = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        String d = (dayOfWeek >= 0 && dayOfWeek <= 6) ? dayMap[dayOfWeek] : String.valueOf(dayOfWeek);
        return "Schedule[ID=" + id + ", " + d + " " + startTime + "-" + endTime + "]";
    }
}