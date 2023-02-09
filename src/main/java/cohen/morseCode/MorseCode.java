package cohen.morseCode;

import java.util.ArrayList;
import java.util.List;

public class MorseCode
{
    private static final String[] alphabet = new String[]{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private final ArrayList<String> english = new ArrayList<>();

    private static final String[] code = new String[]
            {"       ", "*-", "-***", "-*-*", "-**", "*", "**-*", "--*", "****", "**", "*---", "-*-", "*-**", "--", "-*", "---",
                    "*--*", "--*-", "*-*", "***", "-", "**-", "***-", "*--", "-**-", "-*--", "--**"};
    private final ArrayList<String> morseCode = new ArrayList<>();

    public MorseCode()
    {
        english.addAll(List.of(alphabet));
        morseCode.addAll(List.of(code));
    }

    public String toMorseCode(String input)
    {
        String upper = input.toUpperCase();
        String[] message = upper.split("");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length; i++)
        {
            String found = morseCode.get(english.indexOf(message[i]));

            if (found.equals("       ") && !result.substring(result.length() - 1).equals(" "))
            {
                result.append(found);
            }
            else if (found.equals("       "))
            {
                result.delete(result.length() - 3, result.length());
                result.append(found);
            }
            else
            {
                result.append(found).append("   ");
            }
        }

        return String.valueOf(result.substring(0, result.length() - 3));
    }

    public String toMessage(String morse)
    {
        String[] words = morse.split("       ");

        StringBuilder result = new StringBuilder();

        for (int j = 0; j < words.length; j++)
        {
            String[] oneWord = words[j].split("   ");

            for (String s : oneWord)
            {
                String found = english.get(morseCode.indexOf(s));

                result.append(found);
            }

            if (j != words.length - 1)
            {
                result.append(" ");
            }
        }

        return result.toString();
    }
}