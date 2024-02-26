package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Integer> list;
    private int pointer;

    public CircularListImpl(){
        this.list = new ArrayList<Integer>();
        this.pointer = -1;
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        if(this.isEmpty()){
            return Optional.empty();
        }
        if(this.pointer + 1 >= this.size()){
            this.pointer = -1;
        }
        return Optional.of(this.list.get(++this.pointer));
    }

    @Override
    public Optional<Integer> previous() {
        if(this.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(this.list.get(this.pointer <= 0? this.list.size() - 1 : --this.pointer));
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

}
