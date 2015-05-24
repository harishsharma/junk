package array;

import java.util.Arrays;

public class Conflict {


    public static void solve(Interval[] input) {
        int len = input.length;

        Arrays.sort(input);
        Interval previous = input[0];
        int start = 0, end = 0;
        for (int i = 1; i < len; i++) {
            Interval cur = input[i];
            if (cur.start.compareTo(previous.end) < 0) {
                end++;
            } else {
                for (int j = start; j < end; j++) {
                    System.out.println(j + "conflicts with " + (j + 1));
                }
                start = i;
                end = start;
            }
            previous = cur;
        }

        for (int j = start; j < end; j++) {
            System.out.println(j + "conflicts with " + (j + 1));
        }
    }


    public static class Interval implements Comparable<Interval> {

        Date start;
        Date end;

        public Interval(Date start, Date end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return end.compareTo(o.end);
        }
    }


    public static class Date implements Comparable<Date> {

        int year;
        int month;
        int day;

        public Date(String date) {
            String[] dateArray = date.split("-");
            year = Integer.parseInt(dateArray[0]);
            month = Integer.parseInt(dateArray[1]);
            day = Integer.parseInt(dateArray[2]);
        }


        @Override
        public int compareTo(Date in) {
            int inYear = in.year;
            int inMonth = in.month;
            int inDay = in.day;

            if (year > inYear)
                return 1;
            else if (year < inYear)
                return -1;
            else {
                if (month > inMonth)
                    return 1;
                else if (month < inMonth)
                    return -1;
                else {
                    if (day > inDay)
                        return 1;
                    else if (day < inDay) return -1;
                }
            }
            return 0;
        }
    }


    public static void main(String[] arg) {

        Interval i1 = new Interval(new Date("2001-01-01"), new Date("2001-12-01"));
        Interval i2 = new Interval(new Date("2001-11-01"), new Date("2002-01-01"));
        Interval i3 = new Interval(new Date("2002-02-01"), new Date("2002-09-01"));
        Interval i4 = new Interval(new Date("2002-08-01"), new Date("2002-10-01"));
        Interval i5 = new Interval(new Date("2002-07-01"), new Date("2002-10-01"));
        Interval[] input = { i1, i2, i3, i4, i5};
        solve(input);
    }
}
