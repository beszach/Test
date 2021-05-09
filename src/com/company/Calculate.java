package com.company;
import java.io.IOException;

public class Calculate {
    private String str, num1, num2, symbol;
    private final String[] RimNum = {"", "I", "II", "III", "IV", "V", "VI", "VII","VIII", "IX", "X"};
    private final String[] RimNum2 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
    private String[] Massive2Numbers;
    private int n1, n2, value;



    public void calculate(String str) throws  IOException{
        this.str = str;
        Test test = new Test();

        // сплитаем два числа математическим знаком и выводим в массив(если есть ошибки в знаках они выводятся):
        Massive2Numbers = this.str.split(test.TestMathSymbol(str));

        //Проверяем соответствуют ли числа арабским и корректно ли их значение. Если удовлетворяют условиям - выводим.
        if (test.TestonArabNumb(Massive2Numbers[0], Massive2Numbers[1])) {
            System.out.println(calcArab(test.TestMathSymbol(str), Massive2Numbers[0], Massive2Numbers[1]));
        }

        //Проверяем соответствуют ли числа римским и корректно ли их значение. Если удовлетворяют условиям - выводим.
        if (test.TestonRimNumb(Massive2Numbers[0], Massive2Numbers[1])) {
            System.out.println(calcRim(test.TestMathSymbol(str), Massive2Numbers[0], Massive2Numbers[1]));
        }

        if (test.TestonArabNumb(Massive2Numbers[0], Massive2Numbers[1]) == false &&
                test.TestonRimNumb(Massive2Numbers[0], Massive2Numbers[1]) == false){
        //Выводим ошибку, если ни римским, ни арабским они не соответствуют, или их значения выходят за нужный интервал
        throw new IOException("Запись должна соответствовать следующей: число + пробел + знак + пробел + число." + "\n"+
                    "Числа должны быть оба или римские, или арабские от 1 до 10 включительно.");
        }

    }

    private String calcArab(String symbol, String num1, String num2) {
        this.symbol = symbol;
        this.num1 = num1.substring(0, num1.length()-1); //берем число с вырезанным пробелом
        this.num2 = num2.substring(1, num2.length());   //берем число с вырезанным пробелом
        StringBuilder ArabValue = new StringBuilder("");

        //Производим вычисления
        switch (this.symbol){
            case "[\\+]": { ArabValue.append(String.valueOf(Byte.valueOf(this.num1)+Byte.valueOf(this.num2))); break;}
            case "[\\-]": { ArabValue.append(String.valueOf(Byte.valueOf(this.num1)-Byte.valueOf(this.num2))); break;}
            case "[\\/]": { ArabValue.append(String.valueOf(Byte.valueOf(this.num1)/Byte.valueOf(this.num2))); break;}
            case "[\\*]": { ArabValue.append(String.valueOf(Byte.valueOf(this.num1)*Byte.valueOf(this.num2))); break;}
            }

        //Выводим результат
        return ArabValue.toString();
    }


    public String calcRim(String symbol, String num1, String num2) throws IOException {
        this.symbol = symbol;
        this.num1 = num1.substring(0, num1.length()-1); //берем число с вырезанным пробелом
        this.num2 = num2.substring(1, num2.length());   //берем число с вырезанным пробелом

        //Переводим принятые числа из римских в арабские по индексу массива:
        for (int i = 0; i < RimNum.length; i++){
        if (this.num1.equals(RimNum[i])) n1 = i;
        if (this.num2.equals(RimNum[i])) n2 = i;
        }

        // Вычисляем результат введенного уравнения
        switch (this.symbol){
            case "[\\+]":{ value = n1+n2; break;}
            case "[\\-]":{
                if (n1<=n2) throw new IOException("При вычитании римских чисел первое число должно быть больше второго.");
                value = n1-n2; break;}
            case "[\\/]":{
                if (n1<n2) throw new IOException("При делении римских чисел первое число должно быть не меньше второго.");
                value = n1/n2; break;}
            case "[\\*]":{
                value = n1*n2; break;}
            }

        // Переводим результат из арабских цифр в римские и выводим
        return RimNum2[value/10]+RimNum[value%10];
    }



}
