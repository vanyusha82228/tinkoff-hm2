package edu.hw10.task2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CacheProxy implements InvocationHandler {
    private final Object target;
    private final Map<String, Object> cache = new ConcurrentHashMap<>();
    private final String cacheDirectory;

    private CacheProxy(Object target, String cacheDirectory) {
        this.target = target;
        this.cacheDirectory = cacheDirectory;
    }

    @SuppressWarnings("unchecked")
    public static <T> T create(Object target, Class<T> interfaceClass, String cacheDirectory) {
        return (T) Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class<?>[]{interfaceClass},
            new CacheProxy(target, cacheDirectory)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Cache cacheAnnotation = method.getAnnotation(Cache.class);

        if (cacheAnnotation != null) {
            String key = method.getName() + Arrays.toString(args);

            if (cache.containsKey(key)) {
                return cache.get(key);
            } else {
                Object result = method.invoke(target, args);
                cache.put(key, result);

                // Если есть аннотация persist и установлен параметр persist в true, сохраняем на диск
                if (cacheAnnotation.persist()) {
                    persistToDisk(key, result);
                }

                return result;
            }
        } else {
            // Если метод не помечен аннотацией Cache, просто вызываем его
            return method.invoke(target, args);
        }
    }

    // Метод для сохранения значения на диск
    private void persistToDisk(String key, Object value) {
        String filePath = cacheDirectory + File.separator + key + ".cache";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(value);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
