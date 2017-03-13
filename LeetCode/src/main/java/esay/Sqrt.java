package esay;

/**
 * Created by yixinxin on 17/3/13.
 *
 * 69. Sqrt(x)
 Implement int sqrt(int x).

 Compute and return the square root of x

 sqrt(27) = 5, 5*5 < 27 < 6*6
 */
public class Sqrt {
    // use binary search
    /*
        left/ right are the min and max values of an interval.
        each loop divide the interval by half and pick the left half or right half and continue.
        this is really the same idea as binary search.
     */
    public int mySqrt(int x) {
        if(x == 0)
            return 0;

        int left = 1, right = x; // do not need Integer.Max_VALUE
        while(true) {
            // not use  (right + left)/2, to prevent potential integer overflow
            int mid = left + (right - left) / 2;

            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    // method 2
    // Newton's method
    public int mySqrt1(int x){
        long r = x;
        while(r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }

    public static void main(String[] args){
        Sqrt sqrt = new Sqrt();

        System.out.println(sqrt.mySqrt1(9));
    }

}
