package edu.hw11;

import java.lang.reflect.Method;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.junit.jupiter.api.Test;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciGeneratorTest  {
    @Test
    public void testFibonacciGenerator() throws IllegalAccessException, InstantiationException {
        Class<?> dynamicType = new ByteBuddy()
            .subclass(Fibonacci.class)  // Используем интерфейс в качестве суперкласса
            .method(named("fib"))
            .intercept(MethodDelegation.to(FibonacciInterceptor.class))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();

        Fibonacci fibonacci = (Fibonacci) dynamicType.newInstance();

        assertEquals(0, fibonacci.fib(0));
        assertEquals(1, fibonacci.fib(1));
        assertEquals(1, fibonacci.fib(2));
        assertEquals(2, fibonacci.fib(3));
        assertEquals(3, fibonacci.fib(4));
        assertEquals(5, fibonacci.fib(5));
        assertEquals(8, fibonacci.fib(6));
        assertEquals(13, fibonacci.fib(7));
        assertEquals(21, fibonacci.fib(8));
        assertEquals(34, fibonacci.fib(9));
        assertEquals(55, fibonacci.fib(10));
    }

    public static class FibonacciInterceptor {
        @RuntimeType
        public static long intercept(@AllArguments Object[] args, @Origin Method method) {
            int n = (int) args[0];
            return fib(n);
        }

        private static long fib(int n) {
            if (n <= 1) {
                return n;
            } else {
                long[] fibArray = new long[n + 1];
                fibArray[0] = 0;
                fibArray[1] = 1;

                for (int i = 2; i <= n; i++) {
                    fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
                }

                return fibArray[n];
            }
        }
    }

    public interface Fibonacci {
        long fib(int n);
    }
}
