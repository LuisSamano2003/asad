import java.util.ArrayList;


public class BST<Key extends Comparable<Key>, Value> {
    // <START: DO NOT MODIFY ZONE>
    private BST_Node<Key,Value> root;

    public BST(){
        this.root = null;
    }

    public int getSize(){
        if (this.root == null){
            return 0;
        } else {
            return this.root.getSize();
        }
    }

    public ArrayList<Key> keys(){
        ArrayList<Key> all_keys = new ArrayList<>();
        collect_keys_in_order(this.root, all_keys);
        return all_keys;
    }

    private void collect_keys_in_order(BST_Node<Key, Value> current, ArrayList<Key> all_keys){
        if (current == null){
            return;
        }

        collect_keys_in_order(current.getLeft(), all_keys);
        all_keys.add(current.key);
        collect_keys_in_order(current.getRight(), all_keys);
    }

    // <END: DO NOT MODIFY ZONE>

    //TODO: You can and have to modify the code of these functions. Feel free to add auxiliary functions as needed

    /*
    *  The Put function of the Binary Search Tree. You can follow the slides on how to implement this function
    * */
    public void put(Key key, Value value){
        // TODO: your code here
        root = put(root, key, value);

    }

    private BST_Node<Key, Value> put(BST_Node<Key, Value> x, Key key, Value val)
    {
        if(x == null){
            return  new BST_Node<>(key, val);
        }
        int cmp = key.compareTo( x.key);
        if(cmp < 0)
        {
            x.setLeft(put(x.getLeft(), key, val));
        } else if(cmp > 0){
            x.setRight(put(x.getRight(), key, val));
        } else x.setValue(val);

        return x;
    }

    /*
     *  The Get function of the Binary Search Tree. You can follow the slides on how to implement this function
     * */
    public Value get(Key key){
        // TODO: your code here
        BST_Node<Key, Value> x = root;
        while(x != null)
        {
            int cmp = key.compareTo((Key) x.key);
            if(cmp < 0) x = x.getLeft();
            else if (cmp > 0) x = x.getRight();
            else return  x.getValue();
        }

        return null;
    }

    /*
     *  The min function of the Binary Search Tree. You can follow the slides on how to implement this function
     * */
    public BST_Node<Key, Value> findMin(BST_Node<Key, Value> current){
        // TODO: your code here
        return null;
    }

    /*
     *  The max function of the Binary Search Tree. You can follow the slides on how to implement this function.
     *  This function is NOT needed for this homework, but feel free to implement it if you want
     * */
    public BST_Node<Key, Value> findMax(BST_Node<Key, Value> current){
        // TODO: your code here
        return null;
    }

    /*
     *  The recursive deleteMin function of the Binary Search Tree. You can follow the slides on how to implement
     *  this function.
     * */
    private BST_Node<Key, Value> deleteMin(BST_Node<Key, Value> current)
    {
        // TODO: your code here ...
        return null;
    }

    /*
     *  The delete function of the Binary Search Tree. You can follow the slides on how to implement this function
     * */
    public void delete(Key key)
    {
        // TODO: your code here
    }

    /*
     *  The required function for collecting all values in the tree associated with keys on the provided range.
     *  The resulting keys must be sorted.
     *  This is a custom function not covered in the slides. You will have to figure it out on your own
     *
     *  Hint: you can use a very similar logic to Rank function.
     *  Hint: to produce sorted keys, you can use similar logic to in-order traversal
     * */
    public ArrayList<Value> valuesInKeyRange(Key min_key, Key max_key){
        // TODO: Your code here
        return new ArrayList<>();
    }
}
