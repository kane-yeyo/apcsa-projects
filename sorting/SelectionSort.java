package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Selection Sort!!!");
        for (int i = 0; i < input.length - 1; i++) { //stops before last element since it'll be set to greatest
            int minIndex = i; //assumes first is smallest
            for (int j = i + 1; j < input.length; j++) { //goes through elements to the right of the smallest
                if (input[j] < input[minIndex]) { //if the new element is smaller, minIndex is set to it
                    minIndex = j;
                }
            }
            
        }
    }
}
