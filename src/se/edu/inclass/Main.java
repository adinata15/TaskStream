package se.edu.inclass;

import static java.util.stream.Collectors.toList;
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

        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));

        for (Task t : filtreByString(tasksData, "10")) {
            System.out.println(t);
        }
    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    public static void printData(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        tasksData.stream()
                .filter(t -> t instanceof Deadline)
                .sorted((a, b) -> a.getDescription().toLowerCase().compareTo(b.getDescription().toLowerCase()))
                .forEach(System.out::println);
//        for (Task t : tasksData) {
//            if (t instanceof Deadline) {
//                System.out.println(t);
//            }
//        }
    }

    public static ArrayList<Task> filtreByString(ArrayList<Task> tasksData, String filterString) {
        return (ArrayList<Task>) tasksData.stream()
                .filter(task -> task.getDescription().contains(filterString))
                .collect(toList());
    }
}
