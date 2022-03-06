package Test1;
import java.util.*;

public class MyProtectedUniqueList<T> implements Iterable<T> {
    private List<T> words;
    private final String password;

    public MyProtectedUniqueList(String password) {
        this.password = password;
        this.words = new ArrayList<>();
    }

    public void Add(T word) throws Exception {
        boolean flag = false;
        String emptySt = "";
        try {
            if (word == null || word.equals(emptySt)) throw new Exception();
        } catch (Exception e) {
            System.out.println("Word cannot be null or empty");
            return;
        }
        for (var st : words)
            if (st.equals(word)) {
                flag = true;
                break;
            }
        if (!flag) words.add(word);
    }

    public void Remove(T word) throws Exception {
        try {
            if (word == null || word.equals("")) throw new Exception();
        } catch (Exception e) {
            System.out.println("Word cannot be null or empty");
            return;
        }
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(word)) {
                words.remove(i);
                break; // because each word is only once
            }
        }

    }

    public void RemoveAt(int index) throws Exception {
        try {
            if (index < 0 || index > words.size() - 1) throw new Exception();
        } catch (Exception e) {
            System.out.println("Index out of range");
            return;
        }
        words.remove(index);
    }

    public void Clear(String password) throws Exception {
        try {
            if (!this.password.equals(password)) throw new Exception();
        } catch (Exception e) {
            System.out.println("Wrong Password, access denied");
            return;
        }
        words.clear();
    }

    public void Sort(String password) throws Exception {
        try {
            if (!this.password.equals(password)) throw new Exception();
        } catch (Exception e) {
            System.out.println("Wrong Password, access denied");
            return;
        }
        Collections.sort(words, this.CompareItems());
    }

    @Override
    public String toString() {
        return "MyProtectedUniqueList{" +
                "words =" + words +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericListIterator(this);
    }

    //    @Override
    //    public int compareTo(int index, T other) {
    //        if(this.words.get(index) > other) return 1;
    //        return 0;
    //    }
    public Comparator<T> CompareItems() {
        return new Comparator<>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1.hashCode() > o2.hashCode()) return -1;
                if (o1.hashCode() < o2.hashCode()) return 1;
                return 0;
            }
        };
    }

    //Used an Inner Class as we learned in class:

    private class GenericListIterator implements Iterator<T> {
        private MyProtectedUniqueList<T> list;
        private int index = 0;

        public GenericListIterator(MyProtectedUniqueList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return (index < list.words.size());
        }

        @Override
        public T next() {
            return (T) list.words.get(index++);
        }
    }

}
