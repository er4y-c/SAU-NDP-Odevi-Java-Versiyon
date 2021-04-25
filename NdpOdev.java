package ndpodev;
import java.io.IOException;
import java.util.Scanner;

public class NdpOdev {
    static void menuYazdir() {
        System.out.println("\n..:: İşlemler ::..");
        System.out.println("1-Matris İşlemleri");
        System.out.println("2-String İşlemleri");
        System.out.println("3-Çıkış");
        System.out.print("Seçiminiz :");
    }
    static void ters(char[] islemChr,int a,int b) {
        for(int i=b-1; i>a; i--) {
            System.out.print(islemChr[i]);
        }
    }
    static void tekrar(char[] islemChr,int a,int b) {
        for(int i=0; i<5; i++) {
            for(int j=a-1; j<b; j++) {
                System.out.print(islemChr[j]);
            }
            System.out.println(" ");
        }
    }
    static void temizle() {
        //Runtime.getRuntime().exec("cls") metodu benim bilgisayarımda çalışmadığı için böyle bir çözüm buldum
        for(int i=0; i<100; i++) {
            System.out.println(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        int secim;
        String tus;
        Scanner scr = new Scanner(System.in);
        menuYazdir();
        while(true) {
            secim = scr.nextInt();
            if(secim==3) {
                System.out.print("Çıkış yapmak");
                return;
            }
            
            if(secim==1) {
                int satir,i,j,sayac = 1;
                
                System.out.println("\n..:: Matris İşlemleri ::..");
                System.out.print("Satır sayısını giriniz : (1-10 arasında)");
                satir = scr.nextInt();
                while(satir<1 || satir>10) {
                    System.out.print("Hata! Geçerli bir değer giriniz : ");
                    satir = scr.nextInt();
                }
                int [][] dizi = new int[satir][satir];
                for(i=0; i<satir; i++) {
                    for(j=0; j<satir; j++,sayac++) {
                        dizi[i][j] = sayac;
                        System.out.println("["+(i+1)+","+(j+1)+"]"+"="+dizi[i][j]);
                    }
                }
                for(i=0; i<satir; i++) {
                    for(j=0; j<satir; j++) {
                        System.out.print(dizi[i][j]+" ");
                    }
                    System.out.println(" ");
                }
                System.out.println("1-Satır en büyük");
                System.out.println("2-Satır Toplam");
                System.out.print("Seçiminiz : ");
                secim = scr.nextInt();
                switch (secim) {
                    case 1:
                        int[] dizi2 = new int[satir];
                        System.out.println("Sonuç : ");
                        for(i=0; i<satir; i++) {
                            dizi2[i] = dizi[i][satir-1];
                        }   for(i=0; i<satir; i++) {
                            System.out.print(dizi2[i]+" ");
                        }   //Yukarıdaki kısmı hoca ödevde en büyük değerler bulunarak yeni bir diziye atılır ve o dizi listelenir dediği için bu kadar aptalca yaptım.
                        System.out.println("Devam etmek için bir tuşa basınız");
                        tus = scr.next();
                        temizle();
                        menuYazdir();
                        break;
                    case 2:
                        int toplam = 0;
                        System.out.println("Sonuç : ");
                        for(i=0; i<satir; i++) {
                            for(j=0; j<satir; j++) {
                                toplam += dizi[i][j];
                            }
                            System.out.print(toplam +" ");
                            toplam = 0;
                        }   
                        System.out.println("Devam etmek için bir tuşa basınız");
                        tus = scr.next();
                        temizle();
                        menuYazdir();
                        break;
                    default:
                        System.out.println("Hatalı Seçim");
                        temizle();
                        menuYazdir();
                        break;
                }
            }
            if(secim==2) {
                String islem,harfStr;
                char harf;
                int i,sayac = 0;
                System.out.println("\n..:: String İşlemleri ::..");
                System.out.print("İşlem yapılacak Stringi giriniz : ");
                islem = scr.next();
                int uzunluk = islem.length();
                char[] islemChr = new char[uzunluk];
                islemChr = islem.toCharArray();
                System.out.print("İstenen harf : ");
                harfStr = scr.next();
                harf = harfStr.charAt(0);
                
                for(i=0; i<uzunluk; i++) {
                    if(islemChr[i] == harf) {
                        sayac++;
                    }
                }
                if(sayac != 2) {
                    System.out.println("Cümle içerisinde harf bulunamamıştır!");
                    System.out.println("Devam etmek için bir tuşa basınız");
                    tus = scr.next();
                    temizle();
                    menuYazdir();
                } else {
                    System.out.println("1-Ara Metni Tersten Yaz");
                    System.out.println("2-Ara Metni Tekrarlı Yaz");
                    System.out.print("Seçiminiz : ");
                    secim = scr.nextInt();
                    int siraBir = islem.indexOf(harf),siraIki = islem.lastIndexOf(harf);
                    
                    switch (secim) {
                        case 1:
                            ters(islemChr,siraBir,siraIki);
                            System.out.println("Devam etmek için bir tuşa basınız");
                            tus = scr.next();
                            temizle();
                            menuYazdir();
                            break;
                        case 2:
                            tekrar(islemChr,siraBir,siraIki);
                            System.out.println("Devam etmek için bir tuşa basınız");
                            tus = scr.next();
                            temizle();
                            menuYazdir();
                            break;
                        default:
                            System.out.println("Hatalı seçim");
                            temizle();
                            menuYazdir();
                            break;
                    }
                    }
                }
                
             else {
                System.out.println("Hatalı seçim");
                temizle();
                menuYazdir();
            }
        }
    }
    
}
