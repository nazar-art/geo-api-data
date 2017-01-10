package edu.lelyak.utills.datafactory;

import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Random;

public final class RandomDataSource {

    private final DataFactory dataFactory;
    private final Random rand;

    public RandomDataSource() {
        dataFactory = new DataFactory();
        rand = new Random();
    }

    @SneakyThrows
    public Object randomiseEntity(Object entity) {
        if (entity != null) {
            Field[] fields = entity.getClass().getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);

            for (Field field : fields) {
                Class aClass = field.getType();
                boolean isPrimitive = aClass.isPrimitive();

                if (!isPrimitive) {
                    Object val = field.get(entity);
                    randomiseEntity(val);
                }

                if (field.isAnnotationPresent(RandomData.class)) {
                    RandomData data = field.getAnnotation(RandomData.class);

                    switch (data.type()) {
                        case NUMERIC:
                            ReflectionUtils
                                    .setField(field, entity, getNumeric(data.min(), data.max()));
                            break;
                        case NUMERIC_DOUBLE:
                            ReflectionUtils
                                    .setField(field, entity, getNumericDouble(data.min(), data.max()));
                            break;
                    }
                }
            }
        }
        return entity;
    }

    private double getNumericDouble(int min, int max) {
        return rand.doubles(min, max).findFirst().getAsDouble();
    }

    public int getNumeric(int min, int max) {
        return dataFactory.getNumberBetween(min, max);
    }
}
