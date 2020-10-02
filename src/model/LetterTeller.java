package model;

import com.sun.xml.internal.fastinfoset.util.CharArray;

public class LetterTeller {

    public int letterTellen(char letter, String woord) {
        char[] appart = woord.toCharArray();
        int teller = 0;
        for (char a: appart) {
            if (a == letter){
                teller++;
            }
        }
        return teller;
    }
}
