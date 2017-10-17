
///1. Реализовать перевод из 10 в 2 систему счисления с использованием стека.
import java.io.BufferedReader;
import java.io.InputStreamReader;


class Convers {


    public static void main(String[] args) throws Exception {
        System.out.print("Введите число для конвертирования: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sNum = br.readLine();
        int i = Integer.parseInt(sNum);
        System.out.print("Выберите основание новой системы счисления: ");
        String sNu = br.readLine();
        int q = Integer.parseInt(sNu);
        System.out.println("В выбранной системе счисления " + i + " будет равно " + Integer.toString(i, q));
    }
}
