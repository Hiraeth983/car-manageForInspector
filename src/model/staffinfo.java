package model;
public class staffinfo {
    private static String staffId;
    private static String staffname;
    private static double avgScore;
    private static int orderSum;
    private static String stationId;
    private static boolean isAble;

    public static String getStaffId() {
        return staffId;
    }

    public static void setStaffId(String staffId) {
        staffinfo.staffId = staffId;
    }

    public static String getStaffname() {
        return staffname;
    }

    public static void setStaffname(String staffname) {
        staffinfo.staffname = staffname;
    }

    public static double getAvgScore() {
        return avgScore;
    }

    public static void setAvgScore(double avgScore) {
        staffinfo.avgScore = avgScore;
    }

    public static int getOrderSum() {
        return orderSum;
    }

    public static void setOrderSum(int orderSum) {
        staffinfo.orderSum = orderSum;
    }

    public static String getStationId() {
        return stationId;
    }

    public static void setStationId(String stationId) {
        staffinfo.stationId = stationId;
    }

    public static boolean isIsAble() {
        return isAble;
    }

    public static void setIsAble(boolean isAble) {
        staffinfo.isAble = isAble;
    }
}