import java.util.ArrayList;
import java.util.Arrays;


/*
 * WARNING: This is given to you, DO NOT CHANGE or you might get a 0!!!!
 */

public class Assignment2_Test {

    public static void score_tests(){
        Assignment2_TestData test_data = new Assignment2_TestData();

        int t_correct_step_1 = 0;
        int t_correct_step_2 = 0;
        int t_correct_step_3 = 0;
        int t_correct_step_4 = 0;
        int n_cases = test_data.n_cases();
        for (int test_case=0; test_case < n_cases; test_case++){
            System.out.println("\nRunning Test Case #" + (test_case + 1));

            // THE MAIN ALGORITHM IS HERE (Except for Step 4)
            int small_max = Math.min(10, test_data.preloaded_data[test_case].size());
            ArrayList<MailPackage> small_test = new ArrayList<MailPackage>(test_data.preloaded_data[test_case].subList(0, small_max));
            // Step 1: try with small version of list
            BST<String, ResidentPackages> step_1_out = Assignment2_Main.create_index(small_test);

            // Step 2: try with full version of list
            BST<String, ResidentPackages> step_2_out = Assignment2_Main.create_index(test_data.preloaded_data[test_case]);

            // Step 3: get the counts for selected test buildings ...
            int[] step_3_out = new int[test_data.buildings_to_count.length];
            for (int build_idx = 0; build_idx < test_data.buildings_to_count.length; build_idx++) {
                step_3_out[build_idx] = Assignment2_Main.total_packages_per_building(step_2_out, test_data.buildings_to_count[build_idx]);
            }

            // This is just prints and grading ...
            System.out.println("- Input: " + test_data.inputs[test_case]);
            System.out.println("- Step 1: Generating the BST index (first 10 only)");
            System.out.println("  - Produced Output (In-order Keys): " + step_1_out.keys());
            System.out.println("  - Expected Output (In-order Keys): " + Arrays.toString(test_data.expected_small_inorders[test_case]));
            Object[] part1_keys_obj  = step_1_out.keys().toArray();
            String[] part1_keys = Arrays.copyOf(part1_keys_obj, part1_keys_obj.length, String[].class);
            if (is_sorted(part1_keys) && Arrays.equals(part1_keys, test_data.expected_small_inorders[test_case])){
                System.out.println("  --> Correct!");
                t_correct_step_1 += 1;
            } else {
                System.out.println("  --> Incorrect!");
            }

            System.out.println("- Step 2: Generating the full BST index");
            Object[] part2_keys_obj  = step_2_out.keys().toArray();
            String[] part2_keys = Arrays.copyOf(part2_keys_obj, part2_keys_obj.length, String[].class);
            boolean part2_sorted = is_sorted(part2_keys);
            System.out.println("  - Produced Output (Tree Size): " + step_2_out.getSize());
            System.out.println("  - Produced Output (Sorted): " + part2_sorted);
            System.out.println("  - Expected Output (Tree Size): " + test_data.expected_tree_sizes[test_case]);
            System.out.println("  - Expected Output (Sorted): " + true);
            if (part2_sorted && step_2_out.getSize() == test_data.expected_tree_sizes[test_case]){
                System.out.println("  --> Correct!");
                t_correct_step_2 += 1;
            } else {
                System.out.println("  --> Incorrect!");
            }

            System.out.println("- Step 3: Counting Packages of Selected Buildings");
            System.out.println("  - Produced Output (Total Count): " + Arrays.toString(step_3_out));
            System.out.println("  - Expected Output (Total Count): " + Arrays.toString(test_data.expected_counts_per_build[test_case]));
            if (Arrays.equals(step_3_out, test_data.expected_counts_per_build[test_case])){
                System.out.println("  --> Correct!");
                t_correct_step_3 += 1;
            } else {
                System.out.println("  --> Incorrect!");
            }

            // Since this one affects the tree, this step is done until now ...
            // Step 4: pick some keys to delete ...
            ArrayList<String> delete_keys = new ArrayList<>();
            // pick the keys of one out of every 5 packages to be deleted ...
            // this means some keys are likely repeated
            for (int i = 0; i < test_data.preloaded_data[test_case].size(); i += 5){
                delete_keys.add(test_data.preloaded_data[test_case].get(i).getResidentKey());
            }
            Assignment2_Main.people_pick_packages(step_2_out, delete_keys);

            Object[] part4_keys_obj  = step_2_out.keys().toArray();
            String[] part4_keys = Arrays.copyOf(part4_keys_obj, part4_keys_obj.length, String[].class);
            boolean part4_sorted = is_sorted(part4_keys);

            System.out.println("- Step 4: Random people picked their packages");
            System.out.println("  - Produced Output (Tree Size): " + step_2_out.getSize());
            System.out.println("  - Produced Output (Sorted): " + part4_sorted);
            System.out.println("  - Expected Output (Tree Size): " + test_data.expected_del_tree_sizes[test_case]);
            System.out.println("  - Expected Output (Sorted): " + true);
            if (part4_sorted && step_2_out.getSize() == test_data.expected_del_tree_sizes[test_case]){
                System.out.println("  --> Correct!");
                t_correct_step_4 += 1;
            } else {
                System.out.println("  --> Incorrect!");
            }
        }

        System.out.println("\n\nSummary");
        System.out.println("- Step 1 correct: " + t_correct_step_1 + " / " + n_cases);
        System.out.println("- Step 2 correct: " + t_correct_step_2 + " / " + n_cases);
        System.out.println("- Step 3 correct: " + t_correct_step_3 + " / " + n_cases);
        System.out.println("- Step 4 correct: " + t_correct_step_4 + " / " + n_cases);
    }

    public static boolean is_sorted(String[] keys){
        if (keys.length <= 1){
            return true;
        }

        for (int i = 0; i < keys.length - 1; i++){
            if (keys[i].compareTo(keys[i + 1]) >= 0){
                // this key is larger or equal to the next one (inverted pair found)
                return false;
            }
        }

        return true;
    }
}
