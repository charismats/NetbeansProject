/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day04;

/**
 *
 * @author charisma
 */
public class Method {

    // Soal Satu

    public static int AddTwo(int a, int b) {
        return a + b;
    }

    // Soal Dua

    public static int Maxim(int c, int d, int e) {
        int max = c;
        if (d > max) {
            max = d;
        }
        if (e > max) {
            max = e;
        }
        return max;
    }

    // Soal Tiga

    public static int Minim(int c, int d, int e) {
        int min = c;
        if (d < min) {
            min = d;
        }
        if (e < min) {
            min = e;
        }
        return min;
    }

    // Soal Empat

    public static int power(int x, int y) {
        int hasil = 1;
        for (int z = 0; z < y; z++) {
            hasil *= x;
        }
        return hasil;
    }

    // Soal 5

    public static int Sigma1(int lim1, int lim2) {
        int sum = 0;
        for (int i = lim1; i <= lim2; i++) {
            sum += 2 * i + 1;
        }
        return sum;
    }

    // Soal 6
    public static int Sigma2(int lim1, int lim2) {
        int sum = 0;
        for (int i = lim1; i <= lim2; i++) {
            sum += 3 * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        int sum = AddTwo(a, b);
        System.out.println("a+b=" + sum);

        int c = 2;
        int d = 10;
        int e = 5;
        //soal 2
        int maxi = Maxim(c, d, e);
        System.out.println("Tertinggi " + maxi);
        //soal 3
        int mini = Minim(c, d, e);
        System.out.println("Terendah " + mini);
        //soal 4
        int Hasil = power(5, 5);
        System.out.println("5 pangkat 5 " + Hasil);
        //soal 5
        int Sigma1 = Sigma1(1, 10);
        System.out.println("Hasil=" + Sigma1);
        //Soal 6
        int Sigma2 = Sigma2(1, 4);
        System.out.println("Hasil=" + Sigma2);
    }
}
