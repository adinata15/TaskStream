package se.edu.inclass;

import se.edu.inclass.data.DataManager;
import se.edu.inclass.task.Deadline;
import se.edu.inclass.task.Task;
import se.edu.inclass.task.TaskNameComparator;

import java.util.ArrayList;

public class Main {

    private TaskNameComparator taskNameComparator;

    public static void main(String[] args) {
        DataManager dm = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dm.loadData();

        System.out.println("Printing deadlines");
        printDeadlines(tasksData);
        printData(tasksData);
        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));

    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        return (int) tasksData.stream()
                .filter(task -> task instanceof Deadline)
                .count();
//        int count = 0;
//        for (Task t : tasksData) {
//            if (t instanceof Deadline) {
//                count++;
//            }
//        }
//        return count;
    }

    public static void printData(ArrayList<Task> tasksData) {
        tasksData.stream()
                .forEach(System.out::println);
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        tasksData.stream()
                .filter(t -> t instanceof Deadline)
                .forEach(System.out::println);
//        for (Task t : tasksData) {
//            if (t instanceof Deadline) {
//                System.out.println(t);
//            }
//        }
    }
}
