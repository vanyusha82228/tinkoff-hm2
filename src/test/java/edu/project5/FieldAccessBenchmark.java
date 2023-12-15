package edu.project5;
import java.io.Serializable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@State(Scope.Thread)
public class FieldAccessBenchmark {
    public static void main(String[] args) throws RunnerException {
        // Конфигурация JMH-теста
        Options options = new OptionsBuilder()
            .include(FieldAccessBenchmark.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .forks(1)
            .warmupForks(1)
            .warmupIterations(1)
            .warmupTime(TimeValue.seconds(5))
            .measurementIterations(1)
            .measurementTime(TimeValue.seconds(5))
            .build();

        new Runner(options).run();
    }

    // POJO (Plain Old Java Object) - класс для тестирования
    record Student(String name, String surname) {
    }

    private Student student;
    private Method reflectionMethod;
    private MethodHandle methodHandle;
    private MySerializableLambda lambda;

    // Метод инициализации перед тестированием
    @Setup
    public void setup() throws NoSuchMethodException, IllegalAccessException {
        // Создание объекта для тестирования
        student = new Student("Ivan", "Makarov");

        // Получение метода через рефлексию
        reflectionMethod = Student.class.getMethod("name");

        // Получение MethodHandle для метода
        methodHandle = MethodHandles.lookup().findVirtual(Student.class, "name", MethodType.methodType(String.class));

        // Создание лямбды с сериализуемым методом
        lambda = getSerializedLambda();
    }

    // Тест: прямой доступ к методу
    @Benchmark
    public void directAccess(Blackhole bh) {
        String name = student.name();
        bh.consume(name);
    }

    // Тест: доступ к методу через рефлексию
    @Benchmark
    public void reflection(Blackhole bh) throws InvocationTargetException, IllegalAccessException {
        reflectionMethod.setAccessible(true); // устанавливаем доступ
        String name = (String) reflectionMethod.invoke(student);
        bh.consume(name);
    }

    // Тест: доступ к методу через MethodHandle
    @Benchmark
    public void methodHandles(Blackhole bh) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(Student.class, "name", MethodType.methodType(String.class));
        String name = (String) mh.invokeExact(student);
        bh.consume(name);
    }

    // Тест: доступ к методу через LambdaMetafactory
    @Benchmark
    public void lambdaMetafactory(Blackhole bh) {
        String methodName = lambda.getImplMethodName();
        bh.consume(methodName);
    }

    // Метод для получения сериализуемой лямбды
    private MySerializableLambda getSerializedLambda() {
        return new MySerializableLambda() {

            @Override
            public String getImplMethodName() {
                return "apply";
            }
        };
    }

    @FunctionalInterface
    interface MySerializableLambda extends Serializable {

        String getImplMethodName();
    }
}
