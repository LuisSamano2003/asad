/*
 *  Be aware that this file might be changed during grading!
 */

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class Assignment2_TestData {
    public final String[] inputs;
    public final String[] buildings_to_count;
    public final ArrayList<MailPackage>[] preloaded_data;
    public final String[][] expected_small_inorders;
    public final int[] expected_tree_sizes;
    public final int[][] expected_counts_per_build;
    public final int[] expected_del_tree_sizes;


    public Assignment2_TestData(){
        this.inputs = new String[]{
            "test1.csv", "test2.csv", "test3.csv", "test4.csv", "test5.csv"
        };
        this.buildings_to_count = new String[]{"204", "305", "402", "503", "703"};
        this.preloaded_data = new ArrayList[]{
            LoadTestDataFromFile(this.inputs[0]),
            LoadTestDataFromFile(this.inputs[1]),
            LoadTestDataFromFile(this.inputs[2]),
            LoadTestDataFromFile(this.inputs[3]),
            LoadTestDataFromFile(this.inputs[4])
        };
        this.expected_small_inorders = new String[][]{
            new String[]{"102-302", "503-104", "503-411", "601-201", "805-215"},
            new String[]{"201-109", "203-109", "301-103", "303-201", "505-205", "601-411", "602-211", "703-303", "801-206", "802-402"},
            new String[]{"103-406", "302-306", "401-303", "404-109", "501-202", "503-211", "602-304", "702-203", "703-414", "805-309"},
            new String[]{"105-101", "105-109", "201-108", "204-111", "403-304", "602-211", "704-404", "801-413", "804-412", "805-304"},
            new String[]{"102-412", "103-302", "202-105", "204-214", "301-210", "303-202", "401-111", "703-409", "705-108", "705-208"}
        };
        this.expected_tree_sizes = new int[]{5, 50, 457, 2189, 2560};
        this.expected_counts_per_build = new int[][]{
            new int[]{0, 0, 0, 2, 0},
            new int[]{1, 1, 0, 0, 3},
            new int[]{15, 12, 13, 9, 12},
            new int[]{128, 125, 127, 110, 120},
            new int[]{1256, 1264, 1258, 1329, 1295}
        };

        this.expected_del_tree_sizes = new int[]{4, 40, 357, 1366, 48};
    }

    private ArrayList<MailPackage> LoadTestDataFromFile(String filename){
        ArrayList<MailPackage> data = new ArrayList<>();

        DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("MM/dd/uuuu");
        DateTimeFormatter time_formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        File in_file = new File(filename);
        try {
            Scanner reader = new Scanner(in_file);

            while (reader.hasNextLine()) {
                String str_mailpackage = reader.nextLine();
                MailPackage tempo = getTempo(str_mailpackage, date_formatter, time_formatter);
                data.add(tempo);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Invalid file name");
        }

        System.out.println("A total of " + data.size() + " records were successfully loaded from " + filename);

        return data;
    }

    private static MailPackage getTempo(String str_mailpackage, DateTimeFormatter date_formatter, DateTimeFormatter time_formatter) {
        String[] parts = str_mailpackage.split(",");

        LocalDate date = LocalDate.parse(parts[0], date_formatter);
        LocalTime time = LocalTime.parse(parts[1], time_formatter);
        String building = parts[2];
        String apartment = parts[3];
        double width = Double.parseDouble(parts[4]);
        double height = Double.parseDouble(parts[5]);
        double depth = Double.parseDouble(parts[6]);
        double weight = Double.parseDouble(parts[7]);

        MailPackage tempo = new MailPackage(date, time, building, apartment, width, height, depth, weight);
        return tempo;
    }

    public int n_cases(){
        return this.inputs.length;
    }
}
