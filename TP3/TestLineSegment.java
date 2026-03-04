public class TestLineSegment
{
    public static void main(String[] args)
    {
        LineSegment s = new LineSegment(0, 0, 3, 4);
        
        System.out.println(s.toString());   // [(0,0), (3,4)]
        System.out.println(s.length());     // 5.0
        
        s.translate(1, 1);
        System.out.println(s.toString());   // [(1,1), (4,5)]
    }
}
