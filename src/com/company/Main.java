package com.company;

public class Main {

    // Number even type
    enum NumberEvenityType {
        EVEN, // Четное
        ODD // Нечетное
    }

    public static void main(String[] args) {
        String hello = "Hello, World";
        System.out.println(hello);

        // Предположим, что я номер 24 в списке далее:

        // число, що відповідає номеру залікової книжки за допомогою шістнадцяткового літералу;
        int studentCardNumberHex = Integer.parseInt(Integer.toHexString(24)); // Or just 0x19

        // число, що відповідає номеру мобільного телефона (починаючи з 380...) за допомогою десяткового літералу;
        Long phoneNumber = 380_953_370_468L;

        // число, яке складається з останніх двох ненульових цифр номера мобільного телефону за допомогою двійкового літералу;
        int lastTwoNumberSymbolsBinary = Integer.parseInt(Integer.toBinaryString(68)); // 0b1000100

        // число, яке складається з останніх чотирьох ненульових цифр номера мобільного телефону за допомогою вісімкового літералу;
        int lastFourNumberSymbolsOctal = Integer.parseInt(Integer.toOctalString(7468)); // 016454

        // визначити збільшене на одиницю значення залишку від ділення на 26 зменшеного на одиницю номера студента в журналі групи;
        int divResult = ((24 + 1) % 26) + 1;

        // символ англійського алфавіту в верхньому регістрі, номер якого відповідає знайденому раніше значенню.
        char charLowercase = (char) divResult;
        char charUppercase = Character.toUpperCase(charLowercase);

        // Використовуючи десятковий запис цілочисельного значення кожної змінної знайти і підрахувати кількість парних і непарних цифр.
        System.out.println(getCountOfNumbersWithEvenType(12345, NumberEvenityType.EVEN)); // must be 2 - {2, 4}
        System.out.println(getCountOfNumbersWithEvenType(12345, NumberEvenityType.ODD)); // must be 3 - {1, 3, 5}

        // Використовуючи двійковий запис цілочисельного значення кожної змінної підрахувати кількість одиниць.
        System.out.println(numberOfOnesInBinaryRepresentation(4));

    }

    // Function that returns count of numbers with even type that matches to numberType variable from given number;
    private static int getCountOfNumbersWithEvenType(int number, NumberEvenityType numberType) {
        int count = 0;
        do {
            var div = number % 10;
            // If numberType is Even
            if (numberType == NumberEvenityType.EVEN) {
                // If div of number is zero
                if (div % 2 == 0) {
                    count++;
                }
                // If numberType is ODD and div of number is one
            } else if (div % 2 == 1) {
                count++;
            }
            number /= 10;
        } while (number > 0);
        return count;
    }

    // Function that converts decimal to binary and returns number of ones in binary representation.
    private static int numberOfOnesInBinaryRepresentation(int decimalNumber) {
        int count = 0;
        String binaryString = Integer.toBinaryString(decimalNumber);
        for (int index = 0; index < binaryString.length(); index++) {
            char currentChar = binaryString.charAt(index);
            if (Character.getNumericValue(currentChar) == 1) {
                count++;
            }
        }
        return count;
    }
}