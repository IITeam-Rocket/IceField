package testenv;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class IntArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        int[] lista = {0, 1, 2, 3, 4, 345, 3462, 26, 435, 634};

        return Stream.of(lista).map(Arguments::of);
    }
}
