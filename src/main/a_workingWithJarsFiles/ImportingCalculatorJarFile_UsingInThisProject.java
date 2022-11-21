package main.a_workingWithJarsFiles;

import main.RationalNumber;

import java.util.Arrays;
import java.util.Collections;

public class ImportingCalculatorJarFile_UsingInThisProject
{
    public static void main(String[] args)
    {

        //Jar'ini cikardigim RationalNumber class'inin tipatip aynisini kopyaladim ve RationalNumber01 isimli class olusturdum.
        //RationalNumber01 class'ina ait methodlari kullandim
        //Ders'te beraber yazmadik bunu ilave olsun diye ekledim.(Emre Hoca)
        utilizingMyClass();

        //Baska bir intellij java projectinin jar'ini cikarip
        //import ettigim RationalNumber isimli class'daki methodlari kullandim.
        usingJar();

    }

    static void utilizingMyClass()
    {

        RationalNumber01 rs = new RationalNumber01(0, 10);        System.out.println(rs);
        RationalNumber01 rs01 = new RationalNumber01(2, 3);        System.out.println(rs01);
        RationalNumber01 rs02 = new RationalNumber01(7, 11);        System.out.println(rs02);


        RationalNumber01 sum = rs01.add(rs02);
        System.out.println("sum = " + sum);
    }

    static void usingJar()
    {
        System.out.println("----------------------------------------------------------------------------------");
        RationalNumber rsi=new RationalNumber(3,4);
        System.out.println(rsi);

        RationalNumber rs2=new RationalNumber(3, 4);
        System.out.println(rs2);

        RationalNumber rs3=new RationalNumber(-2,5);
        System.out.println(rs3);

        RationalNumber rs4=new RationalNumber(8,9);
        System.out.println(rs4);



        RationalNumber[] sayilar={rsi,rs2,rs3,rs4};
        Arrays.sort(sayilar, Collections.reverseOrder());

        for(RationalNumber temp : sayilar) {
            System.out.print(temp + ",");
        }


    }

}
