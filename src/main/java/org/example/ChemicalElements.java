package org.example;

public class ChemicalElements {
    private String item;
   private int index;

    public ChemicalElements(String item, int index) {
        this.item = item;
        this.index = index;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "ChemicalElements{" +
                "item='" + item + '\'' +
                ", index=" + index +
                '}';
    }
}
