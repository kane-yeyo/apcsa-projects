package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Insertion Sort!!!");
        for (int i = 1; i < input.length; i++) { //starts sort from 2nd element, 1st is considered "sorted"
            int temp = input[i]; //stores current element
            
            int j = i - 1; //takes left element of current one
            while (j >= 0 && input[j] > temp) { //keeps going if left elements > temp
                input[j+1] = input[j]; //moves to the right
                j--; //increments downward
            }
            input[j+1] = temp; //current element becomes temp, j+1 since it's to the right
        }
    }
}
