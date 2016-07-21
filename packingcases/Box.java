package packingcases;


public class Box implements Comparable<Box> {

    public int width;
    public int length;
    public int height;

    // width should always be less than length.
    public Box(int height, int width, int length) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    @Override
    public int compareTo(Box o) {
        int box1Area = width * length;
        int box2Area = o.width * o.length;
        return Integer.compare(box1Area, box2Area);
    }
}
