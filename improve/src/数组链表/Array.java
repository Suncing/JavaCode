package 数组链表;

public class Array {
    private int[] array;
    private int length = 0;

    public Array(int size) {
        array = new int[size];
    }

    public void insert(int elem) {
        array[length++] = elem;
    }

    public boolean find(int elem) {
        for (int i = 0; i < length; i++) {
            if (array[i] == elem) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int elem) {
        for (int i = 0; i < length; i++) {
            if (array[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    public boolean delete(int elem) {
        int i = 0;
        for (i = 0; i < length; i++) {
            if (elem == array[i]) {
                break;
            }
        }
        if(i==length){
            return false;
        }
        for(int j = i;j<length - 1;j++){
            array[j]=array[j+1];
        }
        length--;
        return true;
    }

    public void show(){
        for(int i=0;i<length;i++){
            if(i==length-1){
                System.out.println(array[i]);
            }
            else{
                System.out.println(array[i]+",");
            }
        }
    }

    public static void main(String[] args) {
        Array array =  new Array(10);
        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.show();
        int index = array.indexOf(2);
        boolean a = array.delete(2);

    }
}
