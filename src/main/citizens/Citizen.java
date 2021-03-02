package main.citizens;

import java.util.Objects;

public abstract class Citizen {
    private static int uniqueId = 1;
    private int citizenId;
    private String name;
    private String address;
    private int age;
    private CitizenType type;

    public Citizen (String name, String address, int age){
        if(name.length()>0){
            this.name = name;
        }
        if(address.length()>0){
            this.address = address;
        }
        if(age>=18){
            this.age = age;
        }
        else {
            this.age = 18;
        }
        this.type = validateType();
        citizenId = uniqueId++;
    }

    public enum CitizenType{
        ACCUSER, DEFENDANT, WITNESS
    }
    protected abstract CitizenType validateType();

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return citizenId == citizen.citizenId && age == citizen.age && name.equals(citizen.name) && address.equals(citizen.address) && type == citizen.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(citizenId, name, address, age, type);
    }
}
