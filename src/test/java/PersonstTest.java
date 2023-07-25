import core.Communicator;
import exceptions.PersonsAboveZeroException;
import exceptions.PersonsOnlyException;
import exceptions.PersonsZeroException;
import models.Good;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Consts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonstTest {
    @BeforeEach
    public void initEnvironment() {

    }
    @ParameterizedTest
    @ValueSource(ints = { 0 })
    @DisplayName("Проверка ввода О человек")
    public void enterZeroPersonsTest(int personsCount) {
        Exception exception = assertThrows(PersonsZeroException.class, () ->
                Calculator.createInstance(personsCount, null));
        assertEquals(Consts.ZEROPERSONS_MESSAGE, exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    @DisplayName("Проверка ввода 1 человека")
    public void enterOnlyPersonsTest(int personsCount) {
        Exception exception = assertThrows(PersonsOnlyException.class, () ->
                Calculator.createInstance(personsCount, null));
        assertEquals(Consts.ONLYPERSON_MESSAGE, exception.getMessage());
    }
    @ParameterizedTest
    @ValueSource(ints = { -1 })
    @DisplayName("Проверка ввода -1 человек")
    public void EnterPersonsTest(int personsCount) {
        Exception exception = assertThrows(PersonsAboveZeroException.class, () ->
                Calculator.createInstance(personsCount, null));
        assertEquals(Consts.LOWPERSONS_MESSAGE, exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    @DisplayName("Тест ввода товара")
    public void calculateSum(List<Good> goods) {
        var  count = new AtomicInteger();
        var mockCommunicator = mock(Communicator.class);
        var calculator = Calculator.createInstance(3, mockCommunicator);

        when(mockCommunicator.readString(Consts.ENTER_GOODNAME_PROMT)).thenReturn(goods.get(count.get()).getName());
        when(mockCommunicator.readDouble(Consts.ENTER_PRICE_PROMT)).thenReturn(goods.get(count.get()).getPrice());

        when(mockCommunicator.readBoolean(eq(Consts.FINAL_PROMT), any()))
                .thenAnswer(invocationOnMock -> {
                    count.getAndIncrement();
                    return count.get() < goods.size();
                });

        calculator.readGoods();
        var sum = goods.stream().mapToDouble(Good::getPrice).sum();
        assertThat(calculator.getGoods()).hasSameElementsAs(goods);
        assertEquals(calculator.totalPrice(), sum);
    }

    static Stream<Arguments> provideArguments() {
        var goods = List.of(
                new Good("Твар 1", 10.45f),
                new Good("Твар 2", 1),
                new Good("Твар 3", 11.31),
                new Good("Твар 4", 4.15f));

        return Stream.of(Arguments.of(goods));
    }
}
