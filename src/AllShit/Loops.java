package AllShit;

public class Loops {
    public static void parallelLoop() {
        int i;
        int j;
        int[] ascendentArray = new int[10];
        int[] descendentArray = new int[10];
        for (i = 0, j = 10; ; i++, j--) {
            ascendentArray[i] = i + 1;
            descendentArray[j - 1] = j;
        }
//        System.out.println(Arrays.print(ascendentArray));
//        System.out.println(Arrays.print(descendentArray));
    }

    public static void everyOther(int arr[], int arr2[]) { // 2,2,3,4,6,8,3,3,5
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                continue;
            } else
            arr2[j] = arr[i];
            System.out.println(j);
            j++;
        }
    }
}
