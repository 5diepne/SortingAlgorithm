/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorting;

/**
 *
 * @author DiepTCNN
 */

public class Employees  implements Comparable<Employees>{
    private String ID;
    private String name;
    private Integer level;

    public Employees() {
    }

    public Employees(String ID, String name, int level) {
        this.ID = ID;
        this.name = name;
        this.level = level;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Employees{" + "ID=" + ID + ", name=" + name + ", level=" + level + '}';
    }

    @Override
    public int compareTo(Employees o) {
        return ID.compareTo(o.ID);
    }
    
}
