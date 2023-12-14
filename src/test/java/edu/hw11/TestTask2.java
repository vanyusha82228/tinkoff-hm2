package edu.hw11;

import edu.hw11.task2.ArithmeticUtils;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask2 {
    @Test
    public void  ByteBuddyChange() throws InstantiationException, IllegalAccessException {
        Class<?> dynamicType = new ByteBuddy()
            .subclass(ArithmeticUtils.class)
            .method(named("sum"))
            .intercept(MethodDelegation.to(MyInterceptor.class))
            .make()
            .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.INJECTION)
            .getLoaded();

        ArithmeticUtils modifiedInstance = (ArithmeticUtils) dynamicType.newInstance();

        int result = modifiedInstance.sum(2, 3);

        assertEquals(6, result);
    }
    public static class MyInterceptor {

        @RuntimeType
        public static int intercept(@AllArguments Object[] args, @Origin Method method) {
            // Вместо сложения выполняем умножение
            if ("sum".equals(method.getName())) {
                int a = (int) args[0];
                int b = (int) args[1];
                return a * b;
            }
            return 0;
        }
    }
}
