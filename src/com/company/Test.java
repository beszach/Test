package com.company;
import java.io.IOException;

public class Test {
    private String str, num1 , num2;
    private String[] MathSymbols = {"+", "-", "/", "*"};
    private String[] Num = {"1", "2", "3", "4", "5", "6","7", "8", "9", "10"};
    private String[] RimNum = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private boolean trueNum1Arab, trueNum2Arab, trueNum1Rim, trueNum2Rim;

    public String TestMathSymbol(String str) throws IOException {
        this.str = str;
        str = str.replaceAll("[\\+-]|[\\*]|[\\/]", ""); // Убираем знаки из строки

        //Если количество знаков не равно одному, то выдает ошибку:
        if (this.str.length()-str.length() != 1) throw new IOException("Количество знаков не равно одному!");

        for(String s : MathSymbols) {
        if (this.str.indexOf(s) < 1 || this.str.indexOf(s) == this.str.length()-1) continue; //Пропускаем символы на краях уравнения
        if (this.str.indexOf(s) > 0) return "[\\"+s+"]"; // Возращаем найденный символ
        }
        throw new IOException("В уравнении только одно число!");
    }

    public boolean TestonArabNumb(String num1, String num2) throws IOException{
    //  Если после первого числа нету пробела или перед вторым числом нет пробела выдает ошибку:
      if (num1.charAt(num1.length()-1) != ' ' || num2.charAt(0) != ' '){
          throw new IOException("Запись должна соответствовать следующей: число + пробел + знак + пробел + число.");
      }
      this.num1 = num1.substring(0, num1.length()-1); // убираем пробел
      this.num2 = num2.substring(1, num2.length());   // убираем пробел

    // Проверяем соответствие вписанных чисел арабским числам от 1 до 10:
      for (String a: Num){

          if (a.equals(this.num1)){
              trueNum1Arab = true;
          }
          if (a.equals(this.num2)){
              trueNum2Arab = true;
          }

      }

    // Если оба числа соответствуют условиям выдает истину:
    if (trueNum1Arab && trueNum2Arab) return true; else return false;

    }

    public boolean TestonRimNumb(String num1, String num2) throws IOException{
        //  Если после первого числа нету пробела или перед вторым числом нет пробела выдает ошибку:
        if (num1.charAt(num1.length()-1) != ' ' || num2.charAt(0) != ' ') {
            throw new IOException("Запись должна соответствовать следующей: число + пробел + знак + пробел + число.");
        }
        this.num1 = num1.substring(0, num1.length()-1); // убираем пробел
        this.num2 = num2.substring(1, num2.length());   // убираем пробел

        // Проверяем соответствие вписанных чисел римским числам от 1 до 10:
        for (String a: RimNum){
            if (a.contains(this.num1)){
                trueNum1Rim = true;
            }
            if (a.contains(this.num2)){
                trueNum2Rim = true;
            }
        }

        // Если оба числа соответствуют условиям выдает истину:
        if (trueNum1Rim && trueNum2Rim) return true; else return false;

    }









}
