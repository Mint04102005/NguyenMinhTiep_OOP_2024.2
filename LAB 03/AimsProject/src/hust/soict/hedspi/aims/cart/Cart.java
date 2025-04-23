package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered++] = dvd;
            System.out.println("Added " + dvd.getTitle() + " to the cart.");
        } else {
            System.out.println("Cart is full.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        if (qtyOrdered == 0) {
            System.out.println("Cart is empty.");
            return;
        }

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(dvd)) {
                System.arraycopy(itemsOrdered, i + 1, itemsOrdered, i, qtyOrdered - i - 1);
                itemsOrdered[--qtyOrdered] = null;
                System.out.println("Removed " + dvd.getTitle() + " from the cart.");
                return;
            }
        }

        System.out.println("DVD not found in the cart.");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void displayCart() {
        if (qtyOrdered == 0) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("Current Cart:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getDirector());
        }
        System.out.println("Total cost: $" + totalCost());
    }

    public void addDVD(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            if (dvd != null) {
                if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                    System.out.println("Cart is full.");
                    break;
                }
                addDVD(dvd);
            }
        }
    }

    public void addDVD(DigitalVideoDisc[] dvdList, int count) {
        for (int i = 0; i < count && i < dvdList.length; i++) {
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("Cart is full.");
                break;
            }
            addDVD(dvdList[i]);
        }
    }

    public void addDVD(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDVD(dvd1);
        addDVD(dvd2);
    }
}