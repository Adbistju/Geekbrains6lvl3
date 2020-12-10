import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrTest {
    static int [] a = {1,1,1,1,4,4,4,4,1,1};
    static int [] b = {1,1,7,1,4,4,4,4,1,1};
    static int [] c = {1,2,3,4,5,6,7,8,9,0};
    static int [] d = {7,7,7,7,7};
    static int [] e = {1,7,7,7,7};

    @ParameterizedTest
    @MethodSource("shouldStructure")
    void shouldStructure(boolean bool,int[] val) {
        Assertions.assertEquals(bool, Arr.structure(val));
    }
    private static Stream<Arguments> shouldStructure(){
        return Stream.of(
                Arguments.arguments(true,a),
                Arguments.arguments(true,b),
                Arguments.arguments(true,c),
                Arguments.arguments(false,d),
                Arguments.arguments(false,e)
        );
    }

    @ParameterizedTest
    @MethodSource("shouldStructureRuntimeEx")
    void shouldStructureRuntimeEx(int[] val) {
        RuntimeException runtimeException = Assertions.assertThrows(
                RuntimeException.class,
                ()->Arr.searchTo4(val)
        );
        Assertions.assertNotNull(runtimeException);
    }

    private static Stream<int[]> shouldStructureRuntimeEx(){
        return Stream.of(
                null,
                new int[]{}
        );
    }

    @ParameterizedTest
    @MethodSource("shouldsearchTo4")
    void shouldsearchTo4(int[] ex,int[] val) {
        Assertions.assertArrayEquals(ex, Arr.searchTo4(val));
    }
    private static Stream<Arguments> shouldsearchTo4(){
        return Stream.of(
                Arguments.arguments(new int[]{1,1},a),
                Arguments.arguments(new int[]{1,1},b),
                Arguments.arguments(new int[]{5,6,7,8,9,0},c)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("shouldsearchTo4RuntimeEx")
    void shouldsearchTo4RuntimeEx(int[] val) {
        RuntimeException runtimeException = Assertions.assertThrows(
                RuntimeException.class,
                ()->Arr.searchTo4(val)
        );
        Assertions.assertNotNull(runtimeException);
    }

    private static Stream<int[]> shouldsearchTo4RuntimeEx(){
        return Stream.of(
                new int[]{},
                null,
                d,
                e
        );
    }
}