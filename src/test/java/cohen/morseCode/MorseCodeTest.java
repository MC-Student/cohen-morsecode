package cohen.morseCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MorseCodeTest
{
    @Test
    public void toMorseCode()
    {
        //given
        MorseCode interpreter = new MorseCode();

        //when
        String morse = interpreter.toMorseCode("abCdeFghIjk LmnOpqRstUvwXyZ");

        //then
        assertEquals("*-   -***   -*-*   -**   *   **-*   --*   ****   **   *---   -*-       *-**   --   -*   " +
                "---   *--*   --*-   *-*   ***   -   **-   " +
                "***-   *--   -**-   -*--   --**", morse);
    }

    @Test
    public void toMessage()
    {
        //given
        MorseCode interpreter = new MorseCode();

        //when
        String message = interpreter.toMessage("*-   -***   -*-*   -**   *   **-*   --*   ****   **   *---   -*-       *-**   --   -*   ---   *--*   --*-   *-*   ***   -   **-   " +
                "***-   *--   -**-   -*--   --**");

        //then
        assertEquals("ABCDEFGHIJK LMNOPQRSTUVWXYZ", message);
    }
}