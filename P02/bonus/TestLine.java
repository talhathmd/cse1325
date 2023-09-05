public class TestLine
{
    public static void main (String[] args)
    {
        Line ln1 = new Line(9.264, 8.626, 9.070, 3.194, Color.CRIMSON);
        Line ln2 = new Line(5.670, 0.307, 4.001, 8.058, Color.VIOLET);
        Line ln3 = new Line(9.360,6.226, 4.605, 4.110, Color.BEIGE);
        Line ln4 = new Line(0.752, 9.955, 5.561, 9.962, Color.SILVER);

        System.out.println(ln1 + " has length: " + ln1.length());
        System.out.println(ln2 + " has length: " + ln2.length());
        System.out.println(ln3 + " has length: " + ln3.length());
        System.out.println(ln4 + " has length: " + ln4.length());
    }
}