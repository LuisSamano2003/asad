public class BST_Node<Key extends Comparable<Key>, Value> {
    // <START: DO NOT MODIFY SECTION>
    private int size;
    public final Key key;
    private Value value;
    private BST_Node<Key, Value> left;
    private BST_Node<Key, Value> right;

    public BST_Node(Key key, Value value){
        this.key = key;
        this.value = value;
        this.size = 1;
    }

    public BST_Node<Key, Value> getLeft(){
        return this.left;
    }

    public void setLeft(BST_Node<Key, Value> child){
        this.left = child;
    }

    public BST_Node<Key, Value> getRight(){
        return this.right;
    }

    public void setRight(BST_Node<Key, Value> child){
        this.right = child;
    }

    public Value getValue(){
        return this.value;
    }

    public void setValue(Value value){
        this.value = value;
    }

    public int getSize(){
        return this.size;
    }

    public void setSize(int size){
        this.size = size;
    }
    // <END: DO NOT MODIFY SECTION>

    // TODO: If you need any custom functions, you can add them here ...
}
