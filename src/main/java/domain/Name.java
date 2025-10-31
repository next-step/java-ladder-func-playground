package domain;

import java.util.Objects;

public class Name {
    private final String value;
    public Name(String value){
        if (value == null || value.trim().isEmpty()){
            throw new IllegalArgumentException("비어 있을 수 없습니다.");
        }
        this.value = value.trim();
    }

    public String value(){
        return value;
    }

    @Override
    public String toString(){
        return value;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof Name)) return false;
        Name name = (Name)obj;
        return value.equals(name.value);
    }

    @Override
    public int hashCode(){
        return value.hashCode();
    }
}
