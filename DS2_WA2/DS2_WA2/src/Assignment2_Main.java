import java.util.ArrayList;


public class Assignment2_Main {
    /*
     * STEP 1:
     *   Initial function that takes an ArrayList of MailPackage objects, and returns a Binary Search Tree which
     *   has indexed all of these packages. The keys of the index will be the Strings representing unique
     *   Resident Keys (e.g., "[building]-[apartment]"), and the Values stored per Node will be objects of the
     *   Resident Package class.
     *
     *   All packages that belong to a single resident key must be grouped and put together in the same ResidentPackages
     *   object within the BST index. However, you must process and index these packages sequentially in their current
     *   order on the packages list. This means that you are NOT allowed to group them before getting them into the
     *   index. Instead, when a package needs to be added to the index, the function must determine if the corresponding
     *   ResidentPackages already exists on the index or not, and proceed accordingly.
     *
     * Output
     *    The BST object that represents the entire index
     *
     * Hints
     *    This function requires you to implement both the "put" and "get" methods of BST.
     * */
    public static BST<String, ResidentPackages> create_index(ArrayList<MailPackage> packages){
        BST<String, ResidentPackages> tree = new BST<>();
        System.out.println("AHHHHHHHHHHHHHHHHH");
        for (MailPackage mail_package : packages){
            String resident_key = mail_package.getResidentKey();
            // check if the package already exists ...

            ResidentPackages virtual_mailbox = tree.get(resident_key);
            System.out.println(virtual_mailbox == null);
            if (virtual_mailbox == null){
                // Does not exist ... create new mailbox for resident
                // and push it into the tree

                virtual_mailbox = new ResidentPackages(resident_key);
                tree.put(resident_key, virtual_mailbox);
            }

            // add the package on the resident mailbox  ...
            virtual_mailbox.AddPackage(mail_package);
        }
        return tree;
    }

    /*
    * Step 3:
    *    Create a querying function that takes a building number and the BST index as inputs and computes the total
    *    number of packages on all mailboxes for that building.
    *
    *   Output
    *     An integer representing the sum of the number of packages on each mailbox of the building
    *
    *   Hints:
    *      - In this application, all buildings follow the same design, with 4 floors per building and 16 apartments per
    *        floor. Each apartment has a number that corresponds to the combination of floor and relative apartment
    *        number on that floor. This information can be used to automatically generate a range of keys for all
    *        residents of the same building.
    *      - You will need to implement a function in the BST class, valuesInKeyRange,  which will take as input the
    *        range of keys (minimum and maximum key values, both inclusive), and will return all values (the
    *        ResidentPackages objects) associated with every key within this range (minimum <= resident key <= maximum).
    *        This requires the same kind of logic used by the RANK function.
    * */
    public static int total_packages_per_building(BST<String, ResidentPackages> index, String building){
        String min_b_key = building + "-101";
        String max_b_key = building + "-416";

        ArrayList<ResidentPackages> resident_packages = index.valuesInKeyRange(min_b_key, max_b_key);

        int total_count = 0;
        for (int i = 0; i < resident_packages.size(); i++){
            total_count += resident_packages.get(i).getPackageCount();
        }

        return total_count;
    }

    /*
    *  Step 4:
    *     This function takes the index and a list of resident keys, and removes each resident key from the index.
    *     This requires implementing and using the delete function of the binary search tree (Hibbard deletion).
    *
    * Output:
    *      None really. The same input index object will be modified. No additional outputs required
    *
    * Hints:
    *     - the code here should be fairly small, most of the logic goes in the BST class
    *     - the deletion function internally relies on other auxiliary functions in the BST class such
    *       as min and deleteMin to get the job done.
    * */
    public static void people_pick_packages(BST<String, ResidentPackages> index, ArrayList<String> resident_keys){
        for (String key : resident_keys){
            index.delete(key);
        }
    }

    public static void main(String[] args) {
        // Keep this line here!
        Assignment2_Test.score_tests();

        // STEP 5: Feedback
        System.out.println("[Feedback: What did you think about this assignment?]");
    }
}
