package restart.source;

public class Binarysearch {
    private int x;
    private int[] a;

    public Binarysearch(int x, int[] a) {
        this.x = x;
        this.a = a;
    }

    int search(int low, int high) {
        if (low > high) {
            return -1;
        } else {
            int mid = (low + high) / 2;
            if (x == a[mid]) {
                return mid;
            } else if (x < a[mid]) {
                return search(low, mid - 1);
            } else {
                return search(mid + 1, high);
            }
        }
    }

}
