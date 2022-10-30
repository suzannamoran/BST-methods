package assn04;


import java.util.LinkedList;
import java.util.Queue;


public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
    private T _element;
    private BST<T> _left;
    private BST<T> _right;

    public NonEmptyBST(T element) {

        _left = new EmptyBST<T>();
        _right = new EmptyBST<T>();
        _element = element;
    }


    // TODO: insert
    @Override
    public BST<T> insert(T element) {
        if (element.compareTo(this._element) > 0) {
            this._right = this.getRight().insert(element);
            //System.out.println(element.toString() + " entered to right");
        } else if (element.compareTo(this._element) < 0) {
            this._left = this.getLeft().insert(element);
            //System.out.println(element.toString() + " entered to left");
        }
        return this;
    }

    // TODO: remove
    @Override
    public BST<T> remove(T element) {
        if (element.compareTo(this._element) > 0) {
            this._right = _right.remove(element);

        } else if (element.compareTo(this._element) < 0) {
            this._left = _left.remove(element);
        } else if (element.compareTo(this._element) == 0) {

            if ((_left.isEmpty()) && (_right.isEmpty())) {        //leaf
                return new EmptyBST<>();
            } else if (_left.isEmpty()) {        //only right child
                return _right;
            } else if (_right.isEmpty()) {        //only left child
                return _left;
            } else {
                BST<T> temp = _right;
                while(!temp.getLeft().isEmpty()){
                    temp = temp.getLeft();
                }
                T temp2 = temp.getElement();
                this.remove(temp2);
                this._element = temp2;


            }

        }
        return this;
    }


    // TODO: printPreOrderTraversal
    @Override
    public void printPreOrderTraversal() {


    }

    // TODO: printPostOrderTraversal
    @Override
    public void printPostOrderTraversal() {


    }

    // TODO: printBreadthFirstTraversal

    @Override
    public void printBreadthFirstTraversal() {
		Queue<BST<T>> q = new LinkedList<>();
		printBreadthFirstTraversal2(q);
    }

	@Override
    public void printBreadthFirstTraversal2(Queue<BST<T>> q) {
        if (this._element == null) {
            return;
        } else {
            System.out.print(this._element + " ");


            if (this.getLeft().isEmpty() == false) {
                q.add(this.getLeft());
            }

            if (this.getRight().isEmpty() == false) {
                q.add(this.getRight());
            }

            if (q.size() != 0) {
                q.poll().printBreadthFirstTraversal2(q);
            } else {
                return;
            }
        }
    }


    @Override
    public int getHeight() {
        return Math.max(_left.getHeight(), _right.getHeight()) + 1;


    }


    @Override
    public BST<T> getLeft() {
        return _left;
    }

    @Override
    public BST<T> getRight() {
        return _right;
    }

    @Override
    public T getElement() {
        return _element;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
