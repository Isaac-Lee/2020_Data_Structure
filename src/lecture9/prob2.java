package lecture9;

public class prob2 {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {5,6,7,1,2,3};
        int mindex = 0;

        int left = 0;
        int right = n;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                mindex = left;
                break;
            }

            int mid = (left + right)/2;
            int next = (mid+1)%n;
            int prev = (mid-1 + n)%n;

            if (arr[mid] == arr[next] && arr[mid] <= arr[prev]) {
                mindex = mid;
                break;
            } else if (arr[mid] <= arr[right]) {
                right = mid - 1;
            } else if (arr[mid] >= arr[left]) {
                left = mid + 1;
            }

            System.out.println(mindex);
        }
    }
}
