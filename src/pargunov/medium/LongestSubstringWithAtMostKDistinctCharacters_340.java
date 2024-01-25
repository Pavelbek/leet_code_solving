package pargunov.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters_340 {

    public static void main(String[] args) {
        int res = getLengthOfLongestSubstringKDistinct("eceba", 2);
        System.out.println(res);
    }


    /*
    * как только добавляется 3й символ мы начинаем улалять их из хештаблицы и двигать окно вправо
    * как только осталось 2 значит окно удалило лишнее и безопасно продвинулось вправо windowStart
    * т к нам надо ничанть отсчет от момента когда есть только две уникальных буквы поэтому удаляем и двигаем вправо
    * т к максимальное значение мы считали на каждой итерации оно не пропадет (windowEnd - windowStart) + 1
    * добавляем 1 т к мы считаем количество букв а они начинаются с индекса 0 и нам нужно учесть его, типа индекс
    * всегда на 1 меньше количества.
    * */
    private static int getLengthOfLongestSubstringKDistinct(String s, int k) { //eceba k = 2
        int windowStart = 0;
        int max = 0;
        Map<Character, Integer> soFar = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            var current = s.charAt(windowEnd);
            soFar.compute(current, (key, v) -> v == null ? 1 : v + 1);

            while (soFar.keySet().size() > k) {
                var leftCharacter = s.charAt(windowStart);

                if (soFar.get(leftCharacter) > 1) {
                    soFar.compute(leftCharacter, (key, v) -> v - 1);
                } else {
                    soFar.remove(leftCharacter);
                }
                windowStart++;
            }

            max = Math.max(max, (windowEnd - windowStart) + 1);
        }

        return max;
    }
}
