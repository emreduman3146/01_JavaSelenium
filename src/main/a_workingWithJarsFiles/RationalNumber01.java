package main.a_workingWithJarsFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RationalNumber01 implements Comparable<RationalNumber01>
{
    private int share;
    private int denominator;
    List<RationalNumber01> rationalNumbers = new ArrayList();
    Scanner scan;
    int firstRNumber;
    int secondRNumber;

    public RationalNumber01() {
    }

    public RationalNumber01(int share, int denominator)
    {
        int ebob = this.ebobBul(share, denominator);
        this.share = share / ebob;
        this.denominator = denominator / ebob;
    }

    public String toString() {
        if (this.denominator == 0) {
            return this.share + "/" + this.denominator + " TANIMSIZDIR!";
        } else {
            int var10000;
            if (this.share / this.denominator == 0) {
                if (this.share > 0 && this.denominator > 0 || this.share < 0 && this.denominator < 0) {
                    var10000 = Math.abs(this.share);
                    return String.valueOf(var10000 + "/" + Math.abs(this.denominator));
                }

                if (this.share > 0 && this.denominator < 0 || this.share < 0 && this.denominator > 0) {
                    return String.valueOf(this.share + "/" + this.denominator);
                }

                if (this.share == 0 && this.denominator != 0) {
                    return "Result:0";
                }
            }

            if (this.share / this.denominator > 0) {
                if (Math.abs(this.share) > Math.abs(this.denominator) && Math.abs(this.denominator) == 1) {
                    return String.valueOf(Math.abs(this.share));
                }

                if (Math.abs(this.share) > Math.abs(this.denominator) && Math.abs(this.denominator) != 1) {
                    var10000 = Math.abs(this.share);
                    return String.valueOf(var10000 + "/" + Math.abs(this.denominator));
                }

                if (Math.abs(this.share) == Math.abs(this.denominator)) {
                    return "Result: 1";
                }
            }

            if (this.share / this.denominator < 0) {
                if (Math.abs(this.share) == Math.abs(this.denominator)) {
                    return "Result:1";
                } else if (this.denominator == 1) {
                    return String.valueOf(this.share);
                } else {
                    return this.denominator == -1 ? String.valueOf(-1 * this.share) : this.share + "/" + this.denominator;
                }
            } else {
                return "";
            }
        }
    }

    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.share;
        hash = 71 * hash + this.denominator;
        return hash;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (!(obj instanceof RationalNumber01)) {
            return false;
        } else {
            RationalNumber01 nesne = (RationalNumber01)obj;
            return this.denominator == nesne.denominator && this.share == nesne.share;
        }
    }

    private int ebobBul(int share, int denominator) {
        int shareAbsoluteValue = Math.abs(share);
        int denominatorAbsoluteValue = Math.abs(denominator);
        int ebob = 1;

        for(int i = 1; i <= shareAbsoluteValue && i <= denominatorAbsoluteValue; ++i) {
            if (shareAbsoluteValue % i == 0 && denominatorAbsoluteValue % i == 0) {
                ebob = i;
            }
        }

        return ebob;
    }

    public void enterNumbers() {
        System.out.print("Please Enter Share and Denominator one by one:\nShare:");
        this.share = this.scan.nextInt();
        System.out.print("Denominator:");
        this.denominator = this.scan.nextInt();
        RationalNumber01 fraction = new RationalNumber01(this.share, this.denominator);
        this.rationalNumbers.add(fraction);
        System.out.println(fraction);
    }

    public void showRationalNumbers() {
        System.out.println(this.rationalNumbers);
    }

    public void sortedList(List<RationalNumber01> list) {
        List<RationalNumber01> sortedList = new ArrayList();

        for(int i = 0; i < list.size(); ++i) {
            sortedList.add(i, (RationalNumber01)list.get(i));
        }

        Collections.sort(sortedList);
        System.out.println(sortedList);
        System.out.println("size:" + sortedList.size());
    }

    public RationalNumber01 add(RationalNumber01 number) {
        int newShare = this.share * number.denominator + this.denominator * number.share;
        int newDeminator = this.denominator * number.denominator;
        RationalNumber01 result = new RationalNumber01(newShare, newDeminator);
        this.rationalNumbers.add(result);
        return result;
    }

    public RationalNumber01 substract(RationalNumber01 cikarilacakSayi) {
        int newShare = this.share * cikarilacakSayi.denominator - this.denominator * cikarilacakSayi.share;
        int newDeminator = this.denominator * cikarilacakSayi.denominator;
        RationalNumber01 result = new RationalNumber01(newShare, newDeminator);
        return result;
    }

    public RationalNumber01 multiply(RationalNumber01 number) {
        int newShare = this.share * number.share;
        int newDeminator = this.denominator * number.denominator;
        RationalNumber01 result = new RationalNumber01(newShare, newDeminator);
        return result;
    }

    public RationalNumber01 divide(RationalNumber01 number) {
        int newShare = this.share * number.denominator;
        int newDeminator = this.denominator * number.share;
        RationalNumber01 result = new RationalNumber01(newShare, newDeminator);
        return result;
    }

    public void transaction(int i) {
        boolean goOn = true;

        while(true) {
            while(true) {
                while(goOn) {
                    if (this.rationalNumbers.size() >= 2) {
                        System.out.println("Total element number of the list is " + this.rationalNumbers.size() + " .\nWhich elements of list do you want to add?\nSelect first element:");
                        int number = this.scan.nextInt();
                        System.out.println("\nSelect second element:");
                        int number2 = this.scan.nextInt();
                        if (number <= this.rationalNumbers.size() && number2 <= this.rationalNumbers.size()) {
                            this.firstRNumber = number - 1;
                            this.secondRNumber = number2 - 1;
                            switch(i) {
                                case 1:
                                    RationalNumber01 addition = ((RationalNumber01)this.rationalNumbers.get(this.firstRNumber)).add((RationalNumber01)this.rationalNumbers.get(this.secondRNumber));
                                    System.out.println("Result:" + addition);
                                    break;
                                case 2:
                                    RationalNumber01 substraction = ((RationalNumber01)this.rationalNumbers.get(this.firstRNumber)).substract((RationalNumber01)this.rationalNumbers.get(this.secondRNumber));
                                    System.out.println("Result:" + substraction);
                                    break;
                                case 3:
                                    RationalNumber01 multiplication = ((RationalNumber01)this.rationalNumbers.get(this.firstRNumber)).multiply((RationalNumber01)this.rationalNumbers.get(this.secondRNumber));
                                    System.out.println("Result:" + multiplication);
                                    break;
                                case 4:
                                    RationalNumber01 division = ((RationalNumber01)this.rationalNumbers.get(this.firstRNumber)).divide((RationalNumber01)this.rationalNumbers.get(this.secondRNumber));
                                    System.out.println("Result:" + division);
                            }

                            System.out.println("If you want to continue  for another transaction(Press 1)\nto quit(Press 0)");
                            goOn = this.scan.nextInt() == 1;
                        } else {
                            System.out.println("You entered wrong  numbers combination!!!\nIf you want to continue  for the transaction(Press 1)\nto quit(Press 0)");
                            goOn = this.scan.nextInt() == 1;
                        }
                    } else {
                        System.out.println("Any list does not exist!!!");
                        goOn = false;
                    }
                }

                return;
            }
        }
    }

    public int compareTo(RationalNumber01 o) {
        if (this.substract(o).share > 0) {
            return -1;
        } else {
            return this.substract(o).share < 0 ? 1 : 0;
        }
    }

    public void main() {
        this.scan = new Scanner(System.in);
        boolean goON = true;

        while(goON) {
            label39:
            while(goON) {
                System.out.println("-------------------------------------------------\n1. If you want to add a rational number into the list(Press 1)\n2. If you want to display the rational number list(Press 2)\n3. If you want to do transaction with rational numbers from list (Press 3)\n4. If you want to add rational numbers to practice (Press 4)\n5. If you want to display sortedList (Press 5)\n6. If you want to check if 2 numbers are equals to each other (Press 6)\n7. If you want to exit the system (Press 0)");
                switch(this.scan.nextInt()) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        goON = true;

                        while(true) {
                            if (!goON) {
                                continue label39;
                            }

                            this.enterNumbers();
                            System.out.println("Do you wanna go on to enter numbers?(if yes, type true; if no ,type false");
                            goON = this.scan.nextBoolean();
                        }
                    case 2:
                        this.showRationalNumbers();
                        break;
                    case 3:
                        try {
                            System.out.println("1.For Addition - Press 1\n2.For Substraction - Press 2\n3.For Multiplication - Press 3\n4.For Addition - Press 4");
                            int option = this.scan.nextInt();
                            if (option > 0 && option < 5) {
                                this.transaction(option);
                                break;
                            }

                            System.out.println("Wrong Transaction!!!");
                            break;
                        } catch (Exception var6) {
                            System.out.println("Selection is wrong");
                        }
                    case 4:
                        RationalNumber01 obje = new RationalNumber01(2, 4);
                        RationalNumber01 obje2 = new RationalNumber01(3, 4);
                        System.out.println(obje.add(obje2));
                        break;
                    case 5:
                        this.sortedList(this.rationalNumbers);
                        break;
                    case 6:
                        if (this.rationalNumbers.size() >= 2) {
                            System.out.print("Please enter the sequence numbers of both rational numbers\nFirst one:");
                            int first = this.scan.nextInt() - 1;
                            System.out.print("\nSecond one:");
                            int second = this.scan.nextInt() - 1;
                            System.out.println(((RationalNumber01)this.rationalNumbers.get(first)).equals(this.rationalNumbers.get(second)));
                        } else {
                            System.out.println("There is no enough number at the list, Back to main menu, add new numbers to compare them!");
                        }
                        break;
                    default:
                        System.out.println("Wrong Option!!!");
                }
            }
        }
    }
}