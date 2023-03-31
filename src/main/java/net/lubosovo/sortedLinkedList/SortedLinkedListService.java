package net.lubosovo.sortedLinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SortedLinkedListService {

    @Autowired
    SortedLinkedList<Integer> i;

    @Autowired
    SortedLinkedList<String> s;

    public Integer getInt(int index) {
        return i.get(index);
    }

    public boolean addInt(Integer integer) {
        return i.add(integer);
    }

    public Integer removeInt(int index) {
        return i.remove(index);
    }

    public String getString(int index) {
        return s.get(index);
    }

    public boolean addString(String string) {
        return s.add(string);
    }

    public String removeString(int index) {
        return s.remove(index);
    }
}
